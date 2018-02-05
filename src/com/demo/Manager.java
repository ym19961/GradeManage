package com.demo;
import java.sql.*;
import java.util.ArrayList;
public class Manager {
    public Statement stmt;
    public ResultSet rs ;
    public Connection connect ;
    ArrayList<String> arr=new ArrayList<String>();
    public Manager() {
    	try {
		      Class.forName("com.mysql.jdbc.Driver");       
		    }
		    catch (Exception e) {
		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","songj123.");
		      stmt = connect.createStatement();
		    }
		    catch (Exception e) {
		        e.printStackTrace();
		    }    
	}
	public boolean addStudent(String id,String name,String password,String Class) throws SQLException {
		       rs=stmt.executeQuery("Select * from Student where StudentId='"+id+"'");
			   if(rs.next()) {
				   System.out.println("此用户已存在");
				   return false;
			   }
			   stmt.executeUpdate("INSERT INTO Student VALUES ('"+id+"','"+name+"','"+password+"','"+Class+"')");
			   return true; 
		 
		  }
	public boolean addTeacher(String id,String name,String password,String code) throws SQLException {
	    rs=stmt.executeQuery("Select * from ActivationCode where ActivationCode='"+code+"'");
	    if(!rs.next()){
	    	System.out.println("激活码不存在");
	    	   return false;
	    }else{
	  	   System.out.println("激活成功");
	    }
	    rs=stmt.executeQuery("Select * from Teacher where TeacherId='"+id+"'");
		if(rs.next()) {
			System.out.println("此用户已存在");
			return false;
		}
		stmt.executeUpdate("INSERT INTO Teacher VALUES ('"+id+"','"+name+"','"+password+"')"); //将教师信息录入数据库
		stmt.executeUpdate("DELETE FROM ActivationCode where ActivationCode='"+code+"'"); //删除用过的激活码
		return true;  
	  }
	public boolean addGrade(String id,String CourseId,int grade) throws SQLException {
	    stmt.executeUpdate("INSERT  INTO Grade VALUES ('"+id+"','"+CourseId+"',"+grade+")");
		return true;  
	  }
	public boolean SearchStudent(String id,String password) throws SQLException {
		String sql="select * from Student";
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			if(rs.getString("StudentId").equals(id)) {
				if(rs.getString("StudentPassword").equals(password)){
					System.out.println("登录成功");
					return true;
				}
			}
		}
		System.out.println("学号或密码错误，登录失败");
		return false;
	}
	public boolean SearchTeacher(String id,String password) throws SQLException {
		String sql="select * from Teacher";
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			if(rs.getString("TeacherId").equals(id)) {
				if(rs.getString("TeacherPassword").equals(password)){
					System.out.println("登录成功");
					return true; 
				}
			}
		}
		System.out.println("教工号或密码错误，登录失败");
		return false;
	}
	public int getNumber() throws SQLException{
		rs = stmt.executeQuery("select * from student");
		rs.last();
		return rs.getRow();
	}
	public String getStudentId(int i) throws SQLException {
		rs = stmt.executeQuery("select * from student");
		arr.clear();
		while(rs.next()){
			arr.add(rs.getString(1));
		}
		return arr.get(i);
	}
	public String getStudentName(int i) throws SQLException {
		rs = stmt.executeQuery("select * from student");
		arr.clear();
		while(rs.next()){
			arr.add(rs.getString(2));
		}
		return arr.get(i);
	}
	public String getTeacherName(String TeacherId) throws SQLException {
		rs = stmt.executeQuery("select * from teacher where TeacherId='"+TeacherId+"'");
		arr.clear();
		while(rs.next())
			arr.add(rs.getString("TeacherName"));
		return arr.get(0);
	}
	public void clos() throws SQLException {
		    	connect.close();
		    	System.out.println("数据库已关闭");
		    }
	
}

