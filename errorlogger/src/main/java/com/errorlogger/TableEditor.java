package com.errorlogger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TableEditor {

    Statement statement = null;

    public TableEditor() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:log.db");
            statement = connection.createStatement();
        }
        catch(Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0); //Ironically Enough, this doesn't log itself
        }
    }

    //Select * From Table
    public void readEntireTable() {
        System.out.println("ID\tUSER\tDATETIME\t\tEXCEPTION\tSTACKTRACE\tERROR MESSAGE\tSEVERITY\tSOURCE");
        try {
            ResultSet queryResults = statement.executeQuery("SELECT * FROM ERROR_LOG");
            while(queryResults.next()) {
                System.out.println(queryResults.getInt("ID") + "\t" + 
                queryResults.getString("USER_CREATED_BY") + "\t" +
                queryResults.getString("DATE_CREATED") + "\t" +
                queryResults.getString("EXCEPTION_THROWN") + "\t" +
                queryResults.getString("STACKTRACE") + "\t" +
                queryResults.getString("ERROR_MSG") + "\t" +
                queryResults.getInt("SEVERITY") + "\t" +
                queryResults.getString("SOURCE")
                );
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Minimum Requirments
    public void insertRow(String user, String exceptionThrown, String errorMsg) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd @ HH:mm:ss z");
        String currentDate = formatter.format(new Date());

        try {
            statement.execute(
                "INSERT into ERROR_LOG " +
                "(USER_CREATED_BY, DATE_CREATED, EXCEPTION_THROWN, ERROR_MSG) VALUES " +
                "('" + user + "', '" + currentDate + "', '" + exceptionThrown + "', '" + errorMsg + "')"
            );
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Searched by ID
    public void updateRow(int id) {

    }

    //Searched by ID
    public void deleteRow(int id) {
        try {
            statement.execute(
                "DELETE FROM ERROR_LOG WHERE ID=" + id
            );
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}