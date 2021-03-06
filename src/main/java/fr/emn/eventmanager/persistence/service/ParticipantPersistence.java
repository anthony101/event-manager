/*
 * Created on 3 nov. 2014 ( Time 14:40:50 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package fr.emn.eventmanager.persistence.service;

import java.util.List;
import java.util.Map;

import fr.emn.eventmanager.bean.Participant;

/**
 * Basic persistence operations for entity "Participant"
 * 
 * This Bean has a composite Primary Key : ParticipantKey
 *
 * @author Telosys Tools Generator
 *
 */
public interface ParticipantPersistence {

	/**
	 * Deletes the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param participant
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(Participant participant) ;

	/**
	 * Deletes the entity by its Primary Key <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param participantEventId
	 * @param participantCustomerId
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(Integer participantEventId, Integer participantCustomerId) ;

	/**
	 * Inserts the given entity and commit <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param participant
	 */
	public void insert(Participant participant) ;

	/**
	 * Loads the entity for the given Primary Key <br>
	 * @param participantEventId
	 * @param participantCustomerId
	 * @return the entity loaded (or null if not found)
	 */
	public Participant load(Integer participantEventId, Integer participantCustomerId) ;

	/**
	 * Loads ALL the entities (use with caution)
	 * @return
	 */
	public List<Participant> loadAll() ;

	/**
	 * Loads a list of entities using the given "named query" without parameter 
	 * @param queryName
	 * @return
	 */
	public List<Participant> loadByNamedQuery(String queryName) ;

	/**
	 * Loads a list of entities using the given "named query" with parameters 
	 * @param queryName
	 * @param queryParameters
	 * @return
	 */
	public List<Participant> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) ;

	/**
	 * Saves (create or update) the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param participant
	 * @return
	 */
	public Participant save(Participant participant) ;

	/**
	 * Search the entities matching the given search criteria
	 * @param criteria
	 * @return
	 */
	public List<Participant> search( Map<String, Object> criteria ) ;

	/**
	 * Count all the occurrences
	 * @return
	 */
	public long countAll();
	
}
