package com.trms.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.trms.models.Employee;
import com.trms.util.HibernateUtil;

public class EmployeeHibernate implements EmployeeDAO{
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();

	@Override
	public Employee add(Employee t) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(t);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) tx.rollback();
		} finally {
			s.close();
		}
		return t;
	}

	@Override
	public Employee getById(Integer id) {
		Session s = hu.getSession();
		Employee e = s.get(Employee.class, id);
		s.close();
		return e;
	}

	@Override
	public Set<Employee> getAll() {
		Session s = hu.getSession();
		String query = "FROM Employee";
		Query<Employee> q = s.createQuery(query, Employee.class);
		List<Employee> empList = q.getResultList();
		Set<Employee> emp = new HashSet<>();
		emp.addAll(empList);
		s.close();
		return emp;
	}

	@Override
	public void update(Employee t) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(t);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) tx.rollback();
		} finally {
			s.close();
		}
		
	}

	@Override
	public void delete(Employee t) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(t);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) tx.rollback();
		} finally {
			s.close();
		}
		
	}

	@Override
	public Employee getEmployeeByUsername(String u) {
		Session s = hu.getSession();
		// Criteria API: make queries w/ programmatic syntax
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
		Root<Employee> root = criteria.from(Employee.class);
		
		Predicate predicateForUsername = cb.equal(root.get("username"), u);
		// Predicate predicateForPassword = cb.equal(root.get("password"), password);
		// Predicate predicateForBoth = cb.and(predicateForUsername, predicateForPassword);
		
		criteria.select(root).where(predicateForUsername);
		
		Employee p = s.createQuery(criteria).getSingleResult();
		return p;
	}

}
