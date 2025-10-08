package cda.bibliotheque.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/bibliotheque";
    private static final String USER = "root";
    private static final String PASSWORD = "Titan62840/";

    public static Connection connection;
    public static Connection getConnection(){
        if (connection == null ) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("connection établie ");
            } catch (ClassNotFoundException | SQLException e ) {
                System.err.println("Erreur de connection " + e.getMessage());
            }
        }
        return connection;
    }
}
