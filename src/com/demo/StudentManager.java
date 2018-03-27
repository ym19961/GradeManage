package com.demo;

import java.util.ArrayList;

public class StudentManager{
	public StudentManager() {
		super();
	}
	ArrayList<Student> list=new ArrayList<Student>();
	public boolean add(Student o) {
		if(list.contains(o)) 
			return false;
		else {
			list.add(o);
			return true;
		}
	}
}