package application;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.awt.Color;

public class LotteryGameView extends Tab {
	// Variables
	private LotteryGameController lotteryControl;
	private TextField message;
	private boolean reset; 
   
   public LotteryGameView(GameMain main) {
	   // create some variables
	   lotteryControl = new LotteryGameController(main);
	   message = new TextField();
	   message.setEditable(false);
	   message.setPrefSize(300, 20);
	   reset = false;
	  
	  setText("Lottery Game");
	  BorderPane border = new BorderPane();
      
	  // Buttons
      Button b1 = new Button ("Submit");
      Button b2 = new Button ("Reset");
      Button b3 = new Button ("Help");
      
      // List that will contain the picked numbers
      ArrayList<Integer> pickedNumbers = new ArrayList<Integer>();
      
      // Backgroun colour
      border.setStyle("-fx-background-color: green");
      
      // Create the drop down box
      ComboBox dropBox = new ComboBox();
      for(int i = 1; i <= 50; i++) {
    	  dropBox.getItems().addAll(i);
      }
      
      // Methods for the buttons
      b1.setOnAction(new EventHandler<ActionEvent>() {
    	  public void handle(ActionEvent e){
    		  pickedNumbers.add((Integer) dropBox.getValue());
    		  dropBox.getItems().remove(dropBox.getValue());
    		  if(pickedNumbers.size() == 5) {
    			  message.setText((lotteryControl.checkNumbers(pickedNumbers)));
    			  b1.setDisable(true);
    			  reset = true;
    		  }
    	  	}
    	  });
      
      b2.setOnAction(e -> {
    	  if(reset) {
	    	  lotteryControl.shuffle(); 
	    	  dropBox.getItems().addAll(pickedNumbers);
	    	  pickedNumbers.clear();
	    	  dropBox.getItems().sort(null);
	    	  message.clear();
	    	  b1.setDisable(false);
	    	  reset = false;
    	  }
      });
      
      b3.setOnAction(e->{lotteryControl.revealNumbers();});
      
      	//HBOX STUFF
      	HBox hbox = new HBox();
      	hbox.setPadding(new Insets(15, 12, 15, 12));
      	hbox.setSpacing(10);
      	// Background colour of hbox
      	hbox.setStyle("-fx-background-color: #336699;");
      	hbox.getChildren().addAll(dropBox, message, b1, b2);
      	
      	StackPane stack = new StackPane();
      	stack.getChildren().addAll(b3);
      	// Puts it over to the right
      	stack.setAlignment(Pos.CENTER_RIGHT);
        StackPane.setMargin(b2, new Insets(0, 10, 0, 0));
        hbox.getChildren().add(stack);
        HBox.setHgrow(stack, Priority.ALWAYS);
      
        //VBOX
        Label l1 = new Label ("Lottery Game: \n \t A random set of 5 numbers from 1-50 is picked and you have to guess those 5."
          		+ "\n \t If you get 4 numbers correct then you get 4 points and if you get all 5 you get 5 points.");
        VBox vbox = new VBox();
        border.setLeft(vbox);
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        //Background colour
        vbox.setStyle("-fx-background-color: orange;");
        //Font colour
        l1.setStyle("-fx-text-fill: black");
        vbox.getChildren().add(l1);
        
        //Place the hbox
        border.setTop(hbox);
        setContent(border);
   }
   
}
