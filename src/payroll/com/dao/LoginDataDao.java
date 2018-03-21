package payroll.com.dao;

import java.util.ArrayList;

import payroll.com.entity.LoginData;;

public interface LoginDataDao {
	String addLoginData(LoginData loginData);
	public String editLoginData(LoginData loginData);
	public String deleteLoginData(String Id);
	public LoginData searchLoginData(String Id);
	public ArrayList<LoginData> searchLoginData(LoginData loginData);
}
