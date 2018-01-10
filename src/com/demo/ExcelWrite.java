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

public class ExcelWrite {
	public void creatExcel(OutputStream os,String id)throws WriteException,IOException{
		Manager manager=new Manager();	
		int m=0;
		//String id=request.getParameter("id");
		String sql="select CourseName,Grade from Grade,Course where Course.CourseId=Grade.CourseId and Grade.StudentId='"+id+"'";
		try {
			manager.rs=manager.stmt.executeQuery(sql);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		CourseManager co=new CourseManager();
	 	GradeManager gr=new GradeManager();
	 	Course []c=new Course[50];
	 	Grade []g=new Grade[50];
		try {
			while(manager.rs.next()){
				String Cname=manager.rs.getString("CourseName");
				int grade=manager.rs.getInt("Grade");
				c[m]=new Course(Cname);
				g[m]=new Grade(grade);
				co.add(c[m]);
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
		Label kecheng=new Label(0,0,"¿Î³Ì");
		try {
			sheet.addCell(kecheng);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Label chengji=new Label(1,0,"³É¼¨");
		try {
			sheet.addCell(chengji);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int x=co.list.size()+1;
		Label [][]xh=new Label[x][2];			
		for(int k=1;k<x;k++) {
			xh[k][0]=new Label(0,k,co.list.get(k-1).getCourseName());
			try {
				sheet.addCell(xh[k][0]);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			xh[k][1]=new Label(1,k,String.valueOf(gr.list.get(k-1).getGrade()));
			try {
				sheet.addCell(xh[k][1]);
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
