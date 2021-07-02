package com.errorlogger;

import java.sql.*;

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
    public void readTable() {

    }

    //Minimum Requirments
    public void insertRow(String user, String exceptionThrown, String errorMsg) {
        try {
            statement.execute("INSERT into ERROR_LOG");
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

    }
}