package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Transmit
 */
@WebServlet(name="Transmit",urlPatterns="/Transmit")
public class Transmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transmit() {
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
		String id=request.getParameter("id");
		String type=request.getParameter("type");
		//out.print("<script>alert('"+type+"'); </script>");
		if(id==""){
			out.print("<script>alert('ÕËºÅ²»ÄÜÎª¿Õ'); </script>");
			request.getRequestDispatcher("/WEB-INF/jsp/queryTeacher.jsp").forward(request, response);
		}else{
				if(type.equals("class")){
					request.getRequestDispatcher("/WEB-INF/jsp/queryClass.jsp").forward(request, response);
				}else if(type.equals("course")) {
					request.getRequestDispatcher("/WEB-INF/jsp/queryCourse.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("/WEB-INF/jsp/query1.jsp").forward(request, response);
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
