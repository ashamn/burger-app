
package Main;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainMenu extends Application {
    
	
    @Override
    public void start(Stage stage) throws Exception {
    	
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLDocument.fxml")); 
        Scene scene = new Scene(root, 500, 500);
        scene.getStylesheets().add("/fxml/styles/style.css");
        
        stage.setTitle("Burger Bites App");
        stage.getIcons().add(new Image("/fxml/images/burgerico.png"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();
        

    }
    
    public void showReports() {
        Stage primaryStage = new Stage();

        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLAdmin.fxml")); 
            Scene scene = new Scene(root, 900, 600);
            scene.getStylesheets().add("/fxml/styles/style.css");
            
            primaryStage.setTitle("Burger Bites Report");
            primaryStage.getIcons().add(new Image("/fxml/images/burgerico.png"));
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.sizeToScene();
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
    

    
}