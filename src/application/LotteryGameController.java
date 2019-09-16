package application;

import java.util.ArrayList;
import java.util.Collections;

public class LotteryGameController {
	private GameMain mainClass;
	private ArrayList<Integer> lotteryNumbers;
	private ArrayList<Integer> numberRange;
	
	public LotteryGameController(GameMain main) {
		this.mainClass = main;
		lotteryNumbers = new ArrayList<Integer>();
		numberRange = new ArrayList<Integer>();
		genList();
	}
	
	/*
	 * How this function works is that it makes an arraylist of integers and puts the numbers from 1 - 50 inside it, then collections
	 * shuffles the list and then the first 6 is put inside another list
	 */
	
	public void genList(){
        for (int i = 1; i <= 50; i++) {
        	numberRange.add(new Integer(i));
        }
        shuffle();
	}
	
	public void shuffle() {
		Collections.shuffle(numberRange);
        for (int i = 0; i < 5; i++) {
        	lotteryNumbers.add(numberRange.get(i));
        }
	}
	
	public void revealNumbers() {
		for(int i = 0; i < lotteryNumbers.size(); i++) {
			System.out.println("Number " + i + " is " + lotteryNumbers.get(i));
		}
	}
	
	public String checkNumbers(ArrayList<Integer> userNumbers) {
		String message;
		int counter = 0;
		
		for(int i = 0; i < userNumbers.size(); i++) {
			for(int j = 0; j < lotteryNumbers.size(); j++) {
				// Needed to use .equals here because it wouldn't work with ==.
				if(userNumbers.get(i).equals(lotteryNumbers.get(i))) {
					counter++;
				}
			}
		}
		
		if(counter < 4) {
			message = "You got " + counter + " numbers right and didn't win anything";
			System.out.println(message);
		}
		
		else if(counter == 4) {
			message = "You got " + counter + " numbers right and got the second prize!";
			System.out.println(message);
			mainClass.set_score(4);
		}
		
		else {
			message = "Congratualitions you won the big prize!";
			System.out.println(message);
			mainClass.set_score(5);
		}
		
		System.out.println("The winning numbers were: ");
		for(int i = 0; i < lotteryNumbers.size(); i++) {
			System.out.println("Number " + i + ": " + lotteryNumbers.get(i));
		}
		
		// Clear the lists
		lotteryNumbers.clear();
		return message;
	}
}
