package payroll.com.dao;

import java.util.ArrayList;

import payroll.com.entity.Address;

public interface AddressDao {

	String addAddress(Address address);
	public String editAddress(Address address);
	public String deleteAddress(String Id);
	public Address searchAddress(String Id);
	public ArrayList<Address> searchAddress(Address address);

}
