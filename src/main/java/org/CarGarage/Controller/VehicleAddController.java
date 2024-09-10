package org.CarGarage.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.CarGarage.Model.CustomerModel;
import org.CarGarage.Model.VehicleModel;
import org.CarGarage.Service.*;

@WebServlet("/Vehicle")
public class VehicleAddController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		VehicleServiceImpl vs=new VehicleServiceImpl();
		
		String name=request.getParameter("name");
		String model=request.getParameter("model");
		String noplate=request.getParameter("noplate");
		String email=request.getParameter("email");
		
		VehicleModel vmodel=new VehicleModel();
		if (name != null && !name.isEmpty() &&
	            model != null && !model.isEmpty() &&
	            noplate != null && !noplate.isEmpty()&& email!=null && !email.isEmpty()) {
		vmodel.setVname(name);
		vmodel.setModel(model);
		vmodel.setNoplate(noplate);
		int cid=vs.isCustomerEmail(email);
        if(cid==-1)
        {
        	System.out.println("Plz Valid Customer email id");
        }
        else
        {
        boolean b=vs.isAddVehicle(vmodel, email);
		if(b) {
			RequestDispatcher rd=request.getRequestDispatcher("ViewVehicle.jsp");
			rd.include(request, response);
		}
        
		else {
			RequestDispatcher rd=request.getRequestDispatcher("AddVehicle.jsp");
			rd.include(request, response);
			out.println("<h1>Customer not added.......</h1>");
		}
        }
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("AddNewCustomer.jsp");
			rd.include(request, response);
			out.println("<h4 style='color:white;'>All Fields Required</h4>");
		}
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
