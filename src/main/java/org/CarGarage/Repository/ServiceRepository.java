package org.CarGarage.Repository;

import java.sql.Date;
import java.util.List;

import org.CarGarage.Model.ServiceModel;

public interface ServiceRepository {
	public boolean isAddService(ServiceModel smodel,String noplate, String partname, String spec);
public int isSetMechanic(String name);
public int isSetPart(String partname);
public int isSetService(String sdate);
public int isSetVehicle(String noplate);
public List<Object[]> getAllInfo();
public boolean isDeleteServiceById(int sid);
boolean isUpdateService(ServiceModel model);
}
