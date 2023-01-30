/**
 * 
 * @author Lasya Yakkala IQY403
 * CS 3443 - 002
 * 
 * This class will control all elements on the Main.fxml page
 */

package application.controller;

//imports all the necessary packages
import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;

//MainController uses EventHandler
public class MainController implements EventHandler<ActionEvent>{
	
	//handle method is invoked when the user interacts with any button on the Main view
	@Override
	public void handle(ActionEvent event) {
		
		//generic button variable that will later be referenced using its specific ID
		Button b = (Button) event.getSource();
		
		//If the user selects "treat", will set the location and load the scene to the Trick view
		if(b.getId() != null && b.getId().equals("trick")) {
			
			try {

				FXMLLoader loader = new FXMLLoader();
				
				//sets the location of the view to Trick
				loader.setLocation(getClass().getResource("../view/Trick.fxml"));
				
				Scene scene = new Scene(loader.load());
				
				Main.stage.setScene(scene);
				
				Main.stage.show();
				
			
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		//If the user selects "treat", will set the location and load the scene to the Treat view
		if(b.getId() != null && b.getId().equals("treat")) {
			
			try {

				FXMLLoader loader = new FXMLLoader();
				
				//sets the location of the view to Treat
				loader.setLocation(getClass().getResource("../view/Treat.fxml"));

				Scene scene = new Scene(loader.load());

				Main.stage.setScene(scene);
				Main.stage.show();
				
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
