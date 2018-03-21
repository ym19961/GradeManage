package com.demo;

public class Student {
	protected String StudentId;
	protected String StudentName;
	public Student() {}
	public Student(String id,String name) {
		this.StudentId=id;
		this.StudentName=name;
	}
	public String getStudentId() {
		return StudentId;
	}
	public void setStudentId(String studentId) {
		StudentId = studentId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	
	@Override
	public String toString() {
		return "Student [StudengId=" + StudentId + ", StudentName=" + StudentName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((StudentId == null) ? 0 : StudentId.hashCode());
		result = prime * result + ((StudentName == null) ? 0 : StudentName.hashCode());
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
		Student other = (Student) obj;
		if (StudentId == null) {
			if (other.StudentId != null)
				return false;
		} else if (!StudentId.equals(other.StudentId))
			return false;
		if (StudentName == null) {
			if (other.StudentName != null)
				return false;
		} else if (!StudentName.equals(other.StudentName))
			return false;
		return true;
	}
}
