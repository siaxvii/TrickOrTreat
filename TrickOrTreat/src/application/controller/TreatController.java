/**
 * 
 * @author Lasya Yakkala IQY403
 * CS 3443 - 002
 * 
 * This class will control all elements on the Treat.fxml page
 */

package application.controller;

//imports all the necessary packages
import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.*;

//Uses the Initializable interface as well as EventHandler
public class TreatController implements EventHandler<ActionEvent>, Initializable {
	
	//Initialize FXML components in Treat
	@FXML ImageView image;
	@FXML Image img;
	
	//Initializes a random variable that will be later corresponded to each image
	Random rand = new Random();
	
	//initialize function is setting up the Treat view before the user interacts with the page
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//generates a random number from 1-9
		int num = rand.nextInt(9) + 1;
		
		//Below series of if statements sets each image to its respective randomized number from 1-9
		if(num == 1) {
			img = new Image(getClass().getResourceAsStream("image1.jpeg"));  //sets the location of the image
			image.setImage(img); //ImageView gets assigned to the particular image
		}
		if(num == 2) {
			img = new Image(getClass().getResourceAsStream("image2.jpeg"));
			image.setImage(img);
		}
		if(num == 3) {
			img = new Image(getClass().getResourceAsStream("image3.jpeg"));
			image.setImage(img);
		}
		if(num == 4) {
			img = new Image(getClass().getResourceAsStream("image4.jpeg"));
			image.setImage(img);
		}
		if(num == 5) {
			img = new Image(getClass().getResourceAsStream("image5.jpeg"));
			image.setImage(img);
		}
		if(num == 6) {
			img = new Image(getClass().getResourceAsStream("image6.jpeg"));
			image.setImage(img);
		}
		if(num == 7) {
			img = new Image(getClass().getResourceAsStream("image7.jpeg"));
			image.setImage(img);
		}
		if(num == 8) {
			img = new Image(getClass().getResourceAsStream("image8.jpeg"));
			image.setImage(img);
		}
		if(num == 9) {
			img = new Image(getClass().getResourceAsStream("image9.jpeg"));
			image.setImage(img);
		}	
	}
	
	@Override
	public void handle(ActionEvent event) {
		
		Button b = (Button) event.getSource();
		
		//When home button is pressed		
		if(b.getId().equals("home")) {
			try {
		
				FXMLLoader loader = new FXMLLoader();
				
				//The location of the view gets set to the Main homepage
				loader.setLocation(getClass().getResource("../view/Main.fxml"));
		
				Scene scene = new Scene(loader.load());
		
				Main.stage.setScene(scene);
				Main.stage.show();
						
				} catch(Exception e) {
					e.printStackTrace();
				}
		}
		
		
	}
	
	
}
