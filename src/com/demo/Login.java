package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet(name="Login",urlPatterns="/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		HttpSession session = request.getSession();
		session.setAttribute("id",id);
		String password=request.getParameter("password");
		String type=request.getParameter("type");
		if(!type.equals("student") || type.equals("teacher")){
			out.print("<script>alert('请选择用户类型'); </script>");
			out.print("<script>location.href='index.jsp';</script>");
		}
		if(id==""){
			out.print("<script>alert('账号不能为空'); </script>");
			out.print("<script>location.href='index.jsp';</script>");
			
		}else if(password==""){
			out.print("<script>alert('密码不能为空'); </script>");
			out.print("<script>location.href='index.jsp';</script>");
		}else{
				if(type.equals("student")){
					try {
						if(manager.SearchStudent(id, password)){
							out.print("<script>alert('登录成功'); </script>");
							request.getRequestDispatcher("/WEB-INF/jsp/query1.jsp").forward(request, response);
						}else{
							out.print("<script>alert('账号或密码错误'); </script>");
							out.print("<script>location.href='index.jsp';</script>");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					try {
						if(manager.SearchTeacher(id, password)){
							out.print("<script>alert('登录成功'); </script>");
							request.getRequestDispatcher("/WEB-INF/jsp/choose.jsp").forward(request, response);
						}else{
							out.print("<script>alert('账号或密码错误'); </script>");
							out.print("<script>location.href='index.jsp';</script>");
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
