package com.wt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.wt.entities.Employee;

public class EmployeeDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	public List<Employee> getAll(){
		
		String hql = "FROM Employee e LEFT OUTER JOIN FETCH e.department";
		
		return getSession().createQuery(hql).list();
	}

	public void delete(Integer id){
		
		String hql = "DELETE FROM Employee e WHERE e.id = ?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
		
	}
	
}
