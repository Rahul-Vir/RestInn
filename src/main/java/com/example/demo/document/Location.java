package com.example.demo.document;

import org.springframework.beans.factory.annotation.Autowired;

public class Location {

	private String streetAddress;
	private String city;
	private String postalCode;
	private String province;
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public Location(String streetAddress, String city, String postalCode, String province) {
		super();
		this.streetAddress = streetAddress;
		this.city = city;
		this.postalCode = postalCode;
		this.province = province;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@Override
	public String toString() {
		return "Location [streetAddress=" + streetAddress + ", city=" + city + ", postalCode=" + postalCode
				+ ", province=" + province + ", getStreetAddress()=" + getStreetAddress() + ", getCity()=" + getCity()
				+ ", getPostalCode()=" + getPostalCode() + ", getProvince()=" + getProvince() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
