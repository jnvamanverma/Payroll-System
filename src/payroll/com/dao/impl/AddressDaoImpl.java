package payroll.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import payroll.com.dao.AddressDao;
import payroll.com.db.util.DBUtil;
import payroll.com.entity.Address;

public class AddressDaoImpl implements AddressDao {

	static Connection connection=null;
	private PreparedStatement preparedStatement=null;

	public AddressDaoImpl() {

	}

	public static void main(String[] args) {

		 //Address address=new Address("125","dankaur","gnoida",110086,"up","gbnagar");
		// Address address=new Address();
		 //address.setUserId("126");
		//System.out.println(address.getUserId());
		AddressDaoImpl addressDaoImpl = new AddressDaoImpl();
	     System.out.println(addressDaoImpl.searchAddress("128"));
	    
	   
	    //System.out.println(addressDaoImpl.addAddress(address));
		//System.out.println(addressDaoImpl.deleteAddress("125"));
		//System.out.println(addressDaoImpl.editAddress(address));
		//ArrayList<Address> list = addressDaoImpl.searchAddress("125");
	     //for (Address address1 : list) {
		//	System.out.println(address1.getUserId() + address1.getStreet() + address1.getCity() + address1.getPin()
		//			+ address1.getState() + address1.getDistrict());
		//}
	}

	
	
	@Override
	public String addAddress(Address address) {

		String result = "FAIL";
		if(address==null)
			return result;

		String sql = "INSERT INTO ADDRESS", p1 = "", p2 = "";

		if (!(address.getUserId()==null)) {
			if (p1.length() > 0) {
				p1 += ",";
				p2 += ",";
			}
			p1 = p1 + "userid";
			p2 = p2 + "'" + address.getUserId() + "'";
		}
		if (!(address.getStreet()==null)) {
			if (p1.length() > 0) {
				p1 += ",";
				p2 += ",";
			}
			p1 = p1 + "street";
			p2 = p2 + "'" + address.getStreet() + "'";
		}
		if (!(address.getCity()==null)) {
			if (p1.length() > 0) {
				p1 += ",";
				p2 += ",";
			}
			p1 = p1 + "city";
			p2 = p2 + "'" + address.getCity() + "'";
		}
		if (address.getPin() > 0) {
			if (p1.length() > 0) {
				p1 += ",";
				p2 += ",";
			}
			p1 = p1 + "pin";
			p2 = p2 + Integer.toString(address.getPin());
		}
		if (!(address.getState()==null)) {
			if (p1.length() > 0) {
				p1 += ",";
				p2 += ",";
			}
			p1 = p1 + "state";
			p2 = p2 + "'" + address.getState() + "'";
		}
		if (!(address.getDistrict()==null)) {
			if (p1.length() > 0) {
				p1 += ",";
				p2 += ",";
			}
			p1 = p1 + "district";
			p2 = p2 + "'" + address.getDistrict() + "'";
		}

		try {
			sql = sql + "(" + p1 + ")" + " VALUES(" + p2 + ")";
			connection=DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			System.out.println(sql);
			
			int res = preparedStatement.executeUpdate();

			if (res > 0) {
				result = "ROW INSERTED";
			}

		} catch (SQLException e) {
			System.out.println("INSERT ERROR...  " + e);
		}finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    preparedStatement = null;
                    System.out.println("Statement closed successfully");
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                    connection = null;
                    System.out.println("connection closed successfully");
                } catch (SQLException e) {
                	System.out.println(e);
                }
            }
        }

		return result;

	}
	

	@Override
	public String editAddress(Address address) {

		String result = "FAIL";
		
		if(address==null)
			return result;

		String sql = "update address set ", p1 = "";
		connection = DBUtil.getConnection();
		preparedStatement = null;

		try {
			

			if (!(address.getStreet()==null)) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "street='" + address.getStreet() + "'";
			}
			if (!(address.getCity()==null)) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "city='" + address.getCity() + "'";
			}
			if (!(address.getPin() > 0)) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "pin=" + Integer.toString(address.getPin());
			}
			if (!(address.getState()==null)) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "state='" + address.getState() + "'";
			}
			if (!(address.getDistrict()==null)) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "district='" + address.getDistrict() + "'";
			}

			sql = sql + p1 + "where userid='" + address.getUserId() + "'";

			preparedStatement = connection.prepareStatement(sql);
			System.out.println(sql);
			int res = preparedStatement.executeUpdate();

			if (res > 0) {
				result = "ROW UPDATED";
			}

		} catch (SQLException e) {
			System.out.println("UPDATION ERROR...  " + e);
		}finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    preparedStatement = null;
                    System.out.println("Statement closed successfully");
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                    connection = null;
                    System.out.println("connection closed successfully");
                } catch (SQLException e) {
                	System.out.println(e);
                }
            }
        }

		return result;
	}

	@Override
	public String deleteAddress(String Id) {
		String sql = "DELETE FROM Address WHERE userid =?";
		String result="FAIL";
		if(Id==null)
			return result;
		preparedStatement = null;
		connection = DBUtil.getConnection();
		try {
			
			preparedStatement = connection.prepareStatement(sql);
		    preparedStatement.setString(1,Id);
		    System.out.println(sql);
			int res=preparedStatement.executeUpdate();
            
			if(res>0)
				result="ROW DELETED SUCCESSFULLY";

		} catch (SQLException e) {
			result="ERROR IN DELETION "+e;
		}finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    preparedStatement = null;
                    System.out.println("Statement closed successfully");
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                    connection = null;
                    System.out.println("connection closed successfully");
                } catch (SQLException e) {
                	System.out.println(e);
                }
            }
        }

		return result;
	}

	@Override
	public Address searchAddress(String id) {
		if(id==null)
			return null;
		String sql = "SELECT * FROM Address where userid='" + id + "'";
		preparedStatement= null;
		connection = DBUtil.getConnection();
		Address address=null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String id1 = rs.getString(1);
				String street = rs.getString(2);
				String city = rs.getString(3);
				int pin = rs.getInt(4);
				String state = rs.getString(5);
				String district = rs.getString(6);
			    address = new Address(id1, street, city, pin, state, district);
			    
				}

		} catch (SQLException e) {
			System.out.println("ERROR IN LOADING.....  "+e);
		}finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    preparedStatement = null;
                    System.out.println("Statement closed successfully");
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                    connection = null;
                    System.out.println("connection closed successfully");
                } catch (SQLException e) {
                	System.out.println(e);
                }
            }
        }
    
		return address;
	}

	@Override
	public ArrayList<Address> searchAddress(Address address) {
		if(address==null)
			return null;
		ArrayList<Address> list=new ArrayList<Address>();
		String sql = "SELECT * FROM Address where  ",p1="";
        Address address1=null;
		try {

			if (!(address.getStreet()==null)) 
			if(!(address.getStreet().isEmpty())){
				if (p1.length() > 0)
					p1 += " and ";
				p1 = p1 + "street='" + address.getStreet() + "'";
			}
			if (!(address.getCity()==null))
			if(!(address.getCity().isEmpty())){
				if (p1.length() > 0)
					p1 += " and ";
				p1 = p1 + "city='" + address.getCity() + "'";
			}
			if (!(address.getPin() > 0)){
				if (p1.length() > 0)
					p1 += " and ";
				p1 = p1 + "pin=" + Integer.toString(address.getPin());
			}
			if (!(address.getState()==null)) 
			if(!(address.getState().isEmpty())){
				if (p1.length() > 0)
					p1 += " and ";
				p1 = p1 + "state='" + address.getState() + "'";
			}
			if (!(address.getDistrict()==null))
			if(!(address.getDistrict().isEmpty())){
				if (p1.length() > 0)
					p1 += " and ";
				p1 = p1 + "district='" + address.getDistrict() + "'";
			}

			sql = sql + p1;
			if(!(p1.length()>0))
				return null;
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String id1 = rs.getString(1);
				String street = rs.getString(2);
				String city = rs.getString(3);
				int pin = rs.getInt(4);
				String state = rs.getString(5);
				String district = rs.getString(6);
			    address1 = new Address(id1, street, city, pin, state, district);
			    list.add(address1);
				}

		} catch (SQLException e) {
			System.out.println("ERROR IN LOADING.....  "+e);
		}finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    preparedStatement = null;
                    System.out.println("Statement closed successfully");
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                    connection = null;
                    System.out.println("connection closed successfully");
                } catch (SQLException e) {
                	System.out.println(e);
                }
            }
        }
		return list;
	}

}
