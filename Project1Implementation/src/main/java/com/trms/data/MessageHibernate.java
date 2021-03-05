package com.trms.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.trms.models.Message;
import com.trms.util.HibernateUtil;

public class MessageHibernate implements MessageDAO{
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();

	@Override
	public Message add(Message t) {
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
	public Message getById(Integer id) {
		Session s = hu.getSession();
		Message e = s.get(Message.class, id);
		s.close();
		System.out.println(e);
		return e;
	}

	@Override
	public Set<Message> getAll() {
		Session s = hu.getSession();
		String query = "FROM Message";
		Query<Message> q = s.createQuery(query, Message.class);
		List<Message> messageList = q.getResultList();
		Set<Message> message = new HashSet<>();
		message.addAll(messageList);
		s.close();
		return message;
	}

	@Override
	public void update(Message t) {
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
	public void delete(Message t) {
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
