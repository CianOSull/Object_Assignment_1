package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuessGameView extends Tab {
	
	// Variables
	private GuessGameController guessControl;
	private TextField message;
	private boolean reset;
	private int attempt = 0;
	private int counter = 1;
		
   public GuessGameView(GameMain main) {
	  guessControl = new GuessGameController(main);
	  
	  // Create the text field
	  message = new TextField();
	  message.setPrefSize(200, 20);
	  TextField nameInput = new TextField("");
	  message.setEditable(false);
	  
	  setText("Guess Game");
	  GridPane  gp = new GridPane();
      
	  // Buttons 
	  Button b1 = new Button ("Click me to enter the guess!");
	  Button b2 = new Button ("Reset");
	  Button b3 = new Button ("Quit");
      
	  // Label
	  Label l1 = new Label("Put your guess in above");
	  Label l2 = new Label("Output message box");
      
	  // Set up the Buttons
      b1.setOnAction(e -> {
    	  message.setText((guessControl.guessGame(nameInput))); 
    	  if(guessControl.checkWin()) { 
    		  b1.setDisable(true);
    		  reset = true;
    		  counter++;
    		  if(counter == 5) {
    			  main.set_score(1);
    			  counter = 0;
    		  }
    	  }
    	  else if(attempt == 4) {
    		  message.setText("Your 4 attempts are up, hit reset to try again.");
    		  b1.setDisable(true);
    		  reset = true;
    	  }
    	  else {
    		  attempt++;
    	  }
      });
      
      b2.setOnAction(e -> {
    	  if(reset) {
    		  attempt = 0;
    		  guessControl.reset();
	    	  message.clear();
	    	  b1.setDisable(false);
	    	  reset = false;
    	  }
      });
      
      b3.setOnAction(e->{Stage stage = (Stage) b3.getScene().getWindow();stage.close();});
      
      // Set the background
      gp.setStyle("-fx-background-color: yellow");
      
      //Add all the elemetns
      gp.add(nameInput, 1, 1);
      gp.add(message,20,1);
      gp.add(l1,1,20);
      gp.add(l2,20,20); 
      gp.add (b1,1, 50);
      gp.add(b2, 20, 50);
      gp.add(b3, 30, 50);
      setContent(gp);
   }
}
