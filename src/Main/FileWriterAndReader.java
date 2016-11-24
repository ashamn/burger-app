package Main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileWriterAndReader{
	

	
	public static List<Customer> readFromFile() throws IOException{
    	List<String[]> liist = new ArrayList<String[]>();

        String fileName = "customers.txt";
        FileReader file = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(file);
        String line;
        while((line = reader.readLine()) != null ) {
            liist.add(line.split(","));
        }
        reader.close();
        file.close();
        
        List<Customer> accounts = new ArrayList<>();
        
        for(int a=0; a<liist.size(); a++)
        {
        	List<String> listing = new ArrayList<>();
        	for(String b: (String[])liist.get(a))
        	{
        		listing.add(b);
        	}       	

        	accounts.add(new Customer(
        			listing.get(0).trim(), 
        			listing.get(1).trim(), 
        			listing.get(2).trim(), 
        			listing.get(3).trim(), 
        			listing.get(4).trim(), 
        			listing.get(5).trim(), 
        			listing.get(6).trim(), 
        			listing.get(7).trim(),        			
        			listing.get(8).trim()
        			));
        }
     	return accounts;
        
	}
	
	
	public static void writeTodatabase(List<Customer> list) throws IOException{
		
		class runnble implements Runnable {

			@Override
			public void run() {
			
				String fileName = "customers.txt";
			    FileWriter file = null;
			    try{
			    file =  new FileWriter(fileName);           
			    PrintWriter pw = new PrintWriter(file);
			    
			    
				for(Customer ba: list)
				{
					pw.println(toSetPatternEntry(ba));
				}
			    
				
			    pw.flush();
			    pw.close();
			    } catch(FileNotFoundException ex) {
			        System.out.println("File not found....");
			    } catch (IOException e) {
				} finally {
			        try {
						file.close();
					} catch (IOException e) {
					}
			    }
			    
			    
				

					
				}
				


		}
		
	   Thread t = new Thread(new runnble());
	    t.start();
		
		

		}


	
	    
	    public static String toSetPatternEntry(Customer entry) { 
	    	String s = entry.getFirstname() + ", " + entry.getLastname() + ", " + entry.getBirthdate() + ", " + entry.getAddress() + ", " + entry.getEmail() + ", " + entry.getContactno() + ", " + entry.getUsername() + ", " + entry.getPassword() + ", " + entry.getCustomerid();
	    	return s;
	    }
	    
	    
	    public static List<Orders> readFromFileTransactions() throws IOException{
	    	List<String[]> liist = new ArrayList<String[]>();

	        String fileName = "transactions.txt";
	        FileReader file = new FileReader(fileName);
	        BufferedReader reader = new BufferedReader(file);
	        String line;
	        while((line = reader.readLine()) != null ) {
	            liist.add(line.split(","));
	        }
	        reader.close();
	        file.close();
	        
	        List<Orders> orders = new ArrayList<>();
	        
	        for(int a=0; a<liist.size(); a++)
	        {
	        	List<String> listing = new ArrayList<>();
	        	for(String b: (String[])liist.get(a))
	        	{
	        		listing.add(b);
	        	}       	

	        	orders.add(new Orders(
	        			Integer.parseInt(listing.get(0).trim()), 
	        			parseOrderList(listing.get(1).trim()), 
	        			Integer.parseInt(listing.get(2).trim()), 
	        			Double.parseDouble(listing.get(3).trim()),
	        			String.valueOf(listing.get(4).trim())
	        			));
	        }
	     	return orders;
	        
	        
		}
		
		
		public static List<String> parseOrderList(String string){
			
			List<String> orderlist = new ArrayList<>();
		

				// TODO Auto-generated method stub
				String[] parts = string.trim().replaceAll("\\[", "").replaceAll("\\]", "").split(":");

				for (String strings : parts) {
					 orderlist.add(strings);
				}

			return orderlist;

		}

	    
		public static void writeTodatabaseTransactions(List<Orders> list) throws IOException{
			
			String fileName = "transactions.txt";
		    FileWriter file = null;
		    try{
		    file =  new FileWriter(fileName);           
		    PrintWriter pw = new PrintWriter(file);
		    
			for(Orders ba: list)
			{
				pw.println(toSetPatternEntryTransactions(ba));
			}
			
		    pw.flush();
		    pw.close();
		    } catch(FileNotFoundException ex) {
		        System.out.println("File not found....");
		    } finally {
		        file.close();
		    }
	    
		}
		
		public static String parseOrderListOut(List<String> orders){
			
			String s = "[";
			
			for (String string : orders)
				s = s.concat(string + ":");
			
			s = (s.substring(0, s.length()-1)).concat("]");
		
			return s;
		}
		
		
	    public static String toSetPatternEntryTransactions(Orders entry) { 
	    	String s = entry.getOrdernumber() + ", " + parseOrderListOut(entry.getOrderlist()) + ", " + entry.getCustomerid() + ", " + entry.getTotalamount() + ", " + entry.getTimestamp();
	    	return s;
	    }





		
}
