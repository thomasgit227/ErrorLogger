package com.errorlogger;
import java.sql.*;

public class Main {
    public static void main( String args[] ) {
        try {
           Connection connection = DriverManager.getConnection("jdbc:sqlite:log.db");
           System.out.println("Opened Log DB Successfully");
  
           Statement statement = connection.createStatement();
           //May God Bless this Poor Formatting
           String sql = "CREATE TABLE ERROR_LOG " +
                        "(ID INT PRIMARY KEY, " +
                        "USER_CREATED_BY TEXT NOT NULL, " +
                        "DATE_CREATED DATETIME NOT NULL, " +
                        "EXCEPTION_THROWN TEXT, " +
                        "STACKTRACE TEXT, " +
                        "ERROR_MESSAGE TEXT NOT NULL, " +
                        "SEVERITY INT, " +
                        "SOURCE TEXT)";

           statement.executeUpdate(sql);
           statement.close();
           connection.close();
        } 
        catch (Exception e) {
           System.err.println(e.getClass().getName() + ": " + e.getMessage());
           System.exit(0);
        }
        System.out.println("Table Created");
    }
}  