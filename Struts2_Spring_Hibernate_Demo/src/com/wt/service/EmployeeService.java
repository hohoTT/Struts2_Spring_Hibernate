package com.wt.service;

import java.util.List;

import com.wt.dao.EmployeeDao;
import com.wt.entities.Employee;

public class EmployeeService {
	
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public void delete(Integer id){
		employeeDao.delete(id);
	}
	
	public List<Employee> getAll() {
		List<Employee> employees = employeeDao.getAll();
		
		// 以下的操作实现了将查询出来的集合进行清空，此时前段的显示信息为 --- 没有任何员工信息 
//		employees.clear();
		
		return employees;
	}
	
	public void saveOrUpdate(Employee employee){
		employeeDao.saveOrUpdate(employee);
	}
	
	public boolean lastNameIsValid(String lastName){
		return employeeDao.getEmployeeByLastName(lastName) == null;
	}
	
}
