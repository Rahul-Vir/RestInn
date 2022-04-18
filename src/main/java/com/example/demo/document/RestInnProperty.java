package com.example.demo.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("RestInnProperty")
public class RestInnProperty {

	@Id
	private String id;
	private String image;
	private String propTitle;
	private String propDescription;
	private String propPrice;
	private String propType;
	private String houseRules;
	private String amenities;
	private Location propLocation;
	private boolean bestseller;
	public RestInnProperty() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestInnProperty(String id, String image, String propTitle, String propDescription, String propPrice,
			String propType, String houseRules, String amenities, Location propLocation, boolean bestseller) {
		super();
		this.id = id;
		this.image = image;
		this.propTitle = propTitle;
		this.propDescription = propDescription;
		this.propPrice = propPrice;
		this.propType = propType;
		this.houseRules = houseRules;
		this.amenities = amenities;
		this.propLocation = propLocation;
		this.bestseller = bestseller;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPropTitle() {
		return propTitle;
	}
	public void setPropTitle(String propTitle) {
		this.propTitle = propTitle;
	}
	public String getPropDescription() {
		return propDescription;
	}
	public void setPropDescription(String propDescription) {
		this.propDescription = propDescription;
	}
	public String getPropPrice() {
		return propPrice;
	}
	public void setPropPrice(String propPrice) {
		this.propPrice = propPrice;
	}
	public String getPropType() {
		return propType;
	}
	public void setPropType(String propType) {
		this.propType = propType;
	}
	public String getHouseRules() {
		return houseRules;
	}
	public void setHouseRules(String houseRules) {
		this.houseRules = houseRules;
	}
	public String getAmenities() {
		return amenities;
	}
	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}
	public Location getPropLocation() {
		return propLocation;
	}
	public void setPropLocation(Location propLocation) {
		this.propLocation = propLocation;
	}
	public boolean isBestseller() {
		return bestseller;
	}
	public void setBestseller(boolean bestseller) {
		this.bestseller = bestseller;
	}
	@Override
	public String toString() {
		return "RestInnProperty [id=" + id + ", image=" + image + ", propTitle=" + propTitle + ", propDescription="
				+ propDescription + ", propPrice=" + propPrice + ", propType=" + propType + ", houseRules=" + houseRules
				+ ", amenities=" + amenities + ", propLocation=" + propLocation + ", bestseller=" + bestseller
				+ ", getId()=" + getId() + ", getImage()=" + getImage() + ", getPropTitle()=" + getPropTitle()
				+ ", getPropDescrition()=" + getPropDescription() + ", getPropPrice()=" + getPropPrice()
				+ ", getPropType()=" + getPropType() + ", getHouseRules()=" + getHouseRules() + ", getAmenities()="
				+ getAmenities() + ", getPropLocation()=" + getPropLocation() + ", isBestseller()=" + isBestseller()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
