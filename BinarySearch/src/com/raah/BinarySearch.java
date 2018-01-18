package com.raah;

import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearch {
	
	static String MSG_1 = "Enter the Array Value in a numerical order";
	static String MSG_2 = "Please enter your key to search: ";
	static String MSG_3 = "Match Found at index position: ";
	static String MSG_4 = "Match is not found";

	public static void main(String[] args) {
		ArrayList<Integer> myList = getAnArray(5, MSG_1);
		int key = getUserInput(MSG_2);
		int searchResult = searchAndReturn(key, myList);
		displayResult(searchResult);					
	}//end of method main()
	
	/**
	 * Method to display the result on the screen
	 * @param searchResult - result of the search to print the correct message
	 */
	public static void displayResult(int searchResult) {
		if(searchResult != -1) {
			System.out.println(MSG_3+searchResult);
		} else {
			System.out.println(MSG_4);
		}
	}//end of method displayResult()
	
	/**
	 * method to take input from user in the screen 
	 * @param arrSize - length of the array required
	 * @param msg - The message to prompt user to enter value for the array
	 * @return - returns an ArrayList<Integer>
	 */
	public static ArrayList<Integer> getAnArray(int arrSize, String msg) {
		ArrayList<Integer> mySortedList = new ArrayList<Integer>();
		System.out.println(msg);		
		for(int i=0; i < arrSize; i++) {
			int userInput = getUserInput(null);
			if(userInput > 0) {
				mySortedList.add(userInput);
			}
		}		
		return mySortedList;
	}//end of method getAnArray()
	
	/**
	 * method for binary search
	 * @param key - the value which to do the search for
	 * @param array - the ordered list in which search in
	 * @return - index position of the match from the array list
	 */
	public static int searchAndReturn(int key, ArrayList<Integer> array ) {
		int begining, middle, end;
		begining = 0;
		middle = 0;
		end = array.size()-1;
		for(int i=0; i < array.size(); i++) {
			middle = (begining+end)/2;
			if(array.get(middle).compareTo(key) == 0) {
				return middle; 
			} else if(array.get(middle) <= key) {
				begining = middle+1;
			} else {
				end = middle-1;
			}
		}		
		return -1;
	}//end of method searchAndReturn
	
	/**
	 * Method to get input key from the user
	 * @param msgRequired - If a message is required to be displayed 
	 * @return - returns the integer value that has been keyed in by user
	 */
	public static int getUserInput(String msgRequired) {
		if(msgRequired != null) {
			System.out.print(msgRequired);
		}
		Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()) {
			return sc.nextInt();			
		} else {
			return 0;
		}		
	}//end of method getUserInput

}//end of main class BinarySearch
