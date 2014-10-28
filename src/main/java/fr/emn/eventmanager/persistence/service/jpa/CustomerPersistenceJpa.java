/*
 * Created on 28 oct. 2014 ( Time 22:18:22 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */

package fr.emn.eventmanager.persistence.service.jpa;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import fr.emn.eventmanager.bean.Customer;
import fr.emn.eventmanager.persistence.common.jpa.GenericJpaService;
import fr.emn.eventmanager.persistence.common.jpa.JpaOperation;
import fr.emn.eventmanager.persistence.service.CustomerPersistence;

/**
 * JPA implementation for basic persistence operations ( entity "Customer" )
 * 
 * @author Telosys Tools Generator
 *
 */
public class CustomerPersistenceJpa extends GenericJpaService<Customer, Long> implements CustomerPersistence {

	/**
	 * Constructor
	 */
	public CustomerPersistenceJpa() {
		super(Customer.class);
	}

	@Override
	public Customer load( Long customerId ) {
		return super.load( customerId );
	}

	@Override
	public boolean delete( Long customerId ) {
		return super.delete( customerId );
	}

	@Override
	public boolean delete(Customer entity) {
		if ( entity != null ) {
			return super.delete( entity.getCustomerId() );
		}
		return false ;
	}

	@Override
	public long countAll() {
		// JPA operation definition 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object exectue(EntityManager em) throws PersistenceException {
				Query query = em.createNamedQuery("Customer.countAll");
				return query.getSingleResult() ;
			}
		} ;
		// JPA operation execution 
		return (Long) execute(operation);
	}

}
