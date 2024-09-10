package org.CarGarage.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/update")
public class CustomerUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int cid=Integer.parseInt(request.getParameter("cid"));
		String cname=request.getParameter("cname");
		String email=request.getParameter("cemail");
		String contact=request.getParameter("ccontact");
		String address=request.getParameter("caddress");
		RequestDispatcher r=request.getRequestDispatcher("MainDashBoard.jsp");
		r.include(request, response);
		out.println("<link href='CSS/AddCustomer.css' rel='stylesheet'/>");
		out.println("<form class='Form' action='upDate' method='POST'>");
	    out.println("<div class='col-md-9 login'>");
	    out.println("<h3>Update Customer Details</h3><br>");
	    out.println("<label for='Name'>Customer Name</label>");
	    out.println("<input type='hidden' name='cid' value='"+cid+"'/><br>");
	    out.println("<input type='text' name='name'value="+cname+"><br><br>");
	    out.println("<label for='Email'>Customer Email</label><br>");
	    out.println("<input type='text' name='email' value="+email+"><br><br>");
	    out.println("<label for='contact'>Customer Contact</label><br>");
	    out.println("<input type='text' name='contact' value="+contact+"><br><br>");
	    out.println("<label for='address'>Customer Address</label><br>");
	    out.println("<input type='text' name='address' value="+address+"><br><br>");
	    out.println("<input type='submit' name='s' value='Submit' class='submit'/><br><br>");
	    out.println("</div></div></div>");
	   
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
