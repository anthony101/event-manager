package fr.emn.eventmanager.bean;

import java.util.Date;
import java.util.UUID;

public class Event {

	private String id;
	private String name;
	private String location;
	private Date startDate;
	private Date endDate;

	public Event(String name, String location, Date startDate, Date endDate) {
		id = UUID.randomUUID().toString().replace("-", "");
		this.name = name;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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
