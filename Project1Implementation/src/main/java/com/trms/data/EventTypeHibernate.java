package com.trms.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.trms.models.EventType;
import com.trms.util.HibernateUtil;

public class EventTypeHibernate implements EventTypeDAO{
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();

	@Override
	public EventType add(EventType t)  {
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
	public EventType getById(Integer id) {
		Session s = hu.getSession();
		EventType e = s.get(EventType.class, id);
		s.close();
		return e;
	}

	@Override
	public Set<EventType> getAll() {
		Session s = hu.getSession();
		String query = "FROM EventType";
		Query<EventType> q = s.createQuery(query, EventType.class);
		List<EventType> eventList = q.getResultList();
		Set<EventType> event = new HashSet<>();
		event.addAll(eventList);
		s.close();
		return event;
	}

	@Override
	public void update(EventType t) {
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
	public void delete(EventType t) {
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
