package org.CarGarage.Service;

import java.sql.Date;
import java.util.List;

import org.CarGarage.Model.ServiceModel;
import org.CarGarage.Repository.*;

public class ServiceServiceImpl implements ServiceService{
    ServiceRepository sr=new ServiceRepositoryImpl();
	@Override
	public boolean isAddService(ServiceModel smodel,String noplate, String partname, String spec){
		// TODO Auto-generated method stub
		return sr.isAddService(smodel, noplate,partname, spec);
	}

	@Override
	public int isSetMechanic(String name) {
		// TODO Auto-generated method stub
		return sr.isSetMechanic(name);
	}

	@Override
	public int isSetPart(String partname) {
		// TODO Auto-generated method stub
		return sr.isSetPart(partname);
	}

	@Override
	public int isSetService(String sdate) {
		// TODO Auto-generated method stub
		return sr.isSetService(sdate);
	}

	@Override
	public int isSetVehicle(String noplate) {
		// TODO Auto-generated method stub
		return sr.isSetVehicle(noplate);
	}

	@Override
	public List<Object[]> getAllInfo() {
		// TODO Auto-generated method stub
		return sr.getAllInfo();
	}

	@Override
	public boolean isDeleteServiceById(int sid) {
		// TODO Auto-generated method stub
		return sr.isDeleteServiceById(sid);
	}

	@Override
	public boolean isUpdateService(ServiceModel model) {
		// TODO Auto-generated method stub
		return sr.isUpdateService(model);
	}

}
