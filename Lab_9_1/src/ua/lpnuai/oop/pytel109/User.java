package ua.lpnuai.oop.pytel109;

import java.awt.*;
import java.io.Serializable;

public class User implements Serializable {
	
	private User next;
	
	public User getNext() {
		return this.next;
	}
	
	public void setNext(User next) {
		this.next = next;
	}
	
	private int id;
	private String firstName;
	private String lastName;
	private int yearOfBd;
	private String education;
	private int salary;
	private String position;
	private String department;
	private String characteristic;
	
	public void setId(int i) {
		id = i;
	}
	public int getId() {
		return id;
	}
	
	public void setFirstName(String name) {
		firstName = name;
	}
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String s) {
		lastName = s;
	}
	public String getLastName(){
		return lastName;
	}
	
	public void setYearOfBd(int n) {
		yearOfBd = n;
	}
	public int getYearOfBd() {
		return yearOfBd;
	}
	
	public void setEducation(String s) {
		education = s;
	}
	public String getEducation() {
		return education;
	}
	
	public void setSalary(int n) {
		salary = n;
	}
	public int getSalary() {
		return salary;
	}
	
	public void setPosition(String s) {
		position = s;
	}
	public String getPosition() {
		return position;
	}
	
	public void setDepartment(String s) {
		department = s;
	}
	public String getDepartment() {
		return department;
	}
	
	public void setCharacteristic(String s) {
		characteristic = s;
	}
	public String getCharacteristic() {
		return characteristic;
	}
}
