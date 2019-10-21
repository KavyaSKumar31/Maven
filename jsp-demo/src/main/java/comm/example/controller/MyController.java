package comm.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.model.Student;

public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String fName, lName, subject;
	private int age;
private List<String> errors=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("Hey I am in controller.do");
		errors=new LinkedList<String>();
		fName=request.getParameter("fName");
		if((fName==null) || (fName.length()<5))
		{
			errors.add("first name can't be null or less than 5 chars");
		}
		lName=request.getParameter("lName");
		if((fName==null) || (fName.length()<5))
		{
			errors.add("last name can't be null or less than 5 chars");
		}
		try {
			age=Integer.parseInt(request.getParameter("age").toString());
		} catch (Exception e) {
			errors.add("age field must be numeric");
		}
		subject=request.getParameter("subject").toString();
		if(subject.equals("Unknown"))
		{
			errors.add("subject can't be unknown");
		}
		
		if(!errors.isEmpty())
		{
			request.setAttribute("errors", errors);
			RequestDispatcher view=request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		}
		else
		{
			request.setAttribute("success", new Student(fName, lName, subject, age));
			RequestDispatcher view=request.getRequestDispatcher("success.jsp");
			view.include(request, response);
			
		}
	}

}
