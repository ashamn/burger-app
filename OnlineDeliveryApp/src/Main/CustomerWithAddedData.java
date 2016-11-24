package Main;

public class CustomerWithAddedData extends Customer{

	private String transactions;
	private String transactionids;

	
	public CustomerWithAddedData(String firstname, String lastname, String birthdate, String address, String email,
			String contactno, String username, String password, String customerid, String transactions, String transactionids) {
		
		super(firstname, lastname, birthdate, address, email, contactno, username, password, customerid);
		
		this.transactions = transactions;
		this.transactionids = transactionids;
	}


	
	public String getTransactions() {
		return transactions;
	}



	public String getTransactionids() {
		return transactionids;
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
