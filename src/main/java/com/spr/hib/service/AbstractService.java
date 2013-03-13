package com.spr.hib.service;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.spr.hib.domain.hibernate.intercepter.AuditInterceptor;
//TODO delete me as we using inline hibernate
public abstract class AbstractService {

	protected static SessionFactory sessionFactory;

	static {
		configureSessionFactory();// TODO does sessionFactory thread safe - yes it is as per hibernate document The org.hibernate.cfg.Configuration then creates
									// the org.hibernate.SessionFactory which is a thread-safe object that is instantiated once to serve the entire application
	}

	protected static SessionFactory configureSessionFactory() throws HibernateException {
		Configuration configuration = new Configuration();
		configuration.setInterceptor(new AuditInterceptor());//INTERCEPTOR
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

}
