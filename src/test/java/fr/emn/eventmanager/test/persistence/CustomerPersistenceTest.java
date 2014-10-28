/*
 * Created on 28 oct. 2014 ( Time 22:18:22 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package fr.emn.eventmanager.test.persistence;


import fr.emn.eventmanager.bean.Customer;
import fr.emn.eventmanager.mock.CustomerMock;
import fr.emn.eventmanager.persistence.PersistenceServiceProvider;
import fr.emn.eventmanager.persistence.service.CustomerPersistence;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for Customer persistence service
 * 
 * @author Telosys Tools Generator
 *
 */
public class CustomerPersistenceTest 
{
	@Test
	public void test1() {
		
		System.out.println("Test count ..." );
		
		CustomerPersistence service = PersistenceServiceProvider.getService(CustomerPersistence.class);
		System.out.println("CountAll = " + service.countAll() );
	}
	
	@Test
	public void test2() {
		
		System.out.println("Test Customer persistence : delete + load ..." );
		
		CustomerPersistence service = PersistenceServiceProvider.getService(CustomerPersistence.class);
		
		CustomerMock mock = new CustomerMock();
		
		// TODO : set primary key values here 
		process( service, mock, (long)0  );
		// process( service, mock, ... );
	}

	private void process(CustomerPersistence service, CustomerMock mock, Long customerId ) {
		System.out.println("----- "  );
		System.out.println(" . load : " );
		Customer entity = service.load( customerId );
		if ( entity != null ) {
			// Found 
			System.out.println("   FOUND : " + entity );
			
			// Save (update) with the same values to avoid database integrity errors  
			System.out.println(" . save : " + entity );
			service.save(entity);
			System.out.println("   saved : " + entity );
		}
		else {
			// Not found 
			System.out.println("   NOT FOUND" );
			// Create a new instance 
			entity = mock.createInstance( customerId ) ;
			Assert.assertNotNull(entity);

			// No reference : insert is possible 
			// Try to insert the new instance
			System.out.println(" . insert : " + entity );
			service.insert(entity);
			System.out.println("   inserted : " + entity );

			System.out.println(" . delete : " );
			boolean deleted = service.delete( customerId );
			System.out.println("   deleted = " + deleted);
			Assert.assertTrue(deleted) ;
		}		
	}
}
