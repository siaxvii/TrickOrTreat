/**
 * 
 * @author Lasya Yakkala IQY403
 * CS 3443 - 002
 * 
 * This class will control all elements on the Trick.fxml page
 */

package application.controller;

//imports all the necessary packages
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.Trivia;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

//Uses the Initializable interface as well as EventHandler
public class TrickController implements EventHandler<ActionEvent>, Initializable{
	//Creates all the FXML components required for the Trick view
	@FXML Label question;
	@FXML Label answer;
	@FXML Button option1;
	@FXML Button option2;
	@FXML Button option3;
	
	//Creates the static Trivia object to be used in the initialize function as well as the handle function
	//Cannot be individually declared in each function because depends on the same random value generated
	public static Trivia t;
	
	
	//initialize function is setting up the Trick view before the user interacts with the page
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Loads one trivia object from the CSV file
		t = Trivia.loadTrivia("data/trivia.csv");
		
		//Sets the GUI components corresponding to the values from the trivia object derived from the CSV
		question.setText(t.getQuestion());
		option1.setText(t.getOption1());
		option2.setText(t.getOption2());
		option3.setText(t.getOption3());
	}
	
	
	//handle method is invoked when the user interacts with any button on the Trick view
	public void handle(ActionEvent event) {
		
		//generic button variable that will later be referenced using its specific ID
		Button b = (Button) event.getSource();
		
		//If the user selects "home"
		if(b.getId().equals("home")) {
			try {
				//The user will be navigated to the home page, this code is setting and loading that location
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("../view/Main.fxml"));

				Scene scene = new Scene(loader.load());
				
				Main.stage.setScene(scene);
				Main.stage.show();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//If the user selects option 1 for the corresponding trivia question
		if(b.getId().equals("option1")) {
			//If the option contains the text in the answer, it will display the answer label in green
			//User selected the correct answer!
			if(t.getAnswer().contains(t.getOption1())) {
				answer.setTextFill(Color.GREEN);
				answer.setText(t.getAnswer());
			}
			//Otherwise, the answer label will be displayed in red
			else {
				answer.setTextFill(Color.RED);
				answer.setText(t.getAnswer());
			}
			
		}
		
		//If the user selects option 2 for the corresponding trivia question
		if(b.getId().equals("option2")) {
			//If the option contains the text in the answer, it will display the answer label in green
			//User selected the correct answer!
			if(t.getAnswer().contains(t.getOption2())) {
				answer.setTextFill(Color.GREEN);
				answer.setText(t.getAnswer());
			}
			//Otherwise, the answer label will be displayed in red
			else {
				answer.setTextFill(Color.RED);
				answer.setText(t.getAnswer());
			}
			
		}
		
		//If the user selects option 3 for the corresponding trivia question
		if(b.getId().equals("option3")) {
			//If the option contains the text in the answer, it will display the answer label in green
			//User selected the correct answer!
			if(t.getAnswer().contains(t.getOption3())) {
				answer.setTextFill(Color.GREEN);
				answer.setText(t.getAnswer());
			}
			//Otherwise, the answer label will be displayed in red
			else {
				answer.setTextFill(Color.RED);
				answer.setText(t.getAnswer());
			}
			
		}
		
		
	}
	
}