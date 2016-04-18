package com.wt.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.wt.entities.Department;
import com.wt.entities.Employee;
import com.wt.service.DepartmentServer;
import com.wt.service.EmployeeService;

public class EmployeeAction extends ActionSupport implements RequestAware,
ModelDriven<Employee>, Preparable{

	private static final long serialVersionUID = 1L;
	
	private EmployeeService employeeService;
	
	private DepartmentServer departmentServer;
	
	private Map<String, Object> request;
	
	private Integer id;
	
	private InputStream inputStream;
	
	private Employee model;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public void setDepartmentServer(DepartmentServer departmentServer) {
		this.departmentServer = departmentServer;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String save() {
		
		System.out.println(model);
		
		model.setCreateTime(new Date());
		employeeService.saveOrUpdate(model);
		
		return SUCCESS;
	}
	
	public void prepareSave() {
		// 此时创建新的员工，为 model 创建新的对象，即为 model 进行初始化的赋值
		model = new Employee();
	}
	
	public String input(){
		
		List<Department> departments = departmentServer.getAll();
		
		request.put("departments", departments);
		
		return INPUT;
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

	@Override
	public void prepare() throws Exception {}
	
	// 此时的 model 为一个 Employee 对象
	@Override
	public Employee getModel() {

		return model;
	}
	
}
