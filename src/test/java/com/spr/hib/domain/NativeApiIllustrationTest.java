/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2010, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package com.spr.hib.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



/**
 * Illustrates use of Hibernate native APIs.
 *
 * @author Steve Ebersole
 */
//TODO Convert this test to use spring sessionfactory
public class NativeApiIllustrationTest extends TestCase {
	private SessionFactory sessionFactory;
	private ServiceRegistry serviceRegistry;

	private SessionFactory configureSessionFactory() throws HibernateException {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}

	@Override
	protected void setUp() throws Exception {
		
		// A SessionFactory is set up once for an application
        sessionFactory = configureSessionFactory();// configures settings from hibernate.cfg.xml
	}

	@Override
	protected void tearDown() throws Exception {
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}
	}

	public void testBasicUsage() {
		

		Session session = sessionFactory.openSession();
		session.getTransaction().begin();

		Thing thing = new Thing();
		Person p = new Person();p.setName("abwwddw");p.setEmail("EALL@em42ail.com");
		thing.setTitle("via person1");
		thing.setStatus(Status.FINISHED);
		thing.setOwner(p);
		Set<Thing> things = new HashSet<Thing>();
		things.add(thing);
		
		p.setThings(things );
		session.save(p);
		//session.save(thing);
		
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Thing WHERE startDate <=:now " );
		query.setTimestamp("now", new Date());
		List<Thing> result = query.list(); 
		for (Thing thing2 : (List<Thing>) result) {
			System.out.println( thing2.getTags().size());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	
}
