package com.demo;

import java.util.ArrayList;

public class GradeManager{
	public GradeManager() {
		super();
	}
	ArrayList<Grade> list=new ArrayList<Grade>();
	public boolean add(Grade o) {
			list.add(o);
			return true;
		}
}
