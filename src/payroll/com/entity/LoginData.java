package payroll.com.entity;

import java.util.ArrayList;

public class LoginData {

	private String userId = null;
	private String password = null;
	private String userType = null;
	private int loginStatus = 0;

	public LoginData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginData(String userId, String password, String userType, int loginStatus) {
		super();
		this.userId = userId;
		this.password = password;
		this.userType = userType;
		this.loginStatus = loginStatus;
	}

	public LoginData(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}

	/*
	 * public boolean equals(Object loginData2){ boolean result =false;
	 * 
	 * if(this.getLoginStatus()==loginData2.getLoginStatus())
	 * if(this.getPassword().equals(loginData2.getPassword()))
	 * if(this.getUserId().equals(loginData2.getUserId()))
	 * if(this.getUserType().equals(loginData2.getUserType())) result=true;
	 * 
	 * return result; }
	 */

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LoginData) {

			LoginData loginData = (LoginData) obj;
			if(this.getLoginStatus()==loginData.getLoginStatus()&&this.getPassword().equals(loginData.getPassword())&&this.getUserId().equals(loginData.getUserId())&&this.getUserType().equals(loginData.getUserType()))
				return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	public boolean equalto(ArrayList<LoginData> list, ArrayList<LoginData> list2) {


		if (!(list.size() == list2.size()))
			return false;

		LoginData loginData, loginData2;
		for (int i = 0; i < list2.size(); i++) {
			loginData = list.get(i);
			loginData2 = list.get(i);
			if (!(loginData.equals(loginData2)))
				return false;
		}

		return false;
	}

}
