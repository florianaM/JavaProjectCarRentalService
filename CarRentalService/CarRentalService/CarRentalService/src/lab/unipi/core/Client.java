package lab.unipi.core;

public class Client {
	
	
	//Arxikopoihsh twn fields
	private String IDnumber;
	private String licenseNumber;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String telephoneNumber;
	
	//Constructor
	public Client(String IDnumber, String licenseNumber, String firstName, String lastName, String email, String address, String telephoneNumber) {
		this.IDnumber = IDnumber;
		this.licenseNumber = licenseNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.telephoneNumber = telephoneNumber;
	}

	
	//Getters kai Setters
	public String getIDnumber() {
		return this.IDnumber;
	}

	public void setIDnumber(String IDnumber) {
		this.IDnumber = IDnumber;
	}

	public String getLicenseNumber() {
		return this.licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephoneNumber() {
		return this.telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	
	
	
	
}
