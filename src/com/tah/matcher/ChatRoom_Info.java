package com.tah.matcher;

public class ChatRoom_Info {
	private int CR_Status;
	private String CR_URL;
	public ChatRoom_Info(){
		CR_Status = 0;
		CR_URL = "";
	}
	/*
	public ChatRoom_Info(int In_CR_Status, String In_CR_URL){
		CR_Status = IN_CR_Status;
		CR_URL = IN_CR_URL;
	}
	*/
	public void setCR_Status(int cR_Status) {
		CR_Status = cR_Status;
	}
	public int getCR_Status() {
		return CR_Status;
	}
	public void setCR_URL(String cR_URL) {
		CR_URL = cR_URL;
	}
	public String getCR_URL() {
		return CR_URL;
	}
	
	
}
