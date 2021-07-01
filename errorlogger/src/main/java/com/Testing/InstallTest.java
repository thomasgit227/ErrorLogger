package com.Testing;

import java.sql.Connection;
import java.sql.DriverManager;

//Adapted From Tutorial for SQLite, Creates Test DB to Ensure Installation
public class InstallTest {  
   public static void main( String args[] ) {

   try {
      Connection c = DriverManager.getConnection("jdbc:sqlite:test.db");
      c.close();
   } 
   catch (Exception err) {
      System.err.println(err.getClass().getName() + ": " + err.getMessage() );
      System.exit(0);
   }
   System.out.println("Opened database successfully");
 }
}
