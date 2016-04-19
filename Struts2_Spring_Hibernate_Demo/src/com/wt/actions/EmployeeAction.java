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
	
	private String lastName;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public void setDepartmentServer(DepartmentServer departmentServer) {
		this.departmentServer = departmentServer;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String validateLastName() throws UnsupportedEncodingException{
	
		if(employeeService.lastNameIsValid(lastName)){
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8")); 
		}else{
			inputStream = new ByteArrayInputStream("0".getBytes("UTF-8")); 
		}
		
		return "ajax-success";
	}
	
	public String save() {
		
		System.out.println("getCreateTime---------" + model.getCreateTime());
		
//		if(id == null){
//			model.setCreateTime(new Date());
//		}
		
		employeeService.saveOrUpdate(model);
		
		return SUCCESS;
	}
	
	/**
	 * ���Ը��� id ���ж�Ϊ save ����׼���� model �� new �Ļ��Ǵ����ݿ��ȡ��!
	 */
	public void prepareSave(){
		model = new Employee();
		
//		if(id == null){
//			// ��ʱ�����µ�Ա����Ϊ model �����µĶ��󣬼�Ϊ model ���г�ʼ���ĸ�ֵ
//			model = new Employee();
//		}else{
//			model = employeeService.get(id);
//		}
	}
	
	public String input(){
		
		List<Department> departments = departmentServer.getAll();
		
		request.put("departments", departments);
		
		return INPUT;
	}
	
	public void prepareInput() {
		if(id != null){
			model = employeeService.get(id);
		}
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
		
		return "ajax-success";
	}
	
	public String list() {

		List<Employee> employees = employeeService.getAll();
		
		// ����Ϊ����ʱʹ��
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
	
	// ��ʱ�� model Ϊһ�� Employee ����
	@Override
	public Employee getModel() {

		return model;
	}
	
}
