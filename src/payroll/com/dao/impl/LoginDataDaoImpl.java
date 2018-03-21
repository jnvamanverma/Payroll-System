package payroll.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import payroll.com.dao.LoginDataDao;
import payroll.com.db.util.DBUtil;
import payroll.com.entity.LoginData;

public class LoginDataDaoImpl implements LoginDataDao {
	
	static Connection connection;
	private PreparedStatement preparedStatement=null;
	
	public LoginDataDaoImpl() {
	}
	
	public static void main(String[] args) {
		//LoginData loginData=new LoginData("125","sky10sandeep","admin",0);
				LoginDataDaoImpl loginDataDaoImpl=new LoginDataDaoImpl();
				System.out.println(loginDataDaoImpl.searchLoginData("125"));
			    //System.out.println(loginDataDaoImpl.addLoginData(loginData));
				//System.out.println(loginDataDaoImpl.editLoginData(loginData));
				//LoginData loginData2 = loginDataDaoImpl.searchLoginData("125");
				//for (LoginData loginData2 : list) {
				//	System.out.println(loginData2.getLoginStatus()+loginData2.getPassword()+loginData2.getUserId()+loginData2.getUserType());
				//}
				//System.out.println(loginDataDaoImpl.deleteLoginData("126"));
	}

	@Override
	public String addLoginData(LoginData loginData) {

		String result = "FAIL";
		
		if(loginData==null)
			return result;

		String sql = "INSERT INTO Login_Data ", p1 = "", p2 = "";
		try {
			if (!(loginData.getUserId()==null)) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "USERID";
				p2 = p2 + "'" +loginData.getUserId()+ "'";
			}
			if (!(loginData.getUserType()==null)) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "USERTYPE";
				p2 = p2 + "'" +loginData.getUserType()+ "'";
			}
			if (!(loginData.getLoginStatus()>1)) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "LOGINSTATUS";
				p2 = p2 + Integer.toString(loginData.getLoginStatus());
			}
			if (!(loginData.getPassword()==null)) {
				if (p1.length() > 0) {
					p1 += ",";
					p2 += ",";
				}
				p1 = p1 + "PASSWORD";
				p2 = p2 + "'" +loginData.getPassword()+"'";
			}


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
                    System.out.println("Connection closed successfully");
                } catch (SQLException e) {
                	System.out.println(e);
                }
            }
        }

		return result;
	}

	@Override
	public String editLoginData(LoginData loginData) {
		String result = "FAIL";
		
		if(loginData==null)
			return result;

		String sql = "update LOGIN_DATA set ", p1 = "";

		try {
			

			p1 = p1 + "loginstatus=" + Integer.toString(loginData.getLoginStatus());
			
			if (!(loginData.getPassword()==null)) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + " password='" + loginData.getPassword() + "'";
			}
			if (!(loginData.getUserType()==null)) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "usertype='" + loginData.getUserType() + "'";
			}
		
			sql = sql + p1 + " where userid='" + loginData.getUserId() + "'";
			connection=DBUtil.getConnection();
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
                    System.out.println("Connection closed successfully");
                } catch (SQLException e) {
                	System.out.println(e);
                }
            }
        }

		return result;
	}

	@Override
	public String deleteLoginData(String Id) {
		String sql = "DELETE FROM login_data WHERE userid = '"+Id+"'";
		String result="FAIL";
		if(Id==null)
			return result;

		try {
			System.out.println(sql);
			connection=DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
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
                    System.out.println("Connection closed successfully");
                } catch (SQLException e) {
                	System.out.println(e);
                }
            }
        }

		return result;
	}

	@Override
	public LoginData searchLoginData(String Id) {
		
		LoginData loginData=null;
		if(Id==null)
			return null;
		String sql = "SELECT * FROM LOGIN_DATA where userid='" + Id + "'";

		try {
			connection=DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String userId=rs.getString(1);
				String password=rs.getString(2);
				String usertype=rs.getString(3);
				int loginStatus=rs.getInt(4);
			   loginData=new LoginData(userId,password,usertype,loginStatus);
			   return loginData;
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
                    System.out.println("Connection closed successfully");
                } catch (SQLException e) {
                	System.out.println(e);
                }
            }
        }

		return null;
	}

	@Override
	public ArrayList<LoginData> searchLoginData(LoginData loginData) {
		ArrayList<LoginData>list=new ArrayList<LoginData>();
		LoginData loginData1=null;
		String sql = "SELECT * FROM LOGIN_DATA where ",p1="";

		try {
			
			
			if (!(loginData.getUserType()==null)) {
				if (p1.length() > 0)
					p1 += ",";
				p1 = p1 + "usertype='" + loginData.getUserType() + "'";
			}
			if (!(loginData.getPassword()==null)) {
				if (p1.length() > 0)
					p1 += " and ";
				p1 = p1 + "password='" + loginData.getPassword() + "'";
			}
			
			
			
			if(!(p1.length()>0))
				return null;
			else
				sql+=p1;
			
			System.out.println(sql);
			connection=DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String userId=rs.getString(1);
				String password=rs.getString(2);
				String usertype=rs.getString(3);
				int loginStatus=rs.getInt(4);
			   loginData1=new LoginData(userId,password,usertype,loginStatus);
			list.add(loginData1);
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
                    System.out.println("Connection closed successfully");
                } catch (SQLException e) {
                	System.out.println(e);
                }
            }
        }

		return list;
	}

}
