package com.wt.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.wt.entities.Employee;
import com.wt.service.EmployeeService;

public class EmployeeAction extends ActionSupport implements RequestAware{

	private static final long serialVersionUID = 1L;
	
	private EmployeeService employeeService;
	
	private Map<String, Object> request;
	
	private Integer id;
	
	private InputStream inputStream;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public String delete(){
		
		try {
			employeeService.delete(id);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		
		return "delete";
	}
	
	public String list() {

		List<Employee> employees = employeeService.getAll();
		
		// 以下为测试时使用
//		for (Employee employee : employees) {
//			
//			System.out.println("Lastname --- " + employee.getLastName() );
//			
//		}
		
		request.put("employees", employees);
		
		return "list";
	}
	
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
}
