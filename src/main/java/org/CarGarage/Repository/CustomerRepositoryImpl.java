package org.CarGarage.Repository;

import org.CarGarage.Config.DBConfig;
import org.CarGarage.Model.CustomerModel;


import java.util.*;

public class CustomerRepositoryImpl extends DBConfig implements CustomerRepository {
	List<CustomerModel> list;
	List<Object[]> c;
	public boolean isAddNewCustomer(CustomerModel model) {
		try {
			stmt=conn.prepareStatement("insert into customer values('0',?,?,?,?)");
			stmt.setString(1,model.getName() );
			stmt.setString(2, model.getEmail());
			stmt.setString(3,model.getContact());
			stmt.setString(4,model.getAddress() );
			int value=stmt.executeUpdate();
			return value>0?true:false;
			
		}catch(Exception ex) {
			System.out.println("Exception in isAddNewCustomer Repository"+ex);
			return false;
		}
	}

	@Override
	public List<CustomerModel> getAllCustomer() {
		try {
			list=new ArrayList<CustomerModel>();
			stmt=conn.prepareStatement("select *from customer");
			rs=stmt.executeQuery();
			while(rs.next()) {
				CustomerModel cmodel=new CustomerModel();
				cmodel.setId(rs.getInt("cid"));
				cmodel.setName(rs.getString("cname"));
				cmodel.setEmail(rs.getString("email"));
				cmodel.setContact(rs.getString("contact"));
				cmodel.setAddress(rs.getString("address"));
				list.add(cmodel);
			}
			return list.size()>0?list:null;
		}catch(Exception ex) {
			System.out.println("Exception in getAllCustomer Repository is"+ex);
		}
		return null;
	}
	public boolean isDelCustomerById(int cid) {
		try {
			stmt=conn.prepareStatement("delete from customer where cid=?");
			stmt.setInt(1,cid);
			int value=stmt.executeUpdate();
		return value>0?true:false;
		}
		catch(Exception ex) {
			System.out.println("Exception in isDelCustomerById is "+ex);
			return false;
		}
		
	}
	public boolean isUpdateCustomer(CustomerModel model) {
		try {
			
			stmt=conn.prepareStatement("update customer set cname=?,email=?,contact=?,address=? where cid=?");
			stmt.setString(1, model.getName());
			stmt.setString(2, model.getEmail());
			stmt.setString(3, model.getContact());
			stmt.setString(4, model.getAddress());
			stmt.setInt(5, model.getId());
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
	public int isCustomerLogin(String email,String contact) {
		try {
			stmt=conn.prepareStatement("select *from customer where email=? and contact=?");
			stmt.setString(1, email);
			stmt.setString(2, contact);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			else {
				return 0;
			}		
			}catch(Exception ex) {
			System.out.println("Exception in CustomerLoginImpl Repository is"+ex);
			
		}
		return 0;

	}
	@Override
	public List<Object[]> getProfile(int cid) {
		try {
			stmt=conn.prepareStatement("select c.cname,c.email,c.contact,c.address,v.vname,v.noplate,c.cid from customer c inner join vehicle v on c.cid=v.cid where c.cid=?");
			stmt.setInt(1, cid);
			rs=stmt.executeQuery();
			if(rs.next()) {
				c=new ArrayList<Object[]>();
				Object []obj=new Object[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)};
                c.add(obj);
                return c.size()>0?c:null;/*c.setName(rs.getString(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setContact(rs.getString(4));
				c.setAddress(rs.getString(5));*/
			}
			

			
			
		}catch(Exception ex) {
			System.out.println("Error is"+ex);
		}
		return c;
		
	}
}

