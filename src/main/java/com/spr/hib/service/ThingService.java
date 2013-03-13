package com.spr.hib.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spr.hib.dao.ThingDAO;
import com.spr.hib.domain.Thing;
@Service
public class ThingService {

	private static final Logger logger = LoggerFactory.getLogger(ThingService.class);

	@Autowired
	private ThingDAO thingDAO;

	public List<Thing> findAllThings() {
		return thingDAO.findAllThings();
	}

	public List<Thing> findThingsForToday() {
		return thingDAO.findThingsForToday();
	}

	public List<Thing> findThingsForTomorrow() {
		return thingDAO.findThingsForTomorrow();
	}

	public List<Thing> findThingsForThisWeek() {
		return thingDAO.findThingsForThisWeek();
	}

	public void delete(long number) {
		thingDAO.delete(number);
	}

	public void persist(Thing thing) {
		thingDAO.persist(thing);
	}

	public void merge(Thing thing) {
		thingDAO.merge(thing);

	}

	public Thing findThing(Long id) {
		return thingDAO.findThing(id);
	}

}
