package com.romel;

import java.util.Scanner;

public class UserInterface {
	Scanner input = new Scanner(System.in);
	
	public void displayMenu(){
		System.out.println("\n-------------------------------------\nMember Application\n"
				+ "-------------------------------------\n");
		System.out.println("Menu Options:\n");
		System.out.println("[1] Add New Member\n[2] Display All Members\n[3] Display a Member"
				+ "\n[4] Change a Member\n[5] Delete a Member\n[Q/q] Save and Quit\n");
		System.out.println("Please enter a value from 1-5 or Q/q to Save and Quit.");
		System.out.println("-->");
	}//end displayMenu
	
	public char getOption(){
	    while (!input.hasNext("[12345qQ]")) {
	        System.out.println("That's not a valid option!!! Please try again.");
	        input.next();
	    }
	    char opt = input.next().toUpperCase().charAt(0);

		return opt;
	}//end getOption	
	
}//end class
