// Tom Oppenheim 11/6/2016
// Programming Assignment 6
import java.util.HashSet;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class commonNameCounter {

	public static void main(String[] args) {
	Scanner keyboard = null;
	HashSet allNames = new HashSet();
	ArrayList mutualNames = new ArrayList();
	int count = 0;
	int totalBoys = 0;
	int totalGirls = 0;
	
	// Load girlnames.txt
	try{
		keyboard = new Scanner(new File("girlnames.txt"));
	}
	catch(FileNotFoundException e){
		System.out.println("File not found.");
	}	
	// Read each line, storing each name as a String and the amount of responses as an int
	while(keyboard.hasNext()){
		String name = keyboard.next();
		int numberAfter = keyboard.nextInt();
		allNames.add(name);
		totalGirls = totalGirls + numberAfter;
	}
	
	//Load boysnames.txt
	try{
		keyboard = new Scanner(new File("boynames.txt"));
	}
	catch(FileNotFoundException e)
	{
		System.out.println("File not found.");
	}
	
	// Read each line, storing each name as a String and the amount of responses as an int
	while(keyboard.hasNext()){
		String name = keyboard.next();
		int numberAfter = keyboard.nextInt();
		totalBoys = totalBoys + numberAfter;
		if(!allNames.add(name))
		{
			mutualNames.add(name);
			count++;
		}
	}
	
	// Print results
	System.out.println("There are " + count + " mutual names for both girls and boys. ");
	System.out.println("The shared names are: ");
	System.out.println(mutualNames);
	System.out.println("In addition to this, the total number of boys recorded in this census was " + totalBoys);
	System.out.println("And the total number of girls recorded in this census was " + totalGirls);
	}

}
