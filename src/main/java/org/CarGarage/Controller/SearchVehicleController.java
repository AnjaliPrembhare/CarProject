package org.CarGarage.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.CarGarage.Model.VehicleModel;
import org.CarGarage.Service.*;


@WebServlet("/searchV")
public class SearchVehicleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	String numberPlate = request.getParameter("noplate");
	VehicleService vs=new VehicleServiceImpl();
    List<Object[]> searchResult = vs.isSearchVehicle(numberPlate);
    request.setAttribute("searchResult", searchResult);
    RequestDispatcher dispatcher = request.getRequestDispatcher("ViewSearchVehicle.jsp");
    dispatcher.include(request, response);
}
		
	
	
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
