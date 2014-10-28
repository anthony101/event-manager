/*
 * Created on 28 oct. 2014 ( Time 22:18:22 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */

package fr.emn.eventmanager.persistence.service.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import fr.emn.eventmanager.bean.Event;
import fr.emn.eventmanager.persistence.common.jpa.GenericJpaService;
import fr.emn.eventmanager.persistence.common.jpa.JpaOperation;
import fr.emn.eventmanager.persistence.service.EventPersistence;

/**
 * JPA implementation for basic persistence operations ( entity "Event" )
 * 
 * @author Telosys Tools Generator
 *
 */
public class EventPersistenceJpa extends GenericJpaService<Event, String> implements EventPersistence {

	/**
	 * Constructor
	 */
	public EventPersistenceJpa() {
		super(Event.class);
	}

	@Override
	public Event load( String eventId ) {
		return super.load( eventId );
	}

	@Override
	public boolean delete( String eventId ) {
		return super.delete( eventId );
	}

	@Override
	public boolean delete(Event entity) {
		if ( entity != null ) {
			return super.delete( entity.getEventId() );
		}
		return false ;
	}

	@Override
	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("Event.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
