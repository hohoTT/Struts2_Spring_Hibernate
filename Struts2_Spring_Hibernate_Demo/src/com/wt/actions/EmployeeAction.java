package com.wt.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.wt.entities.Employee;
import com.wt.service.EmployeeService;

public class EmployeeAction extends ActionSupport implements RequestAware{

	private static final long serialVersionUID = 1L;
	
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
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

	private Map<String, Object> request;
	
	
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
}
