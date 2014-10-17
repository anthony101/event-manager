package fr.emn.eventmanager.bean;

import java.util.Date;

public class Event {

	private String id;
	private String name;
	private Location address;
	private Date startDate;
	private Date endDate;
	
	public Event() {
		super();
		//TODO:MB: auto generation of id
		this.id = "";
	}

	public Event(String name, Location address, Date startDate, Date endDate) {
		super();
		//TODO:MB: auto generation of id
		this.id = "";
		this.name = name;
		this.address = address;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getAddress() {
		return address;
	}

	public void setAddress(Location address) {
		this.address = address;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
