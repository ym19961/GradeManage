package com.demo;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Record1
 */
@WebServlet(name="Record1",urlPatterns="/Record1")
public class Record1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Record1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String []a1=request.getParameterValues("Total");
		String id=request.getParameter("courseId");
		Manager manager=new Manager();
		int []a2=new int[a1.length];
		request.setCharacterEncoding("utf-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		try{
			manager.rs=manager.stmt.executeQuery("SELECT * from course");
		}catch(SQLException e){
			e.printStackTrace();
		}
		for(int i=0;i<a1.length;i++) { 
			a2[i]=Integer.parseInt(a1[i]);
			try {
				manager.addGrade(manager.getStudentId(i),id, a2[i]); //将成绩信息输入到数据库中
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		out.print("<script>alert('录入成功'); </script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
