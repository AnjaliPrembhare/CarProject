package org.CarGarage.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.CarGarage.Model.PartModel;
import org.CarGarage.Model.ServiceModel;
import org.CarGarage.Service.*;

/**
 * Servlet implementation class AllocateServiceController
 */
@WebServlet("/AllocateServiceController")
public class AllocateServiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ServiceService ss=new ServiceServiceImpl();
		String d=request.getParameter("date");
		int charage=Integer.parseInt(request.getParameter("charges"));
		String distance=request.getParameter("distance");
		String noplate=request.getParameter("noplate");
		String pname=request.getParameter("pname");
		String mname=request.getParameter("mname");
		ServiceModel smodel=new ServiceModel();
        smodel.setDistance(distance);
        smodel.setCharges(charage);
        smodel.setDate(d);
        int setvname=ss.isSetVehicle(noplate);
	    if(setvname==-1) {
	    	out.println("Vehicle not found plz valid vehicle");
	    }
	    else  {
	    	int sid=ss.isSetService(d);
	    	out.println(sid);
//	    	if(sid==-1) {
//	    		out.println("Plz Enter valid sid");
//	    	}
		    int pid=ss.isSetPart(pname);
		    if(pid==-1) {
		    	out.println("Plz Enter valid part");
		    }
		    else {
			    int mid=ss.isSetMechanic(mname);
			    
			    if(mid==-1) {
			    	System.out.println("Mechanic not found");
			    }
			    else {
		    	boolean b=ss.isAddService(smodel, noplate, pname, mname);
	    	if(b) {
	    		out.println("Service added successfully..................");
	    	}

	    	else {
	    		out.println("Service not added...........................");
	    	}
	    }
	    }
	    }
	    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
