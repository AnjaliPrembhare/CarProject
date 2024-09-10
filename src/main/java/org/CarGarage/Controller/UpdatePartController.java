package org.CarGarage.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdatePart")
public class UpdatePartController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher r=request.getRequestDispatcher("MainDashBoard.jsp");
		r.include(request, response);
		out.println("<link href='CSS/updatePart.css' rel='stylesheet'/>");
		out.println("<form class='Form'>");
	    out.println("<div class='col-md-9'>");
	    out.println("<h3>Update Parts Of Vehicle</h3><br>");
	    out.println("<label for='Name'>Part Name</label><br>");
	    out.println("<input type='text' name='name' value='plug'/><br><br>");
	    out.println("<label for='Price'>Price</label><br>");
	    out.println("<input type='text' name='price' value='300'/><br><br>");
	    out.println("<input type='submit' name='s' value='Submit' class='submit'/><br><br>");
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
