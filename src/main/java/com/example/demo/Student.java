package com.example.demo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8079116237402696516L;
	private String name;
	private int rollNo;
	private String class_;
	private Parent parent;

}
