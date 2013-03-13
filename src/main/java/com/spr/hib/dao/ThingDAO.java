package com.spr.hib.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spr.hib.domain.Thing;

@Repository
@Transactional
public class ThingDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger logger = LoggerFactory.getLogger(ThingDAO.class);

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public List<Thing> findAllThings() {
		List<Thing> result = currentSession().createQuery("from Thing").list(); // WARN 'Things' is wrong we shouldnt use table name but entity class name
		return result;
	}

	public List<Thing> findThingsForToday() {
		Query query = currentSession().createQuery("from Thing WHERE startDate <=:now ");
		query.setTimestamp("now", new Date());
		List<Thing> result = query.list();
		return result;
	}

	public List<Thing> findThingsForTomorrow() {
		DateTime tomorrow = new DateTime().plusDays(1);
		// status not finished start date either today or in past
		Query query = currentSession().createQuery("from Thing WHERE startDate <=:now ");
		query.setTimestamp("now", tomorrow.toDate());
		List<Thing> result = query.list();
		return result;
	}

	public List<Thing> findThingsForThisWeek() {

		// status not finished start date either today or in past
		Query query = currentSession().createQuery("from Thing WHERE startDate <=:now ");
		DateTime f = new DateTime();
		int dayOfWeek = f.getDayOfWeek();
		query.setDate("now", f.plusDays(7 - dayOfWeek).toDate());
		List<Thing> result = query.list(); // WARN 'Things' is wrong we shouldnt use table name but entity class name
		return result;
	}

	public void delete(long number) {
		// TODO Auto-generated method stub
		Thing result = (Thing) currentSession().load(Thing.class, number);// INFO diff between load and get - load is a lazy load better for delete and fast
		result.getOwner().getThings().remove(result);// TODO find out a better way of this happening by default..currently it will throw exception if i delete
														// it directly without removing from parent
		currentSession().delete(result);
		// TODO roo style is different but roo using entity manager
		// TODO cant we get the object from the previous list
	}

	// TODO can we not use //@transactional annotation
	public void persist(Thing thing) {
		setMissingDates(thing);
		currentSession().save(thing);
	}

	private static void setMissingDates(Thing thing) {
		if (thing.getStartDate() == null) {
			thing.setStartDate(new Date());
		}
		if (thing.getEndDate() == null) {
			if (thing.getStartDate() == null) {
				thing.setEndDate(new Date());
			} else {
				thing.setEndDate(thing.getStartDate());
			}
		}
	}

	// TODO can we not use //@transactional annotation
	public void merge(Thing thing) {
		setMissingDates(thing);
		currentSession().saveOrUpdate(thing);// TODO wether to use merge or saveorupdate ?? save or update creating new items on update //@version makes update and merge
	}

	public Thing findThing(Long id) {
		if (id == null)
			return null;
		return (Thing) currentSession().get(Thing.class, id);
	}

}
