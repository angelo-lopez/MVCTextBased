package com.romel;

import java.io.Serializable;

public class Member implements Serializable{
	private int memberNo;
	private String memberName;
	private String memberAddress;
	private String telNo;
	private int age;
	
	///Constructor/s
	public Member(){
		memberNo = 0;
		memberName = "";
		memberAddress = "";
		telNo = "";
		age = 0;
	}
	
	public Member(int memberNo, String n, String a, String t, int age){
		this.memberNo = memberNo;
		this.memberName = n;
		this.memberAddress = a;
		this.telNo = t;
		this.age = age;
	}
	
	///Getters and Setters
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}//end class
