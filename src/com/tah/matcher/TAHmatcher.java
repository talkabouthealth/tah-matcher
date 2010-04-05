package com.tah.matcher;


import java.util.ArrayList;
import java.util.List;

import com.tah.im.IMInterface;

public class TAHmatcher {

	/**
	 * @param args
	 * @throws Exception 
	 */
	
	private int UID;
	private int Conv_ID;
	private String Comment;
	private ChatRoom_Req CRR;
	private List<Invitee> Invitees;
	private int MAX_NUM;
	
	public TAHmatcher(int uid, int conv_id, String comment){
		UID = uid;
		Conv_ID = conv_id;
		Comment = comment;
		CRR = new ChatRoom_Req(UID, Conv_ID, Comment);
		Invitees = new ArrayList<Invitee>();
		MAX_NUM = 20;
	}
	public void matcher() throws Exception {
		CRR.setCR_Info();
		System.out.println("The chat room stauts is " + CRR.getCR_Info().getCR_Status());
		System.out.println("The chat room URL is " + CRR.getCR_Info().getCR_URL());
		
		
		// if chat room created successfully, connecting to database
		if (CRR.getCR_Info().getCR_Status() != 0){
			readUserList();
		}
	}
	public List<Invitee> getUserList(){
		return Invitees;
		
	}
	private void readUserList() throws Exception{
		System.out.println("Chat Room Created Successfully \nNow, connecting to Database...");
		String db_host = "localhost";
		String db_name = "talkmidb";
		String db_user = "root";
		String db_password = "applepie";
//		String post_author = "testIM5566@gmail.com";
		String sql = "SELECT * FROM talkers WHERE uid <> " + UID ;
		String [][] userData;
		
		// establish connection to database
		SQL_CON SQL_Conn = new SQL_CON(db_host, db_name, db_user, db_password, sql);
		// create a dynamic arraylist to store users info
		
		Invitee PPL;
		
		if(SQL_Conn.driverTest()){
			try {
//				Invitees = SQL_Conn.exeQuery(SQL_Conn.getCon(), sql);
				try{
			
						while(SQL_Conn.getRS().next() && (Invitees.size() < 20)){
							PPL = new Invitee(SQL_Conn.getRS().getObject("uname").toString(), SQL_Conn.getRS().getObject("email").toString());
							Invitees.add(PPL);
							System.out.println(Invitees.size());
						}


				}catch(Exception e){
					System.err.println("Error excuting sql statement!");
					throw(e);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("There are " + Invitees.size() + " users");
		for (int i = 0; i < Invitees.size(); i++){
			System.out.println(Invitees.get(i).getInviteeName() + " has IM account of " + Invitees.get(i).getInviteeIMAcc());
		}	
		int numofUsers = Invitees.size();
		userData = new String [2][numofUsers];
		for (int k = 0; k < 2; k++){
			for (int j = 0; j < numofUsers; j++){
				if(k == 0){
					userData[k][j] = Invitees.get(j).getInviteeIMAcc();
				}
				else{
					userData[k][j] = "http://www.google.com/";
				}
			}
			
		}
		IMInterface myInterface = new IMInterface();
		myInterface.Broadcast(userData);

	}

}
