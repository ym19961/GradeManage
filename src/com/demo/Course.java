package com.demo;

public class Course {
	protected String CourseName;
	public Course() {}
	public Course(String name) {
		this.CourseName=name;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CourseName == null) ? 0 : CourseName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (CourseName == null) {
			if (other.CourseName != null)
				return false;
		} else if (!CourseName.equals(other.CourseName))
			return false;
		return true;
	}
	
}

