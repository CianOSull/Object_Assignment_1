package application;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.FlowPane;

public class IntroPanel extends Tab
{
   public IntroPanel() {
	  setText("Intro Panel");
	  FlowPane p = new FlowPane();
	  
	  // Give basic information for the panel
      Label l1 = new Label ("Information for playing games:");
      Label l2 = new Label ("\n1. Guess Game: A random number from 1-50 is generated and you have to guess it and you only have 4 chances."
      		+ "\n Terminalogy: \n \t \"You are forzen\" = your guess was more than "
        	+ "10 numbers away so guess again \n \t \"You are cold!\" = You are 10 digits + or - away form the number "
        	+ "\n \t \"You are warm\" = you are 5 + or - digits away from the number \n \t \"Correct\" =  You won!"
        	+ "\n \t Everytime you win you get two points.");
      Label l3 = new Label ("\n2. Lottery Game: A random set of 5 numbers from 1-50 is picked and you have to guess those 5."
      		+ "\n \t If you get 4 numbers correct then you get 4 points and if you get all 5 you get 5 points.");
      Label l4 = new Label("\n3. Prizes tab: \n \t Here you can use the points you got from completing games to get prizes.");

      p.getChildren().add(l1);
      p.getChildren().add(l2);
      p.getChildren().add(l3);
      p.getChildren().add(l4);
      setContent(p);
   }
}

