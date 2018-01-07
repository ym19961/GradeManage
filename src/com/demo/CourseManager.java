package com.demo;

import java.util.ArrayList;

public class CourseManager{
	public CourseManager() {
		super();
	}
	protected ArrayList<Course> list=new ArrayList<Course>();
	public boolean add(Course o) {
		if(list.contains(o)) 
			return false;
		else {
			list.add(o);
			return true;
		}
	}
}
