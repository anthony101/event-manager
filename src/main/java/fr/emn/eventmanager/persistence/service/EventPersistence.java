/*
 * Created on 28 oct. 2014 ( Time 22:18:22 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package fr.emn.eventmanager.persistence.service;

import java.util.List;
import java.util.Map;

import fr.emn.eventmanager.bean.Event;

/**
 * Basic persistence operations for entity "Event"
 * 
 * This Bean has a basic Primary Key : String
 *
 * @author Telosys Tools Generator
 *
 */
public interface EventPersistence {

	/**
	 * Deletes the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param event
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(Event event) ;

	/**
	 * Deletes the entity by its Primary Key <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param eventId
	 * @return true if found and deleted, false if not found
	 */
	public boolean delete(String eventId) ;

	/**
	 * Inserts the given entity and commit <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param event
	 */
	public void insert(Event event) ;

	/**
	 * Loads the entity for the given Primary Key <br>
	 * @param eventId
	 * @return the entity loaded (or null if not found)
	 */
	public Event load(String eventId) ;

	/**
	 * Loads ALL the entities (use with caution)
	 * @return
	 */
	public List<Event> loadAll() ;

	/**
	 * Loads a list of entities using the given "named query" without parameter 
	 * @param queryName
	 * @return
	 */
	public List<Event> loadByNamedQuery(String queryName) ;

	/**
	 * Loads a list of entities using the given "named query" with parameters 
	 * @param queryName
	 * @param queryParameters
	 * @return
	 */
	public List<Event> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) ;

	/**
	 * Saves (create or update) the given entity <br>
	 * Transactional operation ( begin transaction and commit )
	 * @param event
	 * @return
	 */
	public Event save(Event event) ;

	/**
	 * Search the entities matching the given search criteria
	 * @param criteria
	 * @return
	 */
	public List<Event> search( Map<String, Object> criteria ) ;

	/**
	 * Count all the occurrences
	 * @return
	 */
	public long countAll();
	
}