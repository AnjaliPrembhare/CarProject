package org.CarGarage.Repository;

import java.util.List;
import org.CarGarage.Model.VehicleModel;

public interface VehicleRepository {
public boolean isAddVehicle(VehicleModel model,String email);
public int isCustomerEmail(String email);
public List<Object[]> getAllInfo();
public boolean isDelVehicleById(int cid);
public boolean isUpdateVehicle(VehicleModel model);
public List<Object[]> isSearchVehicle(String noplate);
}
