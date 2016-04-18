package com.wt.service;

import java.util.List;

import com.wt.dao.DepartmentDao;
import com.wt.entities.Department;

public class DepartmentServer {
	
	private DepartmentDao departmentDao;
	
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	public List<Department> getAll(){
		return departmentDao.getAll();
	}

}
