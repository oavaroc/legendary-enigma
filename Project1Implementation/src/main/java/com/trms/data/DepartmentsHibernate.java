package com.trms.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.trms.models.Departments;
import com.trms.util.HibernateUtil;

public class DepartmentsHibernate implements DepartmentsDAO{
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();

	@Override
	public Departments add(Departments t) {
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
	public Departments getById(Integer id) {
		Session s = hu.getSession();
		Departments d = s.get(Departments.class, id);
		s.close();
		return d;
	}

	@Override
	public Set<Departments> getAll() {
		Session s = hu.getSession();
		String query = "FROM Departments";
		Query<Departments> q = s.createQuery(query, Departments.class);
		List<Departments> deptList = q.getResultList();
		Set<Departments> dept = new HashSet<>();
		dept.addAll(deptList);
		s.close();
		return dept;
	}

	@Override
	public void update(Departments t) {
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
	public void delete(Departments t) {
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
}
