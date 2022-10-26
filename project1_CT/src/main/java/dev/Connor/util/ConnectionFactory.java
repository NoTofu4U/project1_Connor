package dev.Connor.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException{
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
            System.out.println("Class was not found");
            e.printStackTrace();
        }
        //database schema
        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=projectonect";
        String username = "postgres";
        String password = "password";

        //returns our Connection obj (has a connection return type?)
        return DriverManager.getConnection(url, username, password);
    }

}
