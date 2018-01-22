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

public class ExcelClass {
	public void creatExcel(OutputStream os,String id)throws WriteException,IOException{
		Manager manager=new Manager();	
		int m=0;
		//String id=request.getParameter("id");
		String sql="SELECT DISTINCT A.StudentId,student.StudentName,A.grade AS grade1,B.Grade AS grade2,C.grade AS grade3,D.grade AS grade4 FROM student,grade A,grade B,grade C,grade D WHERE A.StudentId = B.StudentId AND B.StudentId = C.StudentId AND C.StudentId = D.StudentId AND A.StudentId = student.StudentId AND A.CourseId != B.CourseId AND A.CourseId != C.CourseId AND A.CourseId != D.CourseId AND B.CourseId != C.CourseId AND B.CourseId != D.CourseId AND C.CourseId != D.CourseId AND student.StudentClass = 'Class1' GROUP BY A.StudentId"; 
		try {
			manager.rs=manager.stmt.executeQuery(sql);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		StudentManager st=new StudentManager();
		CourseManager co=new CourseManager();
	 	GradeManager gr1=new GradeManager();
	 	GradeManager gr2=new GradeManager();
	 	GradeManager gr3=new GradeManager();
	 	GradeManager gr4=new GradeManager();
	 	Grade []g1=new Grade[50];
	 	Grade []g2=new Grade[50];
	 	Grade []g3=new Grade[50];
	 	Grade []g4=new Grade[50];
	    Student []s=new Student[50];
		try {
			while(manager.rs.next()){
				String Sid=manager.rs.getString("StudentId");
				String Sname=manager.rs.getString("StudentName");
				int grade1=manager.rs.getInt("grade1");
				int grade2=manager.rs.getInt("grade2");
				int grade3=manager.rs.getInt("grade3");
				int grade4=manager.rs.getInt("grade4");
				s[m]=new Student(Sid,Sname);
				g1[m]=new Grade(grade1);
				g2[m]=new Grade(grade2);
				g3[m]=new Grade(grade3);
				g4[m]=new Grade(grade4);
				st.add(s[m]);
				gr1.add(g1[m]);
				gr2.add(g2[m]);
				gr3.add(g3[m]);
				gr4.add(g4[m]);
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
		Label xuehao=new Label(0,0,"学号");
		try {
			sheet.addCell(xuehao);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Label xingming=new Label(1,0,"姓名");
		try {
			sheet.addCell(xingming);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Label java=new Label(2,0,"Java");
		try {
			sheet.addCell(java);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Label c1=new Label(3,0,"C++");
		try {
			sheet.addCell(c1);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Label web=new Label(4,0,"Web");
		try {
			sheet.addCell(web);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Label net=new Label(5,0,"计算机网络");
		try {
			sheet.addCell(net);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int x=st.list.size()+1;
		Label [][]xh=new Label[x][6];			
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
			xh[k][2]=new Label(2,k,String.valueOf(gr1.list.get(k-1).getGrade()));
			try {
				sheet.addCell(xh[k][2]);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			xh[k][3]=new Label(3,k,String.valueOf(gr2.list.get(k-1).getGrade()));
			try {
				sheet.addCell(xh[k][3]);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			xh[k][4]=new Label(4,k,String.valueOf(gr3.list.get(k-1).getGrade()));
			try {
				sheet.addCell(xh[k][4]);
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			xh[k][5]=new Label(5,k,String.valueOf(gr4.list.get(k-1).getGrade()));
			try {
				sheet.addCell(xh[k][5]);
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

