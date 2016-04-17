package com.wt.service;

import java.util.List;

import com.wt.dao.EmployeeDao;
import com.wt.entities.Employee;

public class EmployeeService {
	
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}
	
}
