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
	
	public TAHmatcher(int uid, int conv_id, String comment){
		UID = uid;
		Conv_ID = conv_id;
		Comment = comment;
		CRR = new ChatRoom_Req(UID, Conv_ID, Comment);
	}
	public void matcher() throws Exception {
		CRR.setCR_Info();
		System.out.println("The chat room stauts is " + CRR.getCR_Info().getCR_Status());
		System.out.println("The chat room URL is " + CRR.getCR_Info().getCR_URL());
		String [][] userData;
		
		// if chat room created successfully, connecting to database
		if (CRR.getCR_Info().getCR_Status() != 0){
			System.out.println("Chat Room Created Successfully \nNow, connecting to Database...");
			String db_host = "localhost";
			String db_name = "talkmidb";
			String db_user = "root";
			String db_password = "applepie";
//			String post_author = "testIM5566@gmail.com";
			String sql = "SELECT * FROM talkers WHERE uid <> " + UID ;
			// establish connection to database
			SQL_CON SQL_Conn = new SQL_CON(db_host, db_name, db_user, db_password, sql);
			// create a dynamic arraylist to store users info
			List<Invitee> Invitees;
			Invitees = new ArrayList<Invitee>();
			if(SQL_Conn.driverTest()){
				try {
					Invitees = SQL_Conn.exeQuery(SQL_Conn.getCon(), sql);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			int numofUsers;
			numofUsers = Invitees.size();
//			String [2][numofUsers] userData;
			userData = new String [2][numofUsers];			String [] UserList;
			UserList = new String [Invitees.size()];
			for (int i = 0; i < Invitees.size(); i++){
				Invitee PPL = (Invitee)Invitees.get(i);
				UserList[i] = PPL.getInviteeIMAcc();
				System.out.println(PPL.getInviteeName() + " has IM account of " + UserList[i]);
			}	
			for (int k = 0; k < 2; k++){
				for (int j = 0; j < numofUsers; j++){
					if(k == 0){
						userData[k][j] = UserList[j];
					}
					else{
						userData[k][j] = "http://www.google.com/";
					}
				}
				
			}
			//IMInterface myInterface = new IMInterface();
			//myInterface.Broadcast(userData);
					
		}
	}

}
