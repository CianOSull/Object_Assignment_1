package application;

import javafx.scene.control.TextField;

public class GuessGameController {
	
	// Variables
	private int ranNumber;
	private GameMain mainClass;
	private boolean result;
	
	public GuessGameController(GameMain main) {
		reset();
		this.mainClass = main;
	}
	
	// This method will generate a number between 1 and 50
	private int genNo() {
		return (int)(Math.random()*50);
	}
	
	public void reset() {
		ranNumber = genNo();
		System.out.println("Number is: " + ranNumber);
		result = false;
	}
	
	// Check to make sure the input is a number
	private boolean isInt(TextField input) {
		try {
			Integer.parseInt(input.getText());
			return true;
		}
		
		catch(NumberFormatException e){
			System.out.println("You didnt input a number!");
		}
		return false;
	}
	
	public boolean checkWin() {
		return result;
	}
	
	public String guessGame(TextField input) {
		String message;
		if(isInt(input)) {
			// Conver the input if it is a number to an int
			int n = Integer.parseInt(input.getText());
			
			if(n == this.ranNumber) {
				message = "You are correct!";
				System.out.println(message);
				mainClass.set_score(2);
				result = true;
			}
			
			else if((this.ranNumber - 5) <= n && n <= (this.ranNumber + 5) ) {
				message = "You are warm! Try again";
				System.out.println(message);
			}
			
			else if((this.ranNumber - 10) <= n && n <= (this.ranNumber + 10)) {
				message = "You are cold! Try again";
				System.out.println(message);
			}
			
			else {
				message = "You are frozen! Try again";
				System.out.println(message);
			}
		}
		
		else {
			message = "Try again";
			System.out.println(message);
		}
		return message;
	}					
}
