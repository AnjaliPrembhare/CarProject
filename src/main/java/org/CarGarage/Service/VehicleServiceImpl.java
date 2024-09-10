package org.CarGarage.Service;

import java.util.List;

import org.CarGarage.Model.VehicleModel;
import org.CarGarage.Repository.*;

public class VehicleServiceImpl implements VehicleService {
	VehicleRepository vr=new VehicleRepositoryImpl();
	public boolean isAddVehicle(VehicleModel model,String email) {
		return vr.isAddVehicle(model,email);
	}
	@Override
	public int isCustomerEmail(String email) {
		return vr.isCustomerEmail(email);
	}
	@Override
	public List<Object[]> getAllInfo() {
		return vr.getAllInfo();
	}
	public boolean isDelVehicleById(int vid) {
		return vr.isDelVehicleById(vid);
	}
	@Override
	public boolean isUpdateVehicle(VehicleModel model) {
		// TODO Auto-generated method stub
		return vr.isUpdateVehicle(model);
	}
	@Override
	public List<Object[]> isSearchVehicle(String noplate) {
		// TODO Auto-generated method stub
		return vr.isSearchVehicle(noplate);
	}
}
