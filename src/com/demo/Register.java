package com.demo;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Register
 */
@WebServlet(name="Register",urlPatterns="/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		Manager manager=new Manager();
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String password1=request.getParameter("password1");
		String password2=request.getParameter("password2");
		String StudentClass=request.getParameter("StudentClass");
		if(id==""){
			out.print("<script>alert('账号不能为空'); </script>");
			out.print("<script>location.href='register.jsp';</script>");		
		}else if(name==""||password1==""||password2==""){
			out.print("<script>alert('名字或密码不能为空'); </script>");
			out.print("<script>location.href='register.jsp';</script>");
		}else{
			if(!password1.equals(password2)){
				out.print("<script>alert('两次密码输入不一致'); </script>");
				out.print("<script>location.href='register.jsp';</script>");
			}else{
				try {
					if(manager.addStudent(id, name, password1,StudentClass)){
						out.print("<script>alert('注册成功'); </script>");
						out.print("<script>location.href='index.jsp';</script>"); //跳转到login.jsp
					}else{
						out.print("<script>alert('此用户已存在'); </script>");
						out.print("<script>location.href='register.jsp';</script>");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
