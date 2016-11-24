package Main;

import java.util.ArrayList;
import java.util.List;

public class Orders {
	
	private int ordernumber;
	private List<String> orderlist = new ArrayList<>();
	private int customerid;
	private double totalamount;
	private String timestamp;
	
	public Orders(int ordernumber, List<String> orderlist, int customerid, double totalamount, String timestamp) {

		this.ordernumber = ordernumber;
		this.orderlist = orderlist;
		this.customerid = customerid;
		this.totalamount = totalamount;
		this.timestamp = timestamp;
	}

	public int getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(int ordernumber) {
		this.ordernumber = ordernumber;
	}

	public List<String> getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(List<String> orderlist) {
		this.orderlist = orderlist;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}

	public String getTimestamp() {
		return timestamp;
	}
	
	
	

	

	
	
	
}
