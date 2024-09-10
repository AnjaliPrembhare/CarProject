package org.CarGarage.Repository;

import java.util.List;

import org.CarGarage.Model.EmployeeModel;

public interface MechanicRepository {
public boolean isAddEmployee(EmployeeModel model);
public List<EmployeeModel> getAllEmployee();
}
