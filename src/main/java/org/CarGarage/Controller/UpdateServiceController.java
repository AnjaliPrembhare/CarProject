package org.CarGarage.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updateS")
public class UpdateServiceController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int sid=Integer.parseInt(request.getParameter("id"));
		String sdate=request.getParameter("date");
		int charges=Integer.parseInt(request.getParameter("charges"));
		String distance=request.getParameter("distance");
		RequestDispatcher r=request.getRequestDispatcher("MainDashBoard.jsp");
		r.include(request, response);
		out.println("<link href='CSS/AddService.css' rel='stylesheet'/>");
		out.println("<form class='Form' action='updateService' method=''>");
		out.println("<h4>Update Service here</h4>");
		out.println("<input type='hidden' name='sid' value='"+sid+"'><br><br>");
		out.println("<input type='text' name='date' class='input' value="+sdate+"><br><br>");
		out.println("<label for=''>Charges</label><br>");
		out.println("<input type='text' name='charges'class='input' value="+charges+"><br><br>");
		out.println("<label for='noplate'>distance</label><br>");
		out.println("<input type='text' name='distance'class='input' value="+distance+"><br><br>");
		out.println("<input type='submit' name='s' value='submit'class='submit'/><br><br>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

}
