package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;

public class PrizeSelectionController {
	private String fileName = "src\\prizeList.txt";
	private File file = new File(fileName);
	private HashMap<String, String> hashMap;
	private ArrayList<Integer> weightList;
	
	public PrizeSelectionController() {
		hashMap = new HashMap<String, String>();
		weightList = new ArrayList<Integer>();
		try {
			getPrize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String score(int n) {
		String message;
		if(n == 4) {
			System.out.print("Your options are: \n 1: " + hashMap.get("Prize1") + " \n 2: " + hashMap.get("Prize3") 
			+ " \n 3:  " + hashMap.get("Prize4"));

			message = "Your options are 1: " + hashMap.get("Prize1") + " 2: " + hashMap.get("Prize3") 
			+ " 3:  " + hashMap.get("Prize4");
		}
		else if(5 <= n) {
			System.out.println("Your options are: \n 1: " + hashMap.get("Prize1") + " \n 2: " + hashMap.get("Prize3") 
			+ " \n 3:  " + hashMap.get("Prize4") + " \n 4: " + hashMap.get("Prize2"));
			message = "Your options are 1: " + hashMap.get("Prize1") + " 2: " + hashMap.get("Prize3") 
			+ " 3:  " + hashMap.get("Prize4") + " 4: " + hashMap.get("Prize2");
		}
		else {
			message = "You don't have enough points yet for prizes!";
		}
		return message;
	}
	
	public void getPrize() throws IOException {
		
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String line = br.readLine();

	        while(line != null){
	            String[] lineSplit = line.split(",");
	            weightList.add(Integer.parseInt(lineSplit[1]));
	            hashMap.put(lineSplit[2],lineSplit[0]);
	            line = br.readLine();
	        }
	        
	        //close resources
	        br.close();
	        fr.close();
		} 
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
