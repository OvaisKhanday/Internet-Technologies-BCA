package com.khanday.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.khanday.model.*;

// This is a helper singleton class, which is being used to handle the connection to database.
public class ConnectDB {

    // saving the attributes of a connection
    private static Connection con = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (con == null) {
            con = connect();
        }
        return con;
    }

    private static Connection connect() throws ClassNotFoundException, SQLException {
        // 1. Define the connection url
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. Establish the connection
        con = DriverManager.getConnection(DBValues.url + DBValues.database, DBValues.username, DBValues.password);

        // debugging purposes only
        System.out.println("Successful connection to Database");
        return con;
    }

}
