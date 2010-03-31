package com.tah.matcher;

import java.sql.*;
import java.util.*;

public class SQL_CON {
	private String db_host;
	private String db_name;
	private String db_user;
	private String db_password;
	private String qry;
	private Connection con;
	public SQL_CON(){
		db_host = "localhost";
		db_name = "talkmidb";
		db_user = "root";
		db_password = "applepie";
//		qry = "SELECT * FROM talkers WHERE email <> '" + post_author + "'";
//		con = new SQL_Con().setCon(db_host, db_name, db_user, db_password);
	}

    protected Connection setCon (String host, String database, String user, String password)
    throws Exception {
    			
          String url = "";
          try {
        	  	url = "jdbc:mysql://" + host + ":3306/" + database;
                Connection con = DriverManager.getConnection(url, user, password);
                System.out.println("Connection established to " + url + "...");
                return con;
          } catch (java.sql.SQLException e) {
        	  	System.out.println("Connection couldn't be established to " + url);
          throw (e);
          }
    }
    protected boolean driverTest () throws Exception {
        try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("MySQL Driver Found");
                return true;
        } catch (java.lang.ClassNotFoundException e) {
                System.out.println("MySQL JDBC Driver not found ... ");
                throw (e);
        }
     }
    protected List<Invitee> exeQuery(Connection con, String sqlStatement)
    throws Exception {
    	List<Invitee> Invitees;
    	Invitee PPL;
    	Invitees = new ArrayList<Invitee>();
    		System.out.println("exeQry");
    		
    		//int counter;
    		try {
    			Statement state = con.createStatement();
                ResultSet qry = state.executeQuery(sqlStatement);

                while (qry.next()) {
                	PPL = new Invitee(qry.getObject("uname").toString(), qry.getObject("email").toString());
                	Invitees.add(PPL);
             //   	LookingInvitees[counter].setInviteeName(qry.getObject("uname").toString());
             //   	String username = (qry.getObject("uname").toString());
//                   	String useremail = (qry.getObject("email").toString());
             //       System.out.println(LookingInvitees[counter].getInviteeName() + " " + useremail);   
                    
             //       counter ++;
                }
                Invitee P;
                int limit = Invitees.size();
                for(int i = 0; i < limit; i++){
                	P = (Invitee) Invitees.get(i);
 //               	System.out.println(P.getInviteeName() + " with account of " + P.getInviteeIMAcc());
                }

          } catch (Exception e) {
                  	System.out.println ("Error executing sql statement");
                  	throw (e);
          }
			return Invitees;
          
    } 
    
}
