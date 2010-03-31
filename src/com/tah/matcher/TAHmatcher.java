package com.tah.matcher;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class TAHmatcher {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String db_host = "localhost";
		String db_name = "talkmidb";
		String db_user = "root";
		String db_password = "applepie";
		Connection con;
		String post_author = "testIM5566@gmail.com";
		String qry = "SELECT * FROM talkers WHERE email <> '" + post_author +"'";
		SQL_CON SQL_Conn = new SQL_CON();
		List Invitees;
		Invitees = new ArrayList<Invitee>();
		if(SQL_Conn.driverTest()){
			try {
				con = SQL_Conn.setCon(db_host, db_name, db_user, db_password);
				Invitees = SQL_Conn.exeQuery(con, qry);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < Invitees.size(); i++){
			Invitee PPL = (Invitee)Invitees.get(i);
			System.out.println(PPL.getInviteeName() + " has IM account of " + PPL.getInviteeIMAcc());
		}
	}

}
