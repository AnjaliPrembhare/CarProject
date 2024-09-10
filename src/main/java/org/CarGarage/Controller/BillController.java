package org.CarGarage.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.CarGarage.Model.BillModel;
import org.CarGarage.Service.*;

@WebServlet("/addbill")
public class BillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		BillService bs=new BillServiceImpl();
		int amount=Integer.parseInt(request.getParameter("vid"));
		String date=request.getParameter("date");
		out.println(date);
		int amount1=bs.isgetChargePrice(amount);
		int vid=Integer.parseInt(request.getParameter("vid"));
		int vid1=bs.isSetVehicle(vid);
		BillModel bm=new BillModel();
		bm.setBdate(date);
				boolean b=bs.isAddBill(bm, vid, vid1);
				if(b) {
					out.println("Service added successfully..................");
				}
				else {
					out.println("Service not added..................");
				
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
