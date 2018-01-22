package com.demo;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelCourse {
	public void creatExcel(OutputStream os,String id)throws WriteException,IOException{
		Manager manager=new Manager();	
		int m=0;
		//String id=request.getParameter("id");
		String sql="select Student.StudentId,StudentName,Grade from Student,Grade where Student.StudentId=Grade.StudentId and CourseId='"+id+"'";
		try {
			manager.rs=manager.stmt.executeQuery(sql);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		StudentManager st=new StudentManager();
	 	GradeManager gr=new GradeManager();
	 	Student []s=new Student[50];
	 	Grade []g=new Grade[50];
		try {
			while(manager.rs.next()){
				String Sid=manager.rs.getString("StudentId");
				String Sname=manager.rs.getString("StudentName");
				int grade=manager.rs.getInt("Grade");
				s[m]=new Student(Sid,Sname);
				g[m]=new Grade(grade);
				st.add(s[m]);
				gr.add(g[m]);
				m++;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(manager.rs!=null){
			try {
				manager.rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(manager.stmt!=null){
			try {
				manager.stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(manager.connect!=null){
			try {
				manager.connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		WritableWorkbook workbook =Workbook.createWorkbook(os);
		WritableSheet sheet=workbook.createSheet("Frist Sheet", 0);
		Label xuehao=new Label(0,0,"Ñ§ºÅ");
		try {
			sheet.addCell(xuehao);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Label xingming=new Label(1,0,"ÐÕÃû");
		try {
			sheet.addCell(xingming);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Label chengji=new Label(2,0,"³É¼¨");
		try {
			sheet.addCell(chengji);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int x=st.list.size()+1;
		Label [][]xh=new Label[x][3];
		System.out.println(x);
		for(int k=1;k<x;k++) {
			xh[k][0]=new Label(0,k,st.list.get(k-1).getStudentId());
			try {
				sheet.addCell(xh[k][0]);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			xh[k][1]=new Label(1,k,st.list.get(k-1).getStudentName());
			try {
				sheet.addCell(xh[k][1]);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			xh[k][2]=new Label(2,k,String.valueOf(gr.list.get(k-1).getGrade()));
			try {
				sheet.addCell(xh[k][2]);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		workbook.write();
		try {
			workbook.close();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
