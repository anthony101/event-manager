/*
 * Created on 3 nov. 2014 ( Time 14:40:50 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */

package fr.emn.eventmanager.persistence.service.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import fr.emn.eventmanager.bean.Participant;
import fr.emn.eventmanager.bean.ParticipantKey;
import fr.emn.eventmanager.persistence.common.jpa.GenericJpaService;
import fr.emn.eventmanager.persistence.common.jpa.JpaOperation;
import fr.emn.eventmanager.persistence.service.ParticipantPersistence;

/**
 * JPA implementation for basic persistence operations ( entity "Participant" )
 * 
 * @author Telosys Tools Generator
 *
 */
public class ParticipantPersistenceJpa extends GenericJpaService<Participant, ParticipantKey> implements ParticipantPersistence {

	/**
	 * Constructor
	 */
	public ParticipantPersistenceJpa() {
		super(Participant.class);
	}

	@Override
	public Participant load( Integer participantEventId, Integer participantCustomerId ) {
		// Build the composite key
		ParticipantKey key = new ParticipantKey( participantEventId, participantCustomerId );
		return super.load( key );
	}

	@Override
	public boolean delete( Integer participantEventId, Integer participantCustomerId ) {
		// Build the composite key
		ParticipantKey key = new ParticipantKey( participantEventId, participantCustomerId );
		return super.delete( key );
	}

	@Override
	public boolean delete(Participant entity) {
		if ( entity != null ) {
			// Build the composite key
			ParticipantKey key = new ParticipantKey( entity.getParticipantEventId(), entity.getParticipantCustomerId() );
			return super.delete( key );
		}
		return false ;
	}

	@Override
	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("Participant.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
