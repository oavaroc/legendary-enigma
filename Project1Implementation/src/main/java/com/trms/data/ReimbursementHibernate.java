package com.trms.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.trms.models.Reimbursement;
import com.trms.util.HibernateUtil;

public class ReimbursementHibernate implements ReimbursementDAO{
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();

	@Override
	public Reimbursement add(Reimbursement t){
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
	public Reimbursement getById(Integer id) {
		Session s = hu.getSession();
		Reimbursement e = s.get(Reimbursement.class, id);
		s.close();
		return e;
	}

	@Override
	public Set<Reimbursement> getAll() {
		Session s = hu.getSession();
		String query = "FROM Reimbursement";
		Query<Reimbursement> q = s.createQuery(query, Reimbursement.class);
		List<Reimbursement> reimList = q.getResultList();
		Set<Reimbursement> reim = new HashSet<>();
		reim.addAll(reimList);
		s.close();
		return reim;
	}

	@Override
	public void update(Reimbursement t) {
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
	public void delete(Reimbursement t) {
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
