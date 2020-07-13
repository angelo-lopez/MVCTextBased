package com.romel;

import java.io.IOException;
import java.util.ListIterator;
import java.util.Scanner;

public class Application {
	private static Membership theMembership = new Membership();
	private Scanner input;
	private UserInterface ui;
	private char option;
	
	public void run() throws IOException{
		ui = new UserInterface();
		theMembership.readMembers("membership.fle");
		do{
			ui.displayMenu();
			option = ui.getOption();
			
			switch (option){
				case '1':
					addNewMember();
					break;
				case '2':
					displayMembers();
					break;
				case '3':
					displayMemberDetails();
					break;
				case '4':
					changeMemberDetails();
					break;
				case '5':
					deleteMember();
					break;
			}//end switch
		}while(option != 'Q');
		
		theMembership.writeMembersToFile("membership.fle");
		System.out.println("Goodbye!!!");
		
	}//end run

	public void displayMembers()throws IOException{
		Member tempMember;
		int memberCount = 0;
		ListIterator <Member> memberList = theMembership.getMembers().listIterator();
		System.out.println("\nMember List:");
		System.out.println("-----------------------------------------------------------------------------------------------"); 
		System.out.printf("ID         NAME                     "
				+ " ADDRESS                   PHONE NUMBER              AGE");
		System.out.println("\n-----------------------------------------------------------------------------------------------");
		while(memberList.hasNext()){
			memberCount++;
			tempMember = memberList.next();
			System.out.printf("\n%-10d %-25s %-25s %-25s %-3d", tempMember.getMemberNo(), tempMember.getMemberName(),
					tempMember.getMemberAddress(), tempMember.getTelNo(), tempMember.getAge());
		}//end while
		if(memberCount > 0){
			System.out.println("\n\nTotal number of members: " + memberCount);
		}
		else{
			System.out.println("\nThere are no members to display!!!");
		}//end if/else
		
		System.out.println("\nPress enter to continue...");
		System.in.read();
		
	}//end displayMembers
	
	public void addNewMember()throws IOException{
		input = new Scanner(System.in);
		boolean isValidInt = false;
		Member aMember;
		String name ="", address = "", telNo = "", age = "";
		
		System.out.println("-----------------------------\nAdd a new member\n-----------------------------");
		System.out.println("Please enter the name:");
		name = input.nextLine();
		System.out.println("Please enter the address:");
		address = input.nextLine();
		System.out.println("Please enter the phone number:");
		telNo = input.nextLine();
		System.out.println("Please enter the age:");
				
		while(isValidInt == false){
			age = input.next();
			try{
				Integer.parseInt(age);
				isValidInt = true;
			}
			catch(NumberFormatException ex){
				isValidInt = false;
				System.out.println("Only numbers are allowed. Please try again.");
			}//end try/catch
		}//end while
		
		aMember = new Member(theMembership.getNextMemid(), name, address, telNo, Integer.parseInt(age));
		theMembership.addMember(aMember);
		System.out.println("\nAdded a new member. Press enter to continue...");
		System.in.read();
		
	}//end addNewMember
	
	public void displayMemberDetails() throws IOException{
		Member aMember;
		input = new Scanner(System.in);
		String memNo = "";
		System.out.println("Please enter the member number:");
		while(!input.hasNextInt()){
			System.out.println("Sorry, invalid input. Only numbers are allowed. Please try again.");
			input.nextLine();
		}//end while
		memNo = input.nextLine();
		aMember = theMembership.findMember(Integer.parseInt(memNo));
		if(aMember != null){
			System.out.println("----------------------------------\nMember Details:\n----------------------------------");
			System.out.println("Member Number:\t\t" + aMember.getMemberNo());
			System.out.println("Member Name:\t\t" + aMember.getMemberName());
			System.out.println("Member Address:\t\t" + aMember.getMemberAddress());
			System.out.println("Member Phone Number:\t" + aMember.getTelNo());
			System.out.println("Member Age:\t\t" + aMember.getAge());
		}
		else{
			System.out.println("Sorry, the member number does not exist.");
		}//end if
		System.out.println("\nPress enter to continue...");
		System.in.read();
		
	}//displayMemberDetails
	
	public void changeMemberDetails() throws IOException{
		Member aMember;
		boolean isValidInt = false;
		input = new Scanner(System.in);
		String name ="", address = "", telNo = "", age = "";
		String memNo = "";
		System.out.println("Please enter the member number:");
		while(!input.hasNextInt()){
			System.out.println("Sorry, invalid input. Only numbers are allowed. Please try again.");
			input.nextLine();
		}//end while
		memNo = input.nextLine();
		aMember = theMembership.findMember(Integer.parseInt(memNo));
		if(aMember != null){
			System.out.println("----------------------------------\nMember Details:\n----------------------------------");
			System.out.println("Member Number:\t\t" + aMember.getMemberNo());
			System.out.println("Member Name:\t\t" + aMember.getMemberName());
			System.out.println("Member Address:\t\t" + aMember.getMemberAddress());
			System.out.println("Member Phone Number:\t" + aMember.getTelNo());
			System.out.println("Member Age:\t\t" + aMember.getAge());
			System.out.println("----------------------------------\nMember New Details:\n----------------------------------");
			System.out.println("Please enter the new name:");
			name = input.nextLine();
			System.out.println("Please enter the new address:");
			address = input.nextLine();
			System.out.println("Please enter the new phone number:");
			telNo = input.nextLine();
			System.out.println("Please enter the new age:");
			while(isValidInt == false){
				age = input.next();
				try{
					Integer.parseInt(age);
					isValidInt = true;
				}
				catch(NumberFormatException ex){
					isValidInt = false;
					System.out.println("Only numbers are allowed. Please try again.");
				}//end try/catch
			}//end while
			aMember.setMemberName(name);
			aMember.setMemberAddress(address);
			aMember.setTelNo(telNo);
			aMember.setAge(Integer.parseInt(age));
			System.out.println("\nChange successfull. Press enter to continue...");
			System.in.read();
		}
		else{
			System.out.println("Sorry, the member number does not exist. Press enter to continue...");
			System.in.read();
		}//end if
		
	}//changeMemberDetails
	
	public void deleteMember()throws IOException{
		ListIterator <Member> memberList = theMembership.getMembers().listIterator();
		Member aMember;
		input = new Scanner(System.in);
		String memNo = "";
		System.out.println("Please enter the member number:");
		while(!input.hasNextInt()){
			System.out.println("Sorry, invalid input. Only numbers are allowed. Please try again.");
			input.nextLine();
		}//end while
		memNo = input.nextLine();
		aMember = theMembership.findMember(Integer.parseInt(memNo));
		if(aMember != null){
			while(memberList.hasNext()){
				if(memberList.next().getMemberNo() == Integer.parseInt(memNo)){
					memberList.remove();
				}
			}//end while
			
			System.out.println("\nDelete successfull. Press enter to continue...");
			System.in.read();
		}
		else{
			System.out.println("Sorry, the member number does not exist. Press enter to continue...");
			System.in.read();
		}//end if
	}//end deleteMember
	
	public void writeFiles(){
		theMembership.writeMembersToFile("membership.fle");
		
	}//end writeFiles
	
	public void printLines(){
		
	}//end printLines
	
}//end class

