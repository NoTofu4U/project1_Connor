package dev.Connor.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() {
        String url = System.getenv("POSTGRES-SQL-DB");
        String username = System.getenv("DB_USERNAME");
        String password = System.getenv("PASSWORD");

        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}

/**
 * boilerplate - Bad/Unsafe Connection Factory
 * public static Connection getConnection() throws SQLException{
 *         try {
 *             Class.forName("org.postgresql.Driver");
 *         } catch (ClassNotFoundException e){
 *             System.out.println("Class was not found");
 *             e.printStackTrace();
 *         }
 *         //database schema
 *         String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=projectonect";
 *         String username = "postgres";
 *         String password = "password";
 *
 *         //returns our Connection obj (has a connection return type?)
 *         return DriverManager.getConnection(url, username, password);
 *     }
 *
 *         slightly less bad way
 *      try {
 *             Connection connection = DriverManager.getConnection(System.getenv("POSTGRES_SQL_DB"));
 *             return connection;
 *         } catch (SQLException e) {
 *             e.printStackTrace();
 *             return null;
 *         }
 *
 *
 *     jdbc:postgresql://localhost:5432/postgres?user=postgres&password=password&currentSchema=projectonect
 */
