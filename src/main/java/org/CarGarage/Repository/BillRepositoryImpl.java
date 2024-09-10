package org.CarGarage.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.CarGarage.Config.DBConfig;
import org.CarGarage.Model.BillModel;

public class BillRepositoryImpl extends DBConfig implements BillRepository {
	List<Object[]> list;
	public int isgetChargePrice(int sid) {
		try {
			stmt=conn.prepareStatement("select sum(p.price)+sum(s.charges) from service s inner join spmjoin1 spm on s.sid=spm.sid inner join part p on spm.pid=p.pid where spm.sid=?");
			
			stmt.setInt(1, sid);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			else {
				return -1;
			}
		}
		catch(Exception ex) {
			System.out.println("Exception occure in isgetChargePrice method in billRepository"+ex);
			
		}
		return 0;
	}
	public int isSetVehicle(int vid) {
		try {
			stmt=conn.prepareStatement("select max(sid) from Service where vid=?");
			stmt.setInt(1, vid);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			else {
				return -1;
			}
		}
		catch(Exception ex) {
			System.out.println("Exception occure in isSetVehicle Method in billRepository "+ex);
			return 0;
		}
		
	}
	public boolean isAddBill(BillModel bmodel,int sid,int vid) {
		try {
			int amount=this.isgetChargePrice(vid);
			int sid1=this.isSetVehicle(sid);
			stmt=conn.prepareStatement("insert into bill value('0',?,?,?)");
			stmt.setInt(1, amount);
			stmt.setString(2, bmodel.getBdate());
			stmt.setInt(3, sid1);
			return stmt.executeUpdate()>0?true:false;
		}
		catch(Exception ex) {
			System.out.println("Error is AddBill repository is"+ex);
			return false;
		}
	}
	public List<Object[]> getAllInfo() {
		try {
			list=new ArrayList<Object[]>();
			stmt=conn.prepareStatement(" select b.bdate,v.vname,v.noplate,s.charges,p.price,b.amount,b.bid from part p inner join spmjoin1 spm on p.pid=spm.pid inner join service s on spm.sid=s.sid inner join bill b on s.sid=b.sid inner join vehicle v on v.vid=s.vid;");
			rs=stmt.executeQuery();
			while(rs.next()) {
				Object []obj=new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)};
				list.add(obj);
			}
			return list.size()>0?list:null;
		}catch(Exception ex) {
			System.out.println("Error is"+ex);
			return null;
		}
		
	}
	public boolean isDelBillById(int bid) {
		try {
			stmt=conn.prepareStatement("delete from bill where bid=?");
			stmt.setInt(1, bid);
			int value=stmt.executeUpdate();
		
			return value>0?true:false;
		}
		catch(Exception ex) {
			System.out.println("Error is"+ex);
		}
		return false;
	}
	
}
