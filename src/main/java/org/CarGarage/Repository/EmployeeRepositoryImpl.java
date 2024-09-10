package org.CarGarage.Repository;

import java.util.ArrayList;
import java.util.List;

import org.CarGarage.Config.DBConfig;
import org.CarGarage.Model.EmployeeModel;

public class EmployeeRepositoryImpl extends DBConfig implements MechanicRepository {
	List<EmployeeModel> list;
	@Override
	public boolean isAddEmployee(EmployeeModel model) {
		
			try {
				stmt=conn.prepareStatement("insert into mechanic values('0',?,?,?)");
				stmt.setString(1,model.getName() );
				stmt.setString(2,model.getSpecialization());
				stmt.setString(3,model.getExperience());
				int value=stmt.executeUpdate();
				return value>0?true:false;
				
			}catch(Exception ex) {
				System.out.println("Exception in isAddNewEmployee Repository"+ex);
				return false;
			}
	}

	@Override
	public List<EmployeeModel> getAllEmployee() {
			try {
				list=new ArrayList<EmployeeModel>();
				stmt=conn.prepareStatement("select *from mechanic");
				rs=stmt.executeQuery();
				while(rs.next()) {
					EmployeeModel emodel=new EmployeeModel();
					emodel.setMid(rs.getInt("mid"));
					emodel.setName(rs.getString("mname"));
					emodel.setSpecialization(rs.getString("specialization"));
					emodel.setExperience(rs.getString("experience"));
					list.add(emodel);
				}
				return list.size()>0?list:null;
			}catch(Exception ex) {
				System.out.println("Exception in getAllEmployee Repository is"+ex);
			}
			return null;
		}
          
	}


