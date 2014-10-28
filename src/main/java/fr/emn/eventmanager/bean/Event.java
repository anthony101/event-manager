/*
 * Created on 28 oct. 2014 ( Time 22:18:22 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
// This Bean has a basic Primary Key (not composite) 

package fr.emn.eventmanager.bean;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "EVENT"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="EVENT", schema="APP" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="Event.countAll", query="SELECT COUNT(x) FROM Event x" )
} )
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="EVENT_ID", nullable=false, length=32)
    private String     eventId      ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="EVENT_NAME", nullable=false, length=50)
    private String     eventName    ;

    @Column(name="EVENT_LOCATION", nullable=false, length=50)
    private String     eventLocation ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EVENT_START_DATETIME", nullable=false)
    private Date       eventStartDatetime ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EVENT_END_DATETIME", nullable=false)
    private Date       eventEndDatetime ;

    @Column(name="EVENT_CREATOR_ID", nullable=false)
    private Long       eventCreatorId ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToMany(mappedBy="listOfEvent", targetEntity=Customer.class)
    private List<Customer> listOfCustomer;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public Event() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setEventId( String eventId ) {
        this.eventId = eventId ;
    }
    public String getEventId() {
        return this.eventId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : EVENT_NAME ( VARCHAR ) 
    public void setEventName( String eventName ) {
        this.eventName = eventName;
    }
    public String getEventName() {
        return this.eventName;
    }

    //--- DATABASE MAPPING : EVENT_LOCATION ( VARCHAR ) 
    public void setEventLocation( String eventLocation ) {
        this.eventLocation = eventLocation;
    }
    public String getEventLocation() {
        return this.eventLocation;
    }

    //--- DATABASE MAPPING : EVENT_START_DATETIME ( TIMESTAMP ) 
    public void setEventStartDatetime( Date eventStartDatetime ) {
        this.eventStartDatetime = eventStartDatetime;
    }
    public Date getEventStartDatetime() {
        return this.eventStartDatetime;
    }

    //--- DATABASE MAPPING : EVENT_END_DATETIME ( TIMESTAMP ) 
    public void setEventEndDatetime( Date eventEndDatetime ) {
        this.eventEndDatetime = eventEndDatetime;
    }
    public Date getEventEndDatetime() {
        return this.eventEndDatetime;
    }

    //--- DATABASE MAPPING : EVENT_CREATOR_ID ( BIGINT ) 
    public void setEventCreatorId( Long eventCreatorId ) {
        this.eventCreatorId = eventCreatorId;
    }
    public Long getEventCreatorId() {
        return this.eventCreatorId;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfCustomer( List<Customer> listOfCustomer ) {
        this.listOfCustomer = listOfCustomer;
    }
    public List<Customer> getListOfCustomer() {
        return this.listOfCustomer;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(eventId);
        sb.append("]:"); 
        sb.append(eventName);
        sb.append("|");
        sb.append(eventLocation);
        sb.append("|");
        sb.append(eventStartDatetime);
        sb.append("|");
        sb.append(eventEndDatetime);
        sb.append("|");
        sb.append(eventCreatorId);
        return sb.toString(); 
    } 

}
