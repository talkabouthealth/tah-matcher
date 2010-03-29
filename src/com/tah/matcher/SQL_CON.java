package com.tah.matcher;


   import java.sql.*;

   public class SQL_CON {
	    public void runMe (String host, String database, String user, String password)
	      throws Exception {
	        System.out.println("RunMe");
	        /* run driverTest method shown below */
	        driverTest();
	        
	        /* make the connection to the database */
	        Connection conMe = makeCon (host, database, user, password);
	        
	        /* now run a select query of the intended database */
	        exeQuery (conMe, "SELECT * FROM talkers");
	        
	        /* close the database */
	        conMe.close();
	    } 
	    protected void driverTest () throws Exception {

            try {
                    Class.forName("com.mysql.jdbc.Driver");
                    System.out.println("MySQL Driver Found");
            } catch (java.lang.ClassNotFoundException e) {
                    System.out.println("MySQL JDBC Driver not found ... ");
                    throw (e);
            }
          } 
	    protected Connection makeCon (String host, String database, String user, String password)
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
	    protected void exeQuery(Connection con, String sqlStatement)
        throws Exception {
	    	System.out.println("exeQry");
              try {
                      Statement cs = con.createStatement();
                      ResultSet sqls = cs.executeQuery(sqlStatement);

                      while (sqls.next()) {
                              String id = (sqls.getObject(2).toString());
                              String data = (sqls.getObject(4).toString());
                              System.out.println(id + " " + data);
                      }

                      sqls.close();

              } catch (Exception e) {
                      System.out.println ("Error executing sql statement");
                      throw (e);
              }
  } 
	    public static void main (String args[]) throws Exception {


	            new SQL_CON().runMe("localhost","talkmidb","root","applepie");

	    }      
	/* this bracket closes the class */
	} 