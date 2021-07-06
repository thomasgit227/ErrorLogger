package com.errorlogger;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.sql.*;

public class Main {
    public static void main( String args[] ) {
        TableEditor tableEdit = new TableEditor();
        // createInitialDB();
        // tableEdit.insertRow("Thomas", "Overflow", "Too Cool 4 U");
        // tableEdit.insertRow("Dan", "Overflow", "Too Cool 4 U");
       tableEdit.readEntireTable();
    }

    public static void createInitialDB() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:log.db");
            System.out.println("Opened Log DB Successfully");
  
            Statement statement = connection.createStatement();
            //May God Bless this Poor Formatting
            String sql = Files.readString(Paths.get("errorlogger/src/main/java/com/errorlogger/TableCreation.sql"), StandardCharsets.US_ASCII);

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