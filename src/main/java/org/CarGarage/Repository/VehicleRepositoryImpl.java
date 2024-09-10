package org.CarGarage.Repository;

import java.util.ArrayList;
import java.util.List;

import org.CarGarage.Config.DBConfig;
import org.CarGarage.Model.*;

public class VehicleRepositoryImpl extends DBConfig implements VehicleRepository {
	List<Object[]> list;
	public boolean isAddVehicle(VehicleModel model,String email) {
		
			try {
				int cid=this.isCustomerEmail(email);
				System.out.println(cid);
				stmt=conn.prepareStatement("insert into vehicle values('0',?,?,?,?)");
				stmt.setString(1,model.getVname());
				stmt.setString(2, model.getModel());
				stmt.setString(3,model.getNoplate());
				stmt.setInt(4,cid);
				int value=stmt.executeUpdate();
				
				return value>0?true:false;
				
			}catch(Exception ex) {
				System.out.println("Exception in isAddVehicle Repository"+ex);
				return false;
			}
		}
	
	public int isCustomerEmail(String email) {
			try {
				stmt=conn.prepareStatement("select cid from customer where email=?");
				stmt.setString(1, email);
				rs=stmt.executeQuery();
				if(rs.next()){
					return rs.getInt(1);
				}
				else {
					return -1;
				}
			}
			catch(Exception ex) {
				System.out.println("Exception occure in isCustomerEmail in VehicleRepository "+ex);
				return 0;
			}
		}
	public List<Object[]> getAllInfo() {
		try {
			list=new ArrayList<Object[]>();
			stmt=conn.prepareStatement("select v.vname,v.model,v.noplate,c.cname,c.email,c.contact,v.vid from customer c inner join vehicle v on c.cid=v.cid");
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
	public boolean isDelVehicleById(int vid) {
		try {
			stmt=conn.prepareStatement("delete from vehicle where vid=?");
			stmt.setInt(1, vid);
			int value=stmt.executeUpdate();
		
			return value>0?true:false;
		}
		catch(Exception ex) {
			System.out.println("Error is"+ex);
		}
		return false;
	}

	@Override
	public boolean isUpdateVehicle(VehicleModel model) {
		
			try {
				
				stmt=conn.prepareStatement("update vehicle set vname=?,model=?,noplate=? where vid=?");
				stmt.setString(1, model.getVname());
				stmt.setString(2, model.getModel());
				stmt.setString(3, model.getNoplate());
				stmt.setInt(4, model.getVid());
				int value=stmt.executeUpdate();
				System.out.println(value);
				return value>0?true:false;
			}
			catch(Exception ex) {
				System.out.println("Error is "+ex);
				return false;
			
		}
	}

	@Override
	public List<Object[]> isSearchVehicle(String noplate) {
		try {
			list=new ArrayList<Object[]>();
			stmt=conn.prepareStatement("select v.vname,v.model,v.noplate,c.cname,c.email,c.contact,v.vid from customer c inner join vehicle v on c.cid=v.cid where v.noplate=?");
			stmt.setString(1, noplate);
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
	}


