package org.CarGarage.Repository;

import java.util.ArrayList;
import java.util.List;

import org.CarGarage.Config.DBConfig;
import org.CarGarage.Model.PartModel;

public class PartRepositoryImpl extends DBConfig implements PartRepository {
	List<PartModel> list;

@Override
public boolean isAddParts(PartModel model) {
		try {
			stmt=conn.prepareStatement("insert into part values('0',?,?)");
			stmt.setString(1,model.getPname() );
			stmt.setInt(2,model.getPrice());
			int value=stmt.executeUpdate();
			return value>0?true:false;
			
		}catch(Exception ex) {
			System.out.println("Exception in isAddNewPart Repository"+ex);
			return false;
		}
}
public List<PartModel> getAllParts() {
		try {
			list=new ArrayList<PartModel>();
			stmt=conn.prepareStatement("select *from part");
			rs=stmt.executeQuery();
			while(rs.next()) {
				PartModel pmodel=new PartModel();
				pmodel.setPid(rs.getInt("pid"));
				pmodel.setPname(rs.getString("pname"));
				pmodel.setPrice(rs.getInt("price"));
				list.add(pmodel);
			}
			return list.size()>0?list:null;
		}catch(Exception ex) {
			System.out.println("Exception in getAllPart Repository is"+ex);
		}
		return list;
		
	}


}

