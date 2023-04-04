import java.sql.*;

import HelperFiles.*;

public class App {
    public static void main(String[] args) throws Exception {

        // Object for storing the attributes to connection: database_name, username,and
        // password
        ConnectDB db_object = new ConnectDB("college", "root", "Khanday@927");
        // Establishing the connection to database and returning Connection instance.
        Connection con = db_object.connect();

        // Presentation of main menu
        MainUI.presentMainUI(con);

        con.close();
    }
}
