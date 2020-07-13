package com.romel;

import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Membership {
	private int nextMemId;
	private ArrayList <Member>theMembers = new ArrayList <Member>();
	
	public int getNextMemid(){		
		return nextMemId++;
	}//add getNextMemid
	
	public void addMember(Member aM){
		theMembers.add(aM);
	}//end addMember
	
	public Member findMember(int anID){
		boolean found = false;
		int memberPos = -1;
		ListIterator <Member> lt = theMembers.listIterator();
		
		while(lt.hasNext()&&!found){ //loop until found or at end of ArrayList
			memberPos ++;
			if(lt.next().getMemberNo() ==anID){
				found =true;
			}
		}//end while
		if(found){
			return (Member)theMembers.get(memberPos);
		}
		else{
			return null;
		}
	}//findMember
	
	public void readMembers(String f){
        nextMemId = 0;
        //build the Member list and check that file exists
        try {
               System.out.println("Creating File/Object input stream1...");
               FileInputStream fileIn = new FileInputStream(f);
               ObjectInputStream inMembers = new ObjectInputStream(fileIn);
               System.out.println("Loading Arraylist Object...");
               theMembers = (ArrayList)inMembers.readObject();
	         System.out.println("Closing  input stream...\n");
               inMembers.close();
               fileIn.close();
               nextMemId = theMembers.get(theMembers.size()-1).getMemberNo() + 1; //if a file exists work out the next available id no
        }catch(ArrayIndexOutOfBoundsException e){
        	nextMemId = 0;
        }catch(FileNotFoundException e) {//if no file found set id to 0
            	nextMemId = 0;
        }catch (ClassNotFoundException e) {
            	e.printStackTrace();
        }catch (IOException e) {
            	e.printStackTrace();
        }


	}//end readMembers
	
	public int getMemberCount(){
		return theMembers.size();
	}//getMemberCount
	
	public ArrayList getMembers(){
		return theMembers;
	}//end getMembers
	
	public void writeMembersToFile(String f){
		try{
			  System.out.println("Creating File/Object output stream...");
			  FileOutputStream fileOut = new FileOutputStream(f);
			  ObjectOutputStream outMembers = new ObjectOutputStream(fileOut);
			  System.out.println("Writing Member Objects...");
			  outMembers.writeObject(theMembers);
			  System.out.println("Closing all output streams...\n");
			  outMembers.close();
			  fileOut.close();
			 } 
			catch(FileNotFoundException e) {
			   e.printStackTrace();
			 } 
			catch (IOException e) {
			   e.printStackTrace();
			 }

	}//end writeMembersToFile
	
}//end class
