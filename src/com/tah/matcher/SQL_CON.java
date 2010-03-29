package com.tah.matcher;


import java.sql.*;

public class SQL_CON {
	   public void findOutUsers(String author) throws Exception{
		   String db_host = "localhost";
		   String db_name = "talkmidb";
		   String db_user = "root";
		   String db_passwd = "applepie";
		   String qry = "SELECT * FROM talkers WHERE email <> " + author;
		   Connection con = new SQL_CON().setCon(db_host, db_name, db_user, db_passwd);
		   new SQL_CON().exeQuery(con, qry);

	   }
	   /* Check if JDBC driver exist*/
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
	    /* Gather user data*/
	    protected void exeQuery(Connection con, String sqlStatement)
     throws Exception {
	    		System.out.println("exeQry");

	    		int counter = 0;
	    		try {
	    			Statement state = con.createStatement();
                 ResultSet qry = state.executeQuery(sqlStatement);
                 System.out.println("exeQry");

                 while (qry.next()) {
                 	String username = (qry.getObject("uname").toString());
                 	String useremail = (qry.getObject("email").toString());
                     System.out.println(username + " " + useremail);   
                     
                     counter ++;
                 }

           } catch (Exception e) {
                   	System.out.println ("Error executing sql statement");
                   	throw (e);
           }
           
	    } 

	    public static void main (String args[]) throws Exception {
	    	    
	    	String post_author = "'murray@talkmi.com'";
	    	if(new SQL_CON().driverTest()){
	    		new SQL_CON().findOutUsers(post_author);
	    		
	    		
	//    		con.close();		//terminate database connection
	    	}
	    	
	    	
	    		
	    	

	    }      
	} 