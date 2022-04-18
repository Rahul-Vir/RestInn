package com.example.demo.document;

public class Registration {
	private String firstName;
	private String lastName;
	private String number;
	private String email;
	private String city;
	private String streetAddress;
	private String postalCode;
	private String password;
	private String province;
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Registration(String firstName, String lastName, String number, String email, String city,
			String streetAddress, String postalCode, String password, String province) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.email = email;
		this.city = city;
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.password = password;
		this.province = province;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@Override
	public String toString() {
		return "Registration [firstName=" + firstName + ", lastName=" + lastName + ", number=" + number + ", email="
				+ email + ", city=" + city + ", streetAddress=" + streetAddress + ", postalCode=" + postalCode
				+ ", password=" + password + ", province=" + province + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getNumber()=" + getNumber() + ", getEmail()=" + getEmail()
				+ ", getCity()=" + getCity() + ", getStreetAddress()=" + getStreetAddress() + ", getPostalCode()="
				+ getPostalCode() + ", getPassword()=" + getPassword() + ", getProvince()=" + getProvince()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
