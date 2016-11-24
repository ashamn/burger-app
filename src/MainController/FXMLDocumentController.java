package MainController;

import Main.*;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.application.HostServices;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Date;


public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button menubutton;
    
    
    @FXML
    private AnchorPane burgerpane;
    @FXML
    private Button burgersmenu;
    @FXML
    private AnchorPane drinkspane;
    @FXML
    private Button drinksmenu;
    @FXML
    private StackPane dessertpane;
    @FXML
    private Button dessertmenu;
    @FXML
    private StackPane saladspane;
    @FXML
    private Button saladsmenu;
    @FXML
    private StackPane revieworder;
    @FXML
    private VBox vboxrevieworder;
    @FXML 
    private Button cartbutton;
    @FXML
    private StackPane entryform;
    @FXML
    private AnchorPane entryformanchor;
    @FXML
    private GridPane entrygridpane;
    @FXML
    private Label ordernumlabel;
    @FXML
    private AnchorPane anchortoolbar;
    
    @FXML
    private TextField firstnameinput;
    @FXML
    private TextField lastnameinput;
    @FXML
    private DatePicker birthdateinput;
    @FXML
    private TextField addressinput;
    @FXML
    private TextField emailinput;
    @FXML
    private TextField contactnoinput;
    @FXML
    private TextField userinput;
    @FXML
    private TextField passwordinput;
    
    
    @FXML
    private TextField usernamelogin;
    @FXML
    private TextField passwordlogin;
     
    @FXML
    private Label loginerrorlabel;
    @FXML
    private Label registrationerrorlabel;
    
    private List<Customer> customers = new ArrayList<>();
	private List<String> listorders = new ArrayList<>();
	private List<Orders> transactions = new ArrayList<>();
	
	private Customer currentcustomer;
    
    double total = 0;
    

	

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        prepareSlideBurgerAnimation();
        prepareSlideDrinksAnimation();
        prepareSlideDessertAnimation();
        prepareSlideSaladsAnimation();
        prepareSlideReviewOrderAnimation();
        ordernumlabel.setVisible(false);
        

    }    
    


    

    private void prepareSlideBurgerAnimation() {
    	

        TranslateTransition openNav=new TranslateTransition(new Duration(350), burgerpane);
        openNav.setToX(0);
        TranslateTransition closeNav=new TranslateTransition(new Duration(350), burgerpane);
        burgersmenu.setOnAction((ActionEvent evt)->{
            if(burgerpane.getTranslateX()!=0){
                openNav.play();
                evt.consume();
            }
        });
        
        menubutton.addEventHandler(ActionEvent.ACTION, (e)-> {
            closeNav.setToX((burgerpane.getWidth()));
            closeNav.play();
        }
    	);
        
    }
        
        private void prepareSlideDrinksAnimation() {
        	

            TranslateTransition openNav1=new TranslateTransition(new Duration(350), drinkspane);
            openNav1.setToX(0);
            TranslateTransition closeNav1=new TranslateTransition(new Duration(350), drinkspane);
            drinksmenu.setOnAction((ActionEvent evt)->{
                if(drinkspane.getTranslateX()!=0){
                    openNav1.play();
                    evt.consume();
                }
            });
            menubutton.addEventHandler(ActionEvent.ACTION, (e)-> {
                closeNav1.setToX(drinkspane.getWidth());
                closeNav1.play();
            }
        	);
        
       
    }
        
        private void prepareSlideDessertAnimation() {
        	
            TranslateTransition openNav2=new TranslateTransition(new Duration(350), dessertpane);
            openNav2.setToX(0);
            TranslateTransition closeNav2=new TranslateTransition(new Duration(350), dessertpane);
            dessertmenu.setOnAction((ActionEvent evt)->{
                if(dessertpane.getTranslateX()!=0){
                    openNav2.play();
                    evt.consume();
                }
            });
            menubutton.addEventHandler(ActionEvent.ACTION, (e)-> {
                closeNav2.setToX(dessertpane.getWidth());
                closeNav2.play();
            }
        	);

    }
        private void prepareSlideSaladsAnimation() {
        	

            TranslateTransition openNav3=new TranslateTransition(new Duration(350), saladspane);
            openNav3.setToX(0);
            TranslateTransition closeNav3=new TranslateTransition(new Duration(350), saladspane);
            saladsmenu.addEventHandler(ActionEvent.ACTION, (e)-> {
               if(saladspane.getTranslateX()!=0){
                    openNav3.play();
                 }
            }
        	);
            menubutton.addEventHandler(ActionEvent.ACTION, (e)-> {
                closeNav3.setToX((saladspane.getWidth()));
                closeNav3.play();
            }
        	);
    }
        
        private void prepareSlideReviewOrderAnimation() {
        	

            TranslateTransition openNav4=new TranslateTransition(new Duration(500), revieworder);
            openNav4.setToX(0);
            TranslateTransition closeNav4=new TranslateTransition(new Duration(500), revieworder);
            cartbutton.addEventHandler(ActionEvent.ACTION, (e)-> {
               if(revieworder.getTranslateX()!=0){
                    openNav4.play();
                    
                    vboxrevieworder.getChildren().clear();
                    Set<String> uniqueset = new HashSet<String>(listorders);
                    
                   this.total = 0;
                    
                    for (String menu : listorders) {
                    	this.total+= Menus.valueOf(menu).price;
					}
                    
                    
                    Label totallabel = new Label("Total Amount: P" + String.valueOf(total));
                    
                    if(total == 0)
                    {
	                totallabel.setVisible(false);
                    ordernumlabel.setVisible(false);
                    }
                    
                    HBox hboxedtotal = new HBox(100);
                    Button save = new Button("Checkout");
                    totallabel.setStyle("-fx-background-color: linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0)); -fx-background-radius: 30; -fx-background-insets: 0,1,2,3,0; -fx-text-fill: #654b00; -fx-font-weight: bold; -fx-font-size: 14px; -fx-padding: 10 20 10 20;");
                    save.setStyle("-fx-background-color: #c3c4c4, linear-gradient(#d6d6d6 50%, white 100%), radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%); -fx-background-radius: 30; -fx-background-insets: 0,1,1; -fx-text-fill: black; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 )");
                    hboxedtotal.setPadding(new Insets(10, 10, 10, 50));
                    hboxedtotal.getChildren().add(totallabel);
                   
            		TranslateTransition openNav5=new TranslateTransition(new Duration(700), entryform);
                    openNav5.setToX(0);
                    
                    save.setOnAction((ActionEvent evt)->{

                    	
                    	fadeouttrans(cartbutton);
                    	fadeouttrans(ordernumlabel);
                    	fadeouttrans(menubutton);
                    	openNav5.play();

                  	
                    });
                    
                    if(!listorders.isEmpty())
                    	hboxedtotal.getChildren().add(save);
                    
             	   vboxrevieworder.getChildren().add(hboxedtotal);
                    
                   for (String menu : uniqueset) {
                	   HBox hboxed = new HBox(10);
                	   Label label = new Label(String.valueOf(Menus.valueOf(menu).name) + " x " + String.valueOf(Collections.frequency(listorders, menu)));
                	   Button minus = new Button(" - ");
                	   label.setMinWidth(300);
                	   label.setAlignment(Pos.CENTER);
                	   label.setStyle("-fx-background-color: linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0)); -fx-background-radius: 30; -fx-background-insets: 0,1,2,3,0; -fx-text-fill: #654b00; -fx-font-weight: bold; -fx-font-size: 14px; -fx-padding: 10 20 10 20;");
                	   minus.setStyle("-fx-background-color: #c3c4c4, linear-gradient(#d6d6d6 50%, white 100%), radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%); -fx-background-radius: 30; -fx-background-insets: 0,1,1; -fx-text-fill: black; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 )");
                	   
                	   minus.setOnAction(new EventHandler<ActionEvent>() {
                		   

						@Override
						public void handle(ActionEvent event) {
							// TODO Auto-generated method stub
							if(Collections.frequency(listorders, menu) == 1){
								

								fadeoutwithwait(hboxed, label);
								fadeoutwithwait(hboxed, minus);

								for (int i = 0; i < listorders.size(); i++) {
									if(listorders.get(i).equals(menu)){
										
										
										listorders.remove(i);
										
										if(!listorders.isEmpty())
										circleoutline();
										
										ordernumlabel.setText(String.valueOf(listorders.size()));
										
										total = 0;
					                    for (String menu : listorders) {
					                    	total+= Menus.valueOf(menu).price;
										}
										
			
					                    
					                    if(total != 0)
					                    totallabel.setText("Total Amount: P" + String.valueOf(total));
					                    else
					                    {

					                    
					                    totallabel.setText("Please Choose an Item");
					                    move(totallabel, 100.0, 150.0);
					                    	
					                    	
					                    	
					                    fadeouttrans(save);
					                    hboxedtotal.getChildren().remove(save);
					                    ordernumlabel.setVisible(false);
					                    
				                    	
				                    	
					                    }
					                    
										break;
									}
								}
							}
							else
							{
								
								for (int i = 0; i < listorders.size(); i++) {
									if(listorders.get(i).equals(menu)){
										listorders.remove(i);
										
										if(!listorders.isEmpty())
										circleoutline();
										
										ordernumlabel.setText(String.valueOf(listorders.size()));
										
										total = 0;
					                    for (String menu : listorders) {
					                    	total+= Menus.valueOf(menu).price;
										}
										
					                    if(total != 0)
					                    totallabel.setText("Total Amount: P" + String.valueOf(total));
					                    else
					                    {
					                    totallabel.setText("Please Choose an Item");
					                    hboxedtotal.getChildren().remove(save);
					                    ordernumlabel.setVisible(false);
					                    }
										break;
									}
								}
								label.setText(String.valueOf(Menus.valueOf(menu).name) + " x " + String.valueOf(Collections.frequency(listorders, menu)));
							}
						}
                	   });

                	   hboxed.setPadding(new Insets(10, 10, 10, 50));
                	   hboxed.getChildren().add(label);
                	   hboxed.getChildren().add(minus);
                	   vboxrevieworder.getChildren().add(hboxed);
                   }
                   

                 }
            }
        	);
            menubutton.addEventHandler(ActionEvent.ACTION, (e)-> {
                closeNav4.setToX((revieworder.getWidth()));
                closeNav4.play();
                vboxrevieworder.getChildren().clear();
            }
        	);
    }
        

    
    public void addtocart(ActionEvent event){
    	
    	if(!ordernumlabel.isVisible())
    		ordernumlabel.setVisible(true);
    	
    	
    
    	circleoutline();

    	
    	Object source = event.getSource();
    	if (source instanceof Button) {
    	    Button clickedBtn = (Button) source;
    	    listorders.add(clickedBtn.getId());
    	    ordernumlabel.setText(String.valueOf(listorders.size()));
    	    

    	}
    	
    }
    
       
       public void entrysubmitbuttonaction(ActionEvent event){
    	    
    	   Button clickedBtn = (Button) event.getSource();
    	   
    	   if((clickedBtn.getId().equals("entrysubmitbutton") && registryvalidation() == true) || (clickedBtn.getId().equals("loginbutton") && loginvalidation() == true))
    	   {
    		   if(clickedBtn.getId().equals("entrysubmitbutton"))
    		   inputnewcustomer();
    		   
    		   addOrders();
    		   
    		   
    	   fadeouttrans(entrygridpane);
    	   entryformanchor.getChildren().clear();
    	    
    	    Label endmessage = new Label("Thank You For Ordering!");
    	    
    	    endmessage.setStyle("-fx-background-color: #c3c4c4, linear-gradient(#d6d6d6 50%, white 100%), radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%); -fx-background-radius: 30; -fx-background-insets: 0,1,1; -fx-text-fill: black; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
    	    endmessage.setMinWidth(350);
    	    endmessage.setMinHeight(20);
    	    endmessage.setPadding(new Insets(10,10,10,10));
    	    endmessage.setAlignment(Pos.CENTER);
    	    StackPane newvbox= new StackPane();
    	    newvbox.getChildren().add(endmessage);
    	    newvbox.setPrefSize(400,400);
    	    newvbox.setPadding(new Insets(0,0,0,70));
    	    newvbox.setOpacity(0);
    	    StackPane.setAlignment(newvbox, Pos.CENTER);
    	    
    	    Button admin = new Button("Admin");
    	    admin.setStyle("-fx-background-color: #c3c4c4, linear-gradient(#d6d6d6 50%, white 100%), radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%); -fx-background-radius: 30; -fx-background-insets: 0,1,1; -fx-text-fill: black; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
    	    admin.setMinWidth(100);
    	    admin.setMinHeight(30);
    	    StackPane adminstack = new StackPane();
    	    adminstack.getChildren().add(admin);
    	    adminstack.setPrefSize(100,30);
    	    adminstack.setPadding(new Insets(0,0,0,0));
    	    adminstack.setOpacity(0);
    	    StackPane.setAlignment(adminstack, Pos.TOP_LEFT);
    	    
    	    
    	    
        	entryformanchor.getChildren().clear();
        	entryformanchor.getChildren().add(newvbox);
        	entryformanchor.getChildren().add(adminstack);
        	
        	
        	fadeintrans(newvbox);
        	fadeintrans(adminstack);
        	
        	
        	admin.addEventHandler(ActionEvent.ACTION, (e)-> {

        		MainMenu main = new MainMenu();
                main.showReports();
                
            }
        	);
        	
        	
       }
    	    
    	   
    	    
       }
       
       public void circleoutline(){
    	   
       	Circle circle = new Circle();
       	circle.setCenterX(269);
       	circle.setCenterY(14.5);
       	circle.setRadius(20.0f);
       	circle.setFill(Color.TRANSPARENT);
       	circle.setStroke(Color.CHOCOLATE);
       	circle.setStrokeWidth(5);
       	
       	anchortoolbar.getChildren().add(circle);
       	
       	ScaleTransition scaleTransition1 = new ScaleTransition(Duration.millis(2000), circle);
       	scaleTransition1.setByX(0.8f);
       	scaleTransition1.setByY(0.8f);
       	scaleTransition1.setCycleCount(1);
       	scaleTransition1.setAutoReverse(true);

       	FadeTransition fadeTransition1 = new FadeTransition(Duration.millis(2000), circle);
       	fadeTransition1.setFromValue(1.0);
       	fadeTransition1.setToValue(0.0);
       	fadeTransition1.setCycleCount(1);
       	fadeTransition1.setAutoReverse(true);
       	 
       	ParallelTransition parallelTransition = new ParallelTransition();
       	parallelTransition.getChildren().addAll(
       			scaleTransition1,
       			fadeTransition1);
       	parallelTransition.setCycleCount(1);
       	  parallelTransition.play();
    	   
       }
       
       public void fadeouttrans(Node node){
   	    FadeTransition ft = new FadeTransition(Duration.millis(700), node);
   	    ft.setFromValue(1.0);
   	    ft.setToValue(0);
   	    ft.setAutoReverse(true);

   	    ft.play();
       }
       
       public void fadeintrans(Node node){
      	    FadeTransition ft = new FadeTransition(Duration.millis(700), node);
      	    ft.setFromValue(0);
      	    ft.setToValue(1.0);
      	    ft.setAutoReverse(true);

      	    ft.play();
          }
       
       public void fadeoutwithwait(Pane parent, Node sibling){
      	    FadeTransition ft = new FadeTransition(Duration.millis(700), sibling);
       	    ft.setFromValue(1.0);
       	    ft.setToValue(0);
       	    ft.setAutoReverse(true);

       	    ft.play();
       	    
    	   ft.setOnFinished(new EventHandler<ActionEvent>(){
               @Override
               public void handle(ActionEvent arg0) {
            	   parent.getChildren().remove(sibling);
               }
           });
       }

       
       public void move(Node node, Double x, Double y){
    	 TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1000), node);
    	 translateTransition.setToX(x);
    	 translateTransition.setToY(y);
    	translateTransition.setCycleCount(1);
    	translateTransition.play();
       }
       
       public boolean registryvalidation(){
    	   
    	   if(birthdateinput.getValue() == null){
    		   registrationerrorlabel.setText("Birthdate field can not be empty");
    		   return false;
    	   }
    	   else if(!cycleemptyvalidation(firstnameinput, "First Name", registrationerrorlabel) || !cycleemptyvalidation(lastnameinput, "Last Name", registrationerrorlabel) || !cycleemptyvalidation(addressinput, "Address", registrationerrorlabel) || !cycleemptyvalidation(emailinput, "Email", registrationerrorlabel) || !cycleemptyvalidation(contactnoinput, "Contact Number", registrationerrorlabel) || !cycleemptyvalidation(userinput, "Username", registrationerrorlabel) || !cycleemptyvalidation(passwordinput, "Password", registrationerrorlabel))
    		   return false;
    		else
    			return true;
       }
       
       public boolean loginvalidation(){
    	   if(!cycleemptyvalidation(usernamelogin, "Username", loginerrorlabel) || !cycleemptyvalidation(passwordlogin, "Password", loginerrorlabel))
    		   return false;
    	   if(!logincheck(loginerrorlabel))
    	   {
    		   return false;
    	   }
    		else
    			return true;
       }
       
       public boolean cycleemptyvalidation(Node node, String field, Node nodeerrorlabel){
    	   if(((TextField) node).getText().trim() == null || ((TextField) node).getText().trim().isEmpty() || ((TextField) node).getText().trim().equals(""))
    	   {
    		   ((Label) nodeerrorlabel).setText(field + " field can not be empty.");
    		   return false;
    	   }
    	   else if((userinput == node && ((TextField) node).getText().trim().length() < 5) || (passwordinput == node && ((TextField) node).getText().trim().length() < 5))
    	   {
    		   ((Label) nodeerrorlabel).setText(field + " should be more than five characters.");
    		   return false;
    	   }
    	   else if((userinput == node && containsIllegals(String.valueOf(((TextField) node).getText().trim())) ) || (passwordinput == node && containsIllegals(String.valueOf(((TextField) node).getText().trim()))) )
    	   {
    		   ((Label) nodeerrorlabel).setText(field + " should not contain illegal characters.");
    		   return false;
    	   }
    	   else if(userinput == node && usernameexistscheck())
    	   {
    		   ((Label) nodeerrorlabel).setText(field + " already exists.");
    		   return false;
    	   }
    	   else
    	   return true;
       }
       
       public void inputnewcustomer(){
    	   
    	   try {
					this.customers = FileWriterAndReader.readFromFile();
					
					this.currentcustomer = new Customer(
				    		firstnameinput.getText().trim(),
					    	   lastnameinput.getText().trim(),
					    	   birthdateinput.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
					    	   addressinput.getText().trim(),
					    	   emailinput.getText().trim(),
					    	   contactnoinput.getText().trim(),
					    	   userinput.getText().trim(),
					    	   passwordinput.getText().trim(),
					    	   String.valueOf(customers.size())
				   						);
					
			    	   customers.add(this.currentcustomer);
					
				} catch (IOException e1) {

					
					this.currentcustomer = new Customer(
				    		firstnameinput.getText().trim(),
					    	   lastnameinput.getText().trim(),
					    	   birthdateinput.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
					    	   addressinput.getText().trim(),
					    	   emailinput.getText().trim(),
					    	   contactnoinput.getText().trim(),
					    	   userinput.getText().trim(),
					    	   passwordinput.getText().trim(),
					    	   "0"
				   						);
					
			    	   customers.add(this.currentcustomer);
			    			   
				}


    	   try {
				FileWriterAndReader.writeTodatabase(this.customers);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				System.out.println("Error writing file");
			} 
    	   
    	   }
       
       public boolean containsIllegals(String toExamine) {
    	    Pattern pattern = Pattern.compile("[~\\!\\'\\$\\&\\(\\)\\;\\'\\.\\?\\=\\-\\#\\@*+%{}<>\\[\\]|\"\\_^]");
    	    Matcher matcher = pattern.matcher(toExamine);
    	    return matcher.find();
    	}
       
   		public boolean usernameexistscheck(){
   			try {
				this.customers = FileWriterAndReader.readFromFile();
				for(Customer custmrs : this.customers){
					if(custmrs.getUsername().equals(String.valueOf(userinput.getText().trim())))
					{
						return true;							
					}

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				return false;
			}
   			
   			return false;
   		}
       
   		public boolean logincheck(Label nodeerrorlabel){
   			
   			try {
				this.customers = FileWriterAndReader.readFromFile();
				for(Customer custmrs : this.customers){
					if((custmrs.getUsername().equals(String.valueOf(usernamelogin.getText().trim()))) && (custmrs.getPassword().equals(String.valueOf(passwordlogin.getText().trim()))))
					{
					this.currentcustomer = custmrs;
					 return true;
					}
				}
			} catch (IOException e) {
				nodeerrorlabel.setText("Can't access database");
				 return false;
			}
   			nodeerrorlabel.setText("Invalid Username or Password");
   			return false;
   		}
   		
   		public void addOrders(){
   			
   			DateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd_HH:mm:ss");
   	        Date date = new Date();

   			
   			try {
				this.transactions = FileWriterAndReader.readFromFileTransactions();
				transactions.add(new Orders(transactions.size(), listorders, Integer.parseInt(this.currentcustomer.getCustomerid()), this.total, String.valueOf(dateFormat.format(date))));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//  e.printStackTrace();
				transactions.add(new Orders(transactions.size(), listorders, Integer.parseInt(this.currentcustomer.getCustomerid()), this.total, String.valueOf(dateFormat.format(date))));
			}
   			
   			
   			try {
				FileWriterAndReader.writeTodatabaseTransactions(transactions);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
   			 
   			
   		}
       
}