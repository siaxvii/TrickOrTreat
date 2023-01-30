/**
 * 
 * @author Lasya Yakkala IQY403
 * CS 3443 - 002
 * 
 * This class will return a Trivia object to the Trick Controller java file
 * 
 */

package application.model;

//Imports all the necessary packages
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class Trivia {
	
	//Initializes all the String variables associated with one Trivia object
	public String question;
	public String answer;
	public String option1;
	public String option2;
	public String option3;

	
	public Trivia(String newQuestion, String newOption1, String newOption2, String newOption3, String newAnswer) {
		this.question = newQuestion;
		this.option1 = newOption1;
		this.option2 = newOption2;
		this.option3 = newOption3;
		this.answer = newAnswer;
	}
	
	public static Trivia loadTrivia(String fileName) {
		
		//Generates a random number to be used to randomize the trivia question displayed to the user in Trick view
		Random rand = new Random();
		int num = rand.nextInt(10) + 1;
		
		int numRows = 0;
		
		Trivia trivia = null;   //initializes Trivia object, will be returned at the end of function
		try {
			
			Scanner scnr = new Scanner(new File(fileName));
			if(scnr != null) {
				while(scnr.hasNextLine()) {
					String line = scnr.nextLine();
					String[] data = line.split(","); //splits each line where there is a comma, into separate data values allotted into different spots in the data array
					
					//numRows is incremented to calculate number of rows in CSV
					numRows++;
					
					//keeps track of commas in CSV file
					int numCommas = 0;
					
					//If the row number is the same as the randomly generated number, read in info to Trivia object
					if(numRows == num) {
						trivia = new Trivia(data[0], data[1], data[2], data[3], data[4]);
						
						//below code block ensures that the answer will be able to be displayed with commas
						for(int i = 0; i < line.length(); i++) {
							if(line.charAt(i) == ',') {
								numCommas++;
							}
							if(numCommas > 4) {
								trivia.setAnswer(data[4].concat(line.substring(i)));
								break;
							}
						}
					
					} 
					
					
				}
				
			}
		}
		
		//handles any I/O exceptions
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return trivia;
		
	}

	//Getters and setters for all the String variables in the Trivia object
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}
	
}
