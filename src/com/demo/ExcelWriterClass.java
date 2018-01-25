package com.demo;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.write.WriteException;

/**
 * Servlet implementation class ExcelWriterClass
 */
@WebServlet(name="ExcelWriterClass",urlPatterns="/ExcelWriterClass")
public class ExcelWriterClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcelWriterClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OutputStream os = response.getOutputStream();
		response.reset();
		response.setCharacterEncoding("utf-8");
		String id=(String) request.getSession().getAttribute("id");
		String fname=id+"µÄ³É¼¨±í";
		System.out.println(id);
		fname=java.net.URLEncoder.encode(fname, "UTF-8");
		response.setHeader("Content-Disposition","attachment;filename="+new String(fname.getBytes("UTF-8"),"GBK")+".xls");
		response.setContentType("application/msexcel");
		ExcelClass ew=new ExcelClass();
		try {
			ew.creatExcel(os,id);
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
