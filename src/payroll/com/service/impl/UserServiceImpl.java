package payroll.com.service.impl;

import payroll.com.dao.impl.EmployeeDaoImpl;
import payroll.com.dao.impl.LoginDataDaoImpl;
import payroll.com.entity.Employee;
import payroll.com.entity.LoginData;
import payroll.com.service.UserService;

public class UserServiceImpl implements UserService{

	 LoginDataDaoImpl daoImpl=new LoginDataDaoImpl();
	
	@Override
	public boolean login(LoginData user) {

		// Validation for user id and password

		if (user.getUserId() == null) {
			return false;
		}
		if (user.getUserId().isEmpty()) {
			return false;
		}
		if (user.getPassword() == null) {
			return false;
		}
		if (user.getPassword().isEmpty()) {
			return false;
		}
		
		String Id=user.getUserId();
		LoginData loginData=daoImpl.searchLoginData(Id);
		
		if(loginData==null)
			return false;
		
		if(loginData.getUserId().equals(user.getUserId())&&loginData.getPassword().equals(user.getPassword()))
			{
			 user.setLoginStatus(1);
			 System.out.println(daoImpl.editLoginData(user)); 
			 return true;
			}
		else 
			return false;
		
	
		
	}

	@Override
	public String getUserType(String id) {
		if (id == null) {
			return "FAIL";
		}
		if (id.isEmpty()) {
			return "FAIL";
		}

		LoginData loginData=daoImpl.searchLoginData(id);
		if(loginData==null)
			return "FAIL";
		String response = loginData.getUserType();

		if (response == null) {
			return "FAIL";
		}
		return response;
	}

	@Override
	public boolean changePassword(LoginData loginData) {
	   
	     if(loginData.getPassword()==null)
	    	 return false;
	     if(loginData.getPassword().isEmpty())
	    	 return false;
	     
	 String response=daoImpl.editLoginData(loginData);
	if(response.equals("FAIL"))
		return false;
	else 
		return true;
	 
	}
	

	@Override
	public boolean aadharVerification(Employee employee) {
		 if(employee.getAadharnumber()==null)
		    	return false;
		 if(employee.getAadharnumber().isEmpty())
			 return false;
		 
		 EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
		 String id=employee.getUserId();
		 Employee emp=daoImpl.searchEmployee(id);
		 
		 if(emp==null)
			 return false;
		
		 if(employee.getAadharnumber().equals(emp.getAadharnumber()))
			 return true;
		 else 
			 return false;

	}

	@Override
	public boolean logOut(String userId) {
		if(userId==null)
			return false;
		if(userId.isEmpty())
			return false;
		
		LoginData loginData=new LoginData();
		loginData.setUserId(userId);
		loginData.setLoginStatus(0);
		
		String response=daoImpl.editLoginData(loginData);
		if(response=="FAIL")
		return false;
		else 
			return true;
	}


	
	
	

}
