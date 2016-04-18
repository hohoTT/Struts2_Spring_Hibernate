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
		
		// ���µĲ���ʵ���˽���ѯ�����ļ��Ͻ�����գ���ʱǰ�ε���ʾ��ϢΪ --- û���κ�Ա����Ϣ 
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
