package com.ideacrest.practice;

import java.util.List;

public class Person {
	private String name;
	private List<String> documents;
	private int age;
	
	
	public Person() {

	}
	
	public Person(String name, List<String> documents, int age) {

		this.name = name;
		this.documents = documents;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getDocuments() {
		return documents;
	}
	public void setDocuments(List<String> documents) {
		this.documents = documents;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
