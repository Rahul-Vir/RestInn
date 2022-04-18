package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.document.RestInnProperty;
import com.example.demo.repository.RestInnPropertyRepository;

@Service
public class ServiceProperty {

	@Autowired
	RestInnPropertyRepository propertyRepo;
	
	public List<RestInnProperty> getAllProperties(){
		if(propertyRepo.findAll().isEmpty()) {
			return null;
		}
		else {
			return propertyRepo.findAll();
		}
		
	}
	
	public RestInnProperty createProperty(RestInnProperty property) {
		for(RestInnProperty prop : propertyRepo.findAll())
		if(property.getPropLocation().getStreetAddress().equals(prop.getPropLocation().getStreetAddress())) {
			return new RestInnProperty();
		}
		return propertyRepo.save(property);
	}
	
	public RestInnProperty getPropertyById(String propertyId){
		Optional<RestInnProperty> property = propertyRepo.findById(propertyId);
		if(property.isPresent()) {
			return property.get();
		}
		else
		{
			return new RestInnProperty();
		}
	}
	public List<RestInnProperty> getPropertyByTitle(String propTitle, String propType){
		if(propertyRepo.findByPropTitle(propTitle).isEmpty()) {
			return new ArrayList();
		}
		else
		{
			List<RestInnProperty> property = new ArrayList();
			
			for(RestInnProperty property1: propertyRepo.findByPropTitle(propTitle)) {
				if(property1.getPropType().equals(propType)) {
					property.add(property1);
				}
			}
			
			if(property.isEmpty() &&  propType.equals("empty")) {
			
			return propertyRepo.findByPropTitle(propTitle);
			}
			else
			{
				
				return property;
			}
		}
	}
	
	public List<RestInnProperty> getPropertyByType(String propType){
		if(propertyRepo.findByPropType(propType).isEmpty()) {
			return null;
		}
		else
		{
			return propertyRepo.findByPropType(propType);
		}
	}
	
	public List<RestInnProperty> getBestseller(boolean bestseller){
		if(propertyRepo.findByBestseller(bestseller).isEmpty()){
			return null;
		}
		else {
			return propertyRepo.findByBestseller(bestseller);
		}
	}
	
	public String deleteProperty(String id) {
		if(propertyRepo.findById(id).isPresent()) {
			propertyRepo.deleteById(id);
			return "The property information has been deleted!";
		}else {
			return "Property not found!";
		}
		
	}

	public RestInnProperty updateProperty(RestInnProperty property, String id) {
		if(propertyRepo.findById(id).isPresent()) {
			property.setId(id);
			return propertyRepo.save(property);
		}
		else {
			return new RestInnProperty();
		}
	}
	
	}


