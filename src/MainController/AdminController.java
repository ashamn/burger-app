package MainController;

import Main.*;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class AdminController implements  Initializable{

    private List<Customer> customers = new ArrayList<>();
	private List<Orders> transactions = new ArrayList<>();
	private List<CustomerWithAddedData> customr = new ArrayList<>();
	
	   @FXML
	   private PieChart piechart;
	   
	   @FXML
	   private Label totalorderslabel;
	   
	   @FXML
	   private Label totalcustomerslabel;
	   
	   @FXML
	   private Tab customerstab;
	   
	   @FXML
	   private TableView<CustomerWithAddedData> customerstable;
	   
	   @FXML
	   private TableView<Orders> transactionstable;
	   
	   @FXML
	   private TabPane tabpane;
	   
	   @FXML
	   private Tab transactionstab;
	   
	   @FXML
	   private LineChart<String, Integer> linechart;
	   
	   @FXML
	   private Label salespercent;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		getTransactions();
		getCustomers();
		setPieChart();
		setTotalOrdersLabel();
		setTotalCustomersLabel();
		getTransactionsperCustomer();
		setCustomersTable();
		setTransactionsTable();
		settotalorderslabel();
		
		
		getMonthSales();
		setLineChart();
		
	//	getsalespercent();
	}


	
   		public void getTransactions(){
   			
   			try {
				this.transactions = FileWriterAndReader.readFromFileTransactions();
			} catch (IOException e) {
				
			}
   		}
   		public void getCustomers(){
   			
   			try {
   				this.customers = FileWriterAndReader.readFromFile();
			} catch (IOException e) {
				
			}
   		}
   		
   		public void setPieChart(){
   			
   			Set<String> uniqueset = new HashSet<String>(aggregateItems());
   			PieChart.Data[] piecharts = new PieChart.Data[uniqueset.size()];

   				int i = 0;
   		       for (String menu : uniqueset) {
   		    	  piecharts[i] = new PieChart.Data(String.valueOf(Menus.valueOf(menu).name), Collections.frequency(aggregateItems(), menu));
   		    	i++;
			}
   			
   		    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(piecharts);
   		 piechart.setData(pieChartData);
   			
   		}
   		
   		
   		public List<String> aggregateItems(){
   			
   			List<String> items = new ArrayList<>();
   			for(Orders orders :transactions)
   			{
   				for(String item : orders.getOrderlist() )
   				items.add(item);
   			}
   			
   			return items;
   		}
   		
   		public void setTotalOrdersLabel(){
   			
   			totalorderslabel.setText(String.valueOf(transactions.size()));
   			
   		}
   		
   		public void setTotalCustomersLabel(){
   			
   			totalcustomerslabel.setText(String.valueOf(customers.size()));
   			
   		}
   		
   		public void setTransactionsTable(){
   			transactionstable.setEditable(false);
   			
   	        TableColumn<Orders, Integer> ordernumbercol = new TableColumn<Orders, Integer>("Order No");
   	        ordernumbercol.setCellValueFactory(new PropertyValueFactory<Orders, Integer>("ordernumber"));
   	    
   	        TableColumn<Orders, List<String>> orderlistcol = new TableColumn<Orders, List<String>>("Order List");
   	     orderlistcol.setCellValueFactory(new PropertyValueFactory<Orders, List<String>>("orderlist"));
   	     
	        TableColumn<Orders, Integer> customeridcol = new TableColumn<Orders, Integer>("Customer ID");
	        customeridcol.setCellValueFactory(new PropertyValueFactory<Orders, Integer>("customerid"));
	        
	        TableColumn<Orders, Double> totalamountcol = new TableColumn<Orders, Double>("Total Amount");
	        totalamountcol.setCellValueFactory(new PropertyValueFactory<Orders, Double>("totalamount"));
	        
	        TableColumn<Orders, String> timestampcol = new TableColumn<Orders, String>("Timestamp");
	        timestampcol.setCellValueFactory(new PropertyValueFactory<Orders, String>("timestamp"));
   			
   			Orders[] trans = new Orders[transactions.size()];
   			
   			int i = 0;
   		    for(Orders or : transactions){
   		    	trans[i] = or;
   		    	i++;
   		    }
   		    
   		    
   		    
     		 ObservableList<Orders> data = FXCollections.observableArrayList(trans);
     	
   		
     		 
     		transactionstable.setItems(data);

        	 transactionstable.getColumns().addAll(ordernumbercol, customeridcol, orderlistcol, totalamountcol, timestampcol);
        		
   		}
   		
   		public void setCustomersTable(){
   			
   			customerstable.setEditable(false);
   			
   	        TableColumn<CustomerWithAddedData, String> firstnamecol = new TableColumn<CustomerWithAddedData, String>("First Name");
   	        firstnamecol.setCellValueFactory(new PropertyValueFactory<CustomerWithAddedData, String>("firstname"));
   	        
  	        TableColumn<CustomerWithAddedData, String> lastnamecol = new TableColumn<CustomerWithAddedData, String>("Last Name");
   	        lastnamecol.setCellValueFactory(new PropertyValueFactory<CustomerWithAddedData, String>("lastname"));
   	        
   	        TableColumn<CustomerWithAddedData, String> birthdatecol = new TableColumn<CustomerWithAddedData, String>("Birthdate");
   	        birthdatecol.setCellValueFactory(new PropertyValueFactory<CustomerWithAddedData, String>("birthdate"));
   			
   	        TableColumn<CustomerWithAddedData, String> addresscol = new TableColumn<CustomerWithAddedData, String>("Address");
   	        addresscol.setCellValueFactory(new PropertyValueFactory<CustomerWithAddedData, String>("address"));
   	        
   	        TableColumn<CustomerWithAddedData, String> emailcol = new TableColumn<CustomerWithAddedData, String>("Email");
   	        emailcol.setCellValueFactory(new PropertyValueFactory<CustomerWithAddedData, String>("email"));
   	        
   	        TableColumn<CustomerWithAddedData, String> contactnocol = new TableColumn<CustomerWithAddedData, String>("Contact No");
   	        contactnocol.setCellValueFactory(new PropertyValueFactory<CustomerWithAddedData, String>("contactno"));
   	        
   	        TableColumn<CustomerWithAddedData, String> usernamecol = new TableColumn<CustomerWithAddedData, String>("Username");
   	        usernamecol.setCellValueFactory(new PropertyValueFactory<CustomerWithAddedData, String>("username"));
   	        
   	        TableColumn<CustomerWithAddedData, String> passwordcol = new TableColumn<CustomerWithAddedData, String>("Password");
   	        passwordcol.setCellValueFactory(new PropertyValueFactory<CustomerWithAddedData, String>("password"));
   	        
   	        TableColumn<CustomerWithAddedData, String> customeridcol = new TableColumn<CustomerWithAddedData, String>("Customer ID");
   	     
   	     customeridcol.setCellValueFactory(new PropertyValueFactory<CustomerWithAddedData, String>("customerid"));
   	        
   	        TableColumn<CustomerWithAddedData, String> transactionscol = new TableColumn<CustomerWithAddedData, String>("Transactions");
   	     transactionscol.setCellValueFactory(new PropertyValueFactory<CustomerWithAddedData, String>("transactions"));
   	     
	        TableColumn<CustomerWithAddedData, String> transactionidscol = new TableColumn<CustomerWithAddedData, String>("Transactions Ids");
	        transactionidscol.setCellValueFactory(new PropertyValueFactory<CustomerWithAddedData, String>("transactionids"));
   			
   			
   			Customer[] customrs = new Customer[customr.size()];
   			
   			int i = 0;
   		    for(Customer cus : customr){
   		    	customrs[i] = cus;
   		    	i++;
   		    }
   			


   		    
   		 ObservableList<CustomerWithAddedData> data = FXCollections.observableArrayList(customr);
   		customerstable.setItems(data);

   		
   		customerstable.getColumns().addAll(customeridcol, firstnamecol, lastnamecol, birthdatecol, addresscol, emailcol, contactnocol, usernamecol, passwordcol, transactionscol, transactionidscol);
   			
   		}
   		
   		public void getTransactionsperCustomer(){
   			
   			List<String> ids = new ArrayList<>();

   			
   			for(Orders ord : transactions){
   				ids.add(String.valueOf(ord.getCustomerid()));
   			}
   			
   			Set<String> uniqueset = new HashSet<String>(ids);		
   			Map<String, String> map = new HashMap<>();
   			
   			
   			for(Orders ord : transactions){
   				for (String id : uniqueset)
   				{
   					if(String.valueOf(ord.getCustomerid()).equals(id)){
   						String b = map.get(id);
   						if(b != null)
   						b = b + String.valueOf(ord.getOrdernumber()) + ",";
   						else 
   						b = String.valueOf(ord.getOrdernumber()) + ",";
   						
   						map.put(id, b);
   					}
   					
   				}
   			}
   			
   			for (Entry<String, String> entry : map.entrySet()) {
   				map.put(entry.getKey(), (entry.getValue()).substring(0, entry.getValue().length() - 1));
			}

   			
   			for (Customer cus : customers) {
   				this.customr.add(new CustomerWithAddedData(cus.getFirstname(), cus.getLastname(), cus.getBirthdate(), cus.getAddress(), cus.getEmail(), cus.getContactno(), cus.getUsername(), cus.getPassword(), cus.getCustomerid(), String.valueOf(Collections.frequency(ids, cus.getCustomerid())), map.get(cus.getCustomerid())));
			}
   			
   		}
   		
   		public List<String> parseTimeStamp(String s){
   			List<String> times = new ArrayList<>();
   			
   			String[] divide = new String[2];
   			
			String[] parts = s.trim().split("_");

			
			int i =0;
			for (String strings : parts) {
				 divide[i] = strings;
				 i++;
			}
			
			String[] dates = divide[0].trim().split(":");
			
			
			String[] time = divide[1].trim().split(":");
			
			
			times.add(dates[0]);
			times.add(dates[1]);
			times.add(dates[2]);
			times.add(time[0]);
			times.add(time[1]);
			times.add(time[2]);


			return times;
   		}
   		
   		public void setLineChart(){
   			

   	     XYChart.Series series = new XYChart.Series();
         series.setName("Days of Month");


         for (int i = 0, y = 1; i < getMonthSales().length; i++, y++) {
        	 series.getData().add(new XYChart.Data(String.valueOf(y), getMonthSales()[i]));	

		}
         
         linechart.getData().add(series);
         
         
         
         
   		}
   		
   		public void getsalespercent(){

   			
   			
      		 DateFormat dateFormat = new SimpleDateFormat("dd");
	        Date date = new Date();
   			
	        int previousdate = Integer.parseInt(dateFormat.format(date)) - 1;
	        
	        int previoussale = getMonthSales()[previousdate];
	        int presentsale = getMonthSales()[Integer.parseInt(dateFormat.format(date))];
	        if(previoussale > presentsale)
	        	salespercent.setText(String.valueOf(" -" + (previoussale - presentsale) + " sale"));
	        else if(presentsale < previoussale)
	        	salespercent.setText(String.valueOf(" +" + (presentsale - previoussale) + " sale"));
	        
	     
   		}
   		
   		
   		public int[] getMonthSales(){
   			
   		 DateFormat dateFormat = new SimpleDateFormat("MM");
	        Date date = new Date();
	        
	        Calendar now = Calendar.getInstance();
   			
	        YearMonth yearMonthObject = YearMonth.of(now.get(Calendar.YEAR), Integer.parseInt(dateFormat.format(date)));
	        int daysInMonth = yearMonthObject.lengthOfMonth();
   			
	        int[] days = new int[daysInMonth];
	        
	        
	        
	        for (int i = 0, y = 1; i < daysInMonth; i++, y++) {
	        	days[i] = 0;
	   			for(Orders tr : this.transactions)
	   			{


	   				if((String.valueOf(dateFormat.format(date))).equals(String.valueOf((parseTimeStamp(tr.getTimestamp()).get(1)))) && (String.valueOf(y)).equals(String.valueOf((parseTimeStamp(tr.getTimestamp()).get(2))))){
	   					days[i] = days[i] + 1;
	   					
	   				}
	   				
	   			
	   			}
	   			
			}


	      

	        
	       return days;
   			
   		}
   		
   		public void settotalorderslabel(){
   		totalorderslabel.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
		   		 tabpane.getSelectionModel().select(transactionstab);
			}
        });
   		
   		totalcustomerslabel.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
		   		 tabpane.getSelectionModel().select(customerstab);
			}
        });
   		
   		}
   		
}
