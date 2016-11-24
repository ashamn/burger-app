package Main;

public class Customer {
	

	protected String firstname;
	protected String lastname;
	protected String birthdate;
	protected String address;
	protected String email;
	protected String contactno;
	protected String username;
	protected String password;
	protected String customerid;
	
	public Customer(String firstname, String lastname, String birthdate, String address, String email, String contactno,
			String username, String password, String customerid) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.address = address;
		this.email = email;
		this.contactno = contactno;
		this.username = username;
		this.password = password;
		this.customerid = customerid;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getContactno() {
		return contactno;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getCustomerid() {
		return customerid;
	}

	

	
	
}
