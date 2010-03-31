package com.tah.matcher;

public class Invitee {
	private String InviteeName;
	private String InviteeIMAcc;
	private String InviteeComm;
	private int InviteeAge;
	private char InviteeGendar;
	public Invitee() {
		InviteeName = "";
		InviteeIMAcc = "";
		InviteeComm = "";
		InviteeAge = 0;
//		InviteeGendar = '';
		
	}
	
	public Invitee(String Name, String Acc) {
		InviteeName = Name;
		InviteeIMAcc = Acc;
//		InviteeComm = Comm;
//		InviteeAge = Age;
//		InviteeGendar = '';
		
		
	}

	public void setInviteeName(String inviteeName) {
		InviteeName = inviteeName;
	}

	public String getInviteeName() {
		return InviteeName;
	}

	public void setInviteeIMAcc(String inviteeIMAcc) {
		InviteeIMAcc = inviteeIMAcc;
	}

	public String getInviteeIMAcc() {
		return InviteeIMAcc;
	}

	public void setInviteeComm(String inviteeComm) {
		InviteeComm = inviteeComm;
	}

	public String getInviteeComm() {
		return InviteeComm;
	}

	public void setInviteeAge(int inviteeAge) {
		InviteeAge = inviteeAge;
	}

	public int getInviteeAge() {
		return InviteeAge;
	}

	public void setInviteeGendar(char inviteeGendar) {
		InviteeGendar = inviteeGendar;
	}

	public char getInviteeGendar() {
		return InviteeGendar;
	}

}
