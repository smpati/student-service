package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentService {
	
	@Value("${parent.service.url}")
	private String parentServiceEndpoint;
	
	@Autowired
	private ParentClient client;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Parent getParentRest() {
		
		ResponseEntity<Parent> responseE = restTemplate.getForEntity(parentServiceEndpoint, Parent.class);
		return responseE.getBody();
		
	}
	
	public Parent getParentFeign() {
		
		return client.getParent();
		
	}
	
	public Parent getParent(int id) {
		
		if(id==1) {
			return getParentRest();
		} else {
			throw new NoParentAvailable("No parent is available with Id: "+id);
		}
		
	}
	
	public Parent addParent(int id) {
		
		if(id==1) {
			return getParentRest();
		} else {
			throw new ParentAlreadyExist("Parent is already present with Id: "+id);
		}
		
	}
	
	public Parent updateParent(int id) {
		
		if(id==1) {
			return getParentRest();
		} else {
			throw new NoSuchParentExist("Unable to update, No such parent with Id: "+id);
		}
		
	}
	
	
	
	

}
