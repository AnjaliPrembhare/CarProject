package org.CarGarage.Service;

import java.util.List;

import org.CarGarage.Model.EmployeeModel;
import org.CarGarage.Repository.*;

public class EmployeeServiceImpl implements EmployeeService {
MechanicRepository es=new EmployeeRepositoryImpl();
	@Override
	public boolean isAddEmployee(EmployeeModel model) {
		
		return es.isAddEmployee(model);
	}

	@Override
	public List<EmployeeModel> getAllEmployee() {
		
		return es.getAllEmployee();
	}

}
