package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.document.RestInnProperty;

@Repository
public interface RestInnPropertyRepository extends MongoRepository <RestInnProperty, String> {
  
	public List<RestInnProperty> findByPropType(String propType);
	public List<RestInnProperty> findByPropTitle(String propTitle);
	public List<RestInnProperty> findByBestseller(boolean bestseller);
}
