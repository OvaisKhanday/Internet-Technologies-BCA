package HelperFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    // saving the attributes of a connection
    private Connection con;
    private String url = "jdbc:mysql://127.0.0.1:3306/";
    private String database = "";
    private String username = "";
    private String password = "";

    public ConnectDB(String database, String username, String password) {
        this.database = database;
        this.url = this.url + this.database;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() {
        return con;
    }

    public Connection connect() throws ClassNotFoundException, SQLException {
        // 1. Define the connection url
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. Establish the connection
        this.con = DriverManager.getConnection(url, username, password);

        System.out.println("Successful connection to Database");
        return con;
    }
}
