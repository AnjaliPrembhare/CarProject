package org.CarGarage.Repository;

import java.util.ArrayList;
import java.util.List;

import org.CarGarage.Config.DBConfig;
import org.CarGarage.Model.ServiceModel;
import org.CarGarage.Model.VehicleModel;

public class ServiceRepositoryImpl extends DBConfig implements ServiceRepository{
	List<Object[]> list;
	public int isSetVehicle(String noplate) {
		try {
			stmt=conn.prepareStatement("select vid from vehicle where noplate=?");
			stmt.setString(1, noplate);
			rs=stmt.executeQuery();
		
			if(rs.next()) {
				return rs.getInt(1);
			}
			else {
				return -1;
			}
		}
		catch(Exception ex) {
			System.out.println("Exception occure in issetVehicle in serviceRepository "+ex);
			return 0;
		}
	}
	public int isSetMechanic(String name) {
		try {
			stmt=conn.prepareStatement("select Mid from Mechanic where mname=?");
			stmt.setString(1, name);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			else {
				return -1;
			}
		}
		catch(Exception ex) {
			System.out.println("Exception occure in isSetMechanic in serviceRepository "+ex);
			return 0;
		}
	}
	public int isSetPart(String partname) {
		try {
			stmt=conn.prepareStatement("select pid from part where pname=?");
			stmt.setString(1, partname);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			else {
				return -1;
			}
		}
		catch(Exception ex) {
			System.out.println("Exception occure in isSetPart in serviceRepository "+ex);
			return 0;
		}
	}
	public int isSetService(String sdate) {
		try {
			stmt=conn.prepareStatement("select max(sid) from Service where sdate=?");
			stmt.setString(1, sdate);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			else {
				return -1;
			}
		}
		catch(Exception ex) {
			System.out.println("Exception occure in isSetService in serviceRepository "+ex);
			return 0;
		}
	}


	public boolean isAddService(ServiceModel smodel,String noplate,String partname,String spec) {
		try {
		 int vid=this.isSetVehicle(noplate);
		 System.out.println(smodel.getDistance());
		 stmt=conn.prepareStatement("insert into service values('0',?,?,?,?)");
		
		stmt.setString(1, smodel.getDate());
		stmt.setInt(2,smodel.getCharges());
		stmt.setString(3, smodel.getDistance());
		stmt.setInt(4, vid);
		int value=stmt.executeUpdate();
		int sid=this.isSetService(smodel.getDate());
		if(value>0) {
			int pid=this.isSetPart(partname);
			int mid=this.isSetMechanic(spec);
			System.out.println(pid+"\t"+mid);
			if(pid!=-1 && mid!=-1) {
				stmt=conn.prepareStatement("insert into spmjoin1 values(?,?,?)");
				stmt.setInt(1, pid);
				stmt.setInt(2, mid);
				stmt.setInt(3, sid);
				return stmt.executeUpdate()>0?true:false;
			}
			else if(pid==-1 && mid==-1) {
				System.out.println("Part and mechanic not found");
			}
			return true;
		}
		else {
			System.out.println("Servicing not added...............................................................");
			return false;
		}
		}
		catch(Exception ex) {
			System.out.println("Exception occure in isAddService in serviceRepository "+ex);
			return false;
		}
	}
	
	public List<Object[]> getAllInfo() {
		try {
			list=new ArrayList<Object[]>();
			stmt=conn.prepareStatement("select s.sdate,s.charges,s.distance,p.pname,v.vname,m.mname,s.sid from service s inner join spmjoin1 spm on s.sid=spm.sid inner join part p on spm.pid=p.pid inner join vehicle v on s.vid=v.vid inner join mechanic m on spm.mid=m.mid;");
			rs=stmt.executeQuery();
			while(rs.next()) {
				Object []obj=new Object[] {rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)};
				list.add(obj);
			}
			return list.size()>0?list:null;
		}catch(Exception ex) {
			System.out.println("Error is"+ex);
			return null;
		}
		
	}
	public boolean isDeleteServiceById(int sid) {
		try {
			stmt=conn.prepareStatement("delete from service where sid=?");
			stmt.setInt(1, sid);
			int value=stmt.executeUpdate();
		
			return value>0?true:false;
		}
		catch(Exception ex) {
			System.out.println("Error is"+ex);
		}
		return false;
	}

	@Override
	public boolean isUpdateService(ServiceModel model) {
		
			try {
				
				stmt=conn.prepareStatement("update service set sdate=?,charges=?,distance=? where sid=?");
				stmt.setString(1, model.getDate());
				stmt.setInt(2, model.getCharges());
				stmt.setString(3, model.getDistance());
				stmt.setInt(4,model.getId());
				int value=stmt.executeUpdate();
				//System.out.println(value);
				return value>0?true:false;
			}
			catch(Exception ex) {
				System.out.println("Error is "+ex);
				return false;
			
		}
	}
	}

	
	


