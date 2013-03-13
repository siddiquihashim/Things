package com.spr.hib.domain.hibernate.intercepter;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
//INTERCEPTOR
public class AuditInterceptor extends EmptyInterceptor {

	private int counter;
	private static final long serialVersionUID = 1L;

	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {

		System.out.println("inside onFlusDirty " + counter++);
		if (entity instanceof AutoLastUpdate) {
			 for ( int i=0; i < propertyNames.length; i++ ) {
	                if ( "lastUpdated".equals( propertyNames[i] ) ) {
	                    currentState[i] = new Date();
	                    return true;
	                }
	            }
			return true;
		}

		return false;
	}

	public boolean onSave(Object entity, Serializable id, Object[] currentState, String[] propertyNames, Type[] types) {
		System.out.println("inside onSave " + counter++ );
		if (entity instanceof AutoLastUpdate) {
			 for ( int i=0; i < propertyNames.length; i++ ) {
	                if ( "lastUpdated".equals( propertyNames[i] ) ) {// TODO lastupdated propertyname should be like string
	                    currentState[i] = new Date();
	                    return true;
	                }
	            }
			return true;
		}

		return false;
	}

}