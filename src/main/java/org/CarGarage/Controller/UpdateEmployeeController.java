package org.CarGarage.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateEmployee")
public class UpdateEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("MainDashBoard.jsp");
		r.include(request, response);
		out.println("<link href='CSS/AddCustomer.css' rel='stylesheet'/>");
		out.println("<form class='Form' action='' method='POST'>");
	    out.println("<div class='col-md-9 login'>");
	    out.println("<h3>Update Employee Details</h3><br>");
	    out.println("<label for='Name'>Employee Name</label><br>");
	    out.println("<input type='text' name='name' value='' placeholder='ram'/><br><br>");
	    out.println("<label for='Email'>Specialization</label><br>");
	    out.println("<input type=\"text\" name=\"Specialization\" value=\"\" placeholder=\"oil change\"/><br><br>");
	    out.println("<label for='contact'>Experience</label><br>");
	    out.println("<input type='text' name='Experience' value='' placeholder='3yrs'/><br><br>");
	    out.println("<input type='submit' name='s' value='Submit' class='submit'/><br><br>");
	   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
