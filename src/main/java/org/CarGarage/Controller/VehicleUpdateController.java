package org.CarGarage.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updateV")
public class VehicleUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int vid1=Integer.parseInt(request.getParameter("id"));
		String vname=request.getParameter("vname");
		String model=request.getParameter("model");
		String noplate=request.getParameter("noplate");
		RequestDispatcher r=request.getRequestDispatcher("MainDashBoard.jsp");
		r.include(request, response);
		out.println("<link href='CSS/AddCustomer.css' rel='stylesheet'/>");
		out.println("<form name='frm' class='Form' action='updateFinal' method='POST'>");
	    out.println("<div class='col-md-9 login'>");
	    out.println("<h3>Update Vehicle Details</h3><br>");
	    out.println("<label for='vname'>Vehicle Name</label>");
	    out.println("<input type='hidden' name='vid' value='"+vid1+"'><br><br>");
	    out.println("<input type='text' name='vname' value="+vname+"><br><br>");
	    out.println("<label for='model'>Model</label><br>");
	    out.println("<input type='text' name='model' value="+model+"><br><br>");
	    out.println("<label for='noplate'>noplate</label><br>");
	    out.println("<input type='text' name='noplate' value="+noplate+"><br><br>");
	    out.println("<input type='submit' name='s' value='Submit' class='submit'/><br><br>");
	    out.println("</form></div></div></div>");
	   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
