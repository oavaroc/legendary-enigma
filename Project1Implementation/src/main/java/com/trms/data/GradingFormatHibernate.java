package com.trms.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.trms.models.GradingFormat;
import com.trms.util.HibernateUtil;

public class GradingFormatHibernate implements GradingFormatDAO{
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();

	@Override
	public GradingFormat add(GradingFormat t)  {
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
	public GradingFormat getById(Integer id) {
		Session s = hu.getSession();
		GradingFormat e = s.get(GradingFormat.class, id);
		s.close();
		return e;
	}

	@Override
	public Set<GradingFormat> getAll() {
		Session s = hu.getSession();
		String query = "FROM GradingFormat";
		Query<GradingFormat> q = s.createQuery(query, GradingFormat.class);
		List<GradingFormat> gradeList = q.getResultList();
		Set<GradingFormat> grade = new HashSet<>();
		grade.addAll(gradeList);
		s.close();
		return grade;
	}

	@Override
	public void update(GradingFormat t) {
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
	public void delete(GradingFormat t) {
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
