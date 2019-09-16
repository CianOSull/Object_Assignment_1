package application;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;

public class PrizeSelectionView extends Tab {
	private GameMain mainClass;
	private PrizeSelectionController prizeControl;
   
   public PrizeSelectionView(GameMain main)
   {
     mainClass = main;
     prizeControl = new PrizeSelectionController();
     
     setText("Prize Selection");
	  VBox  vb = new VBox();
	  // Set Background
	  vb.setStyle("-fx-background-color: #336699;");
	  
	  // Buttons
      Button b1 = new Button ("Prize 1");
      Button b2 = new Button ("Prize 2");
      Button b3 = new Button ("Prize 3");
      Button b4 = new Button ("Prize 4");
      Button b5 = new Button ("Check Score");
      
      //TextField
      TextField prizeOutput = new TextField("");
      prizeOutput.setEditable(false);
      TextField scoreSize = new TextField(Integer.toString(mainClass.get_score()));
      scoreSize.setPrefSize(100, 20);
      scoreSize.setEditable(false);
      
      // Button methods
      b5.setOnAction(new EventHandler<ActionEvent>() {
    	  public void handle(ActionEvent e){
    		  int score = mainClass.get_score();
		   	  if(score < 4) {
		   		   System.out.println("Sorry but you don't have enough points to get a prize! Try more games!");
		   		   prizeOutput.setText("Sorry but you don't have enough points to get a prize! Try more games!");
		   		   scoreSize.setText(Integer.toString(mainClass.get_score()));
		   	   }
		   	   else if(score == 4){
		   		   buttonsVis(b1,b2,b3,b4,true,0);
		   		   prizeOutput.setText(prizeControl.score(score));
		   		   scoreSize.setText(Integer.toString(mainClass.get_score()));
		   		   
		   	  }
		   	  else {
		   		  buttonsVis(b1,b2,b3,b4,true,2);
		   		  prizeOutput.setText(prizeControl.score(score));
		   		  scoreSize.setText(Integer.toString(mainClass.get_score()));
		   	  }
		  }
      });
      
      b1.setOnAction(e -> {showConfirm(b1,b2,b3,b4,4);});
      b2.setOnAction(e -> {showConfirm(b1,b2,b3,b4,5);});
      b3.setOnAction(e -> {showConfirm(b1,b2,b3,b4,4);});
      b4.setOnAction(e -> {showConfirm(b1,b2,b3,b4,4);});
      
      // Hide the buttons
      buttonsVis(b1,b2,b3,b4,false,2);
      
      vb.getChildren().add (b1);  
      vb.getChildren().add (b2);
      vb.getChildren().add (b3);
      vb.getChildren().add (b4);
      vb.getChildren().add (b5);
      vb.getChildren().add(prizeOutput);
      vb.getChildren().add(scoreSize);
      setContent(vb);
   }
   
   // Just to confirm if you want the prize
   public void showConfirm(Button b1, Button b2, Button b3, Button b4, int number) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText("This will reduce your points!");
		alert.setContentText("Are sure you want that prize.");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			buttonPress(number);
			if(number < 4) {
				buttonsVis(b1,b2,b3,b4,false,2);
			}
			else if(number < 5){
				buttonsVis(b1,b2,b3,b4,false,2);
			}
			else {
				System.out.println("You can still pick more prizes");
			}
		} 
		else {
		    System.out.println("No changes have been made.");
		}
	}
   
   public void alertBox() {
	   Alert alert = new Alert(AlertType.INFORMATION);
	   alert.setTitle("Information Dialog");
	   alert.setHeaderText("You got a prize!");
	   alert.setContentText("Your points have been deducted");

	   alert.showAndWait();
   }
   
   public void buttonPress(int num) {
	   mainClass.reduce_score(num);
   }
   
   // Hide the buttons
   public void buttonsVis(Button b1, Button b2, Button b3, Button b4, Boolean visible, int s) {
	   if(s == 0) {
		   b1.setVisible(visible); 
		   b3.setVisible(visible);
		   b4.setVisible(visible);
	   }
	   else if(s == 1) {
		   b2.setVisible(visible);
	   }
	   else {
		   b1.setVisible(visible); 
		   b2.setVisible(visible);
		   b3.setVisible(visible);
		   b4.setVisible(visible);
	   }
   }
}

