package fr.emn.eventmanager.bean;

public class Location {
	
	private String id;
	private String city;
	private int zipCode;
	private String street;
	private int streetNum;
	
	public Location() {
		super();
		//TODO:MB auto generation of id
		this.id = "";
	}

	public Location(String city, int zipCode, String street, int streetNum) {
		super();
		//TODO:MB auto generation of id
		this.id = "";
		this.city = city;
		this.zipCode = zipCode;
		this.street = street;
		this.streetNum = streetNum;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getStreetNum() {
		return streetNum;
	}

	public void setStreetNum(int streetNum) {
		this.streetNum = streetNum;
	}
}
