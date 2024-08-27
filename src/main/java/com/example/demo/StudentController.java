package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	
	@GetMapping("/get/student")
	public ResponseEntity<Student> getStudent() {
		
		Student student = Student.builder().name("Hemant Joshi").rollNo(1).class_("VIII").build();
		
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}
	
	
	@GetMapping("/get/student/parent")
	public ResponseEntity<Student> getStudentWithParent() {
		Parent parent = service.getParentRest();
		Student student = Student.builder().name("Hemant Joshi")
											.rollNo(1)
											.class_("VIII")
											.parent(parent)
											.build();
		
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}
	
	@GetMapping("/get/student/parentFeign")
	public ResponseEntity<Student> getStudentWithParentFeign() {
		Parent parent = service.getParentFeign();
		parent.setFeign(true);
		Student student = Student.builder().name("Hemant Joshi")
											.rollNo(1)
											.class_("VIII")
											.parent(parent)
											.build();
		
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}
	
	@GetMapping("/get/parent/{id}")
	public ResponseEntity<Object> getParent(@PathVariable("id") int id) {
		Object obj = service.getParent(id);
		System.out.println(obj);
		
		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}
	
	@GetMapping("/update/parent/{id}")
	public ResponseEntity<Object> updateParent(@PathVariable("id") int id) {
		Object obj = service.updateParent(id);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}
	
	@GetMapping("/add/parent/{id}")
	public ResponseEntity<Object> addParent(@PathVariable("id") int id) {
		Object obj = service.addParent(id);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}
	

}
