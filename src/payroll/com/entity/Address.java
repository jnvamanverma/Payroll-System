package payroll.com.entity;

public class Address {

	private String userId;
	private String street;
	private String city;
	private int pin=0;
	private String state;
	private String district;

	



	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String userId, String street, String city, int pin, String state, String district) {
		super();
		this.userId = userId;
		this.street = street;
		this.city = city;
		this.pin = pin;
		this.state = state;
		this.district = district;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

}
