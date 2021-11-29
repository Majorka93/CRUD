package ru.major.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {

    private static Connection connection;
    private static String user = "postgres";
    private static String pass = "123";
    private static String url = "jdbc:postgresql://localhost:5432/postgres";


    public static Connection create() throws SQLException {
        if (connection != null)
            return connection;

        connection = DriverManager.getConnection(url, user, pass);
        connection.setAutoCommit(true);

        return connection;
    }

}
