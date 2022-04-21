package com.example.demo.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.document.RestInnProperty;
import com.example.demo.service.ServiceProperty;

@CrossOrigin
@RestController
public class PropertyController {

	@Autowired
	ServiceProperty serviceProp;
	
	@GetMapping("/propertylist")
	public ResponseEntity<List<RestInnProperty>> getProperty(){
		
		if(serviceProp.getAllProperties()==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			return ResponseEntity.of(Optional.of(serviceProp.getAllProperties()));
		}
		
	}
	
	@PostMapping("/createproperty")
	public ResponseEntity<RestInnProperty> createProperty(@RequestBody RestInnProperty property){
		RestInnProperty p1 = serviceProp.createProperty(property);
		if (p1.getId() == null) {
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
		} else {
			return ResponseEntity.of(Optional.of(p1));
		}
	}
	
	@GetMapping("/propertylist/{id}")
	public ResponseEntity<RestInnProperty> getPropertyById(@PathVariable String id){
		if(serviceProp.getPropertyById(id).getId()==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			return ResponseEntity.of(Optional.of(serviceProp.getPropertyById(id)));
		}
	}
//	
	@GetMapping("/propertybytitle")
	public ResponseEntity<List<RestInnProperty>> getPropertyByTitle( @RequestParam(defaultValue = "empty") String propTitle, @RequestParam(defaultValue = "empty") String propType)
	{
		if(serviceProp.getPropertyByTitle(propTitle, propType).isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.of(Optional.of(serviceProp.getPropertyByTitle(propTitle, propType)));
		}
	}
	
	@GetMapping("/property/type")
	public 	ResponseEntity<List<RestInnProperty>> getAllPropertyBySection(){
		List<RestInnProperty> property=new ArrayList();
		boolean  flag;
		for(RestInnProperty p:serviceProp.getAllProperties()) {
			if(property.isEmpty()) {
				property.add(p);
			}else {
				flag = true;
				for(RestInnProperty p2 : property) {
					if(p.getPropType().toLowerCase().equals(p2.getPropType().toLowerCase())) {
						flag = false;
						break;
					}
			}
				if(flag) {
					property.add(p);
				}
			}
		}
		if(property.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.of(Optional.of(property));
		}
	}
	
	@GetMapping("/propertybytype/{propType}")
	public ResponseEntity<List<RestInnProperty>> getPropertyByType(@PathVariable String propType){
		if(serviceProp.getPropertyByType(propType)==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			return ResponseEntity.of(Optional.of(serviceProp.getPropertyByType(propType)));
		}
	}
	
	@GetMapping("/property/bestseller")
	public ResponseEntity<List<RestInnProperty>> getBestseller(@RequestParam boolean bestseller){
		if(serviceProp.getBestseller(bestseller)==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			return ResponseEntity.of(Optional.of(serviceProp.getBestseller(bestseller)));
		}
		
	}
	
	@DeleteMapping("property/del/{id}")
	public ResponseEntity<String> deleteProperty(@PathVariable String id){
		String result = serviceProp.deleteProperty(id);
		if(result.equals("Property not found!")) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.of(Optional.of(result));
		}
		
	}
	
	@PutMapping("property/update/{id}")
	public ResponseEntity<RestInnProperty> updateProperty(@RequestBody RestInnProperty property, @PathVariable String id){
		RestInnProperty property1 = serviceProp.updateProperty(property, id);
		if(property1.getId() == null) {
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
		}
		return ResponseEntity.of(Optional.of(property1));
	}
//	
	
	}



