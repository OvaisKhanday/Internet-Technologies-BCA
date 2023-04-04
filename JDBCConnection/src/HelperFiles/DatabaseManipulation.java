package HelperFiles;

import java.sql.*;

public class DatabaseManipulation {
    // Insert
    // Delete
    // Retrieve
    // Alter

    // ! Display the whole table
    public static void displayAllRecords(Connection con) throws SQLException {
        String sql_query = "SELECT * FROM students";

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(sql_query);

        DatabaseManipulation.printResultSet(rs);

        stmt.close();
    }

    // !Insert a record
    public static void insertRecord(Connection con, int roll_no, String name, String address, String phone_no)
            throws SQLException {
        Statement stmt = con.createStatement();
        String sql_query = "INSERT INTO students VALUES(" + roll_no + ",\"" + name + "\",\""
                + address
                + "\",\"" + phone_no + "\")";

        stmt.executeUpdate(sql_query);

        // DatabaseManipulation.displayAllRecords(con);
        stmt.close();
    }

    public static void insertRecord(Connection con) {
        Student st = new Student();
        st.askStudentDetails();
        try {
            insertRecord(con, st.getRoll_no(), st.getName(), st.getAddress(), st.getPhone_no());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    // ! Search by either roll_no, name, address, or phone_no
    public static void searchRoll_no(Connection con, int roll_no) throws SQLException {
        String sql_query = "SELECT * FROM students Where roll_no = " + roll_no;
        searchQuery(con, sql_query);
    }

    public static void searchName(Connection con, String name) throws SQLException {
        String sql_query = "SELECT * FROM students WHERE name = \"" + name + "\"";
        searchQuery(con, sql_query);
    }

    public static void searchAddress(Connection con, String address) throws SQLException {
        String sql_query = "SELECT * FROM students WHERE address = \"" + address + "\"";
        searchQuery(con, sql_query);
    }

    public static void searchPhone_no(Connection con, String phone_no) throws SQLException {
        String sql_query = "SELECT * FROM students WHERE phone_no = \"" + phone_no + "\"";
        searchQuery(con, sql_query);
    }

    public static ResultSet searchQuery(Connection con, String sql_query) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql_query);
        DatabaseManipulation.printResultSet(rs);
        stmt.close();
        return rs;
    }

    // ! Delete
    public static void deleteRecord(Connection con, int roll_no) throws SQLException {
        Statement stmt = con.createStatement();
        String sql_query = "DELETE FROM students WHERE roll_no = " + roll_no;
        stmt.executeUpdate(sql_query);
        stmt.close();
    }

    public static void deleteRecord(Connection conn, String name) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql_query = "DELETE FROM students WHERE name = \"" + name + "\"";
        stmt.executeUpdate(sql_query);
        stmt.close();
    }

    // ! Update
    public static void updateRecords(Connection con, String sql_query) throws SQLException {
        Statement stmt = con.createStatement();
        stmt.executeUpdate(sql_query);
        stmt.close();
    }

    public static void updateRoll_no(Connection con, int roll_no, int new_roll_no) throws SQLException {
        String sql_query = "UPDATE students SET roll_no = " + new_roll_no + " WHERE roll_no = " + roll_no;
        DatabaseManipulation.updateRecords(con, sql_query);
    }

    public static void updateName(Connection con, int roll_no, String name) throws SQLException {
        String sql_query = "UPDATE students SET name = \"" + name + "\" WHERE roll_no = " + roll_no;
        DatabaseManipulation.updateRecords(con, sql_query);
    }

    public static void updateAddress(Connection con, int roll_no, String address) throws SQLException {
        String sql_query = "UPDATE students SET address = \"" + address + "\" WHERE roll_no = " + roll_no;
        DatabaseManipulation.updateRecords(con, sql_query);
    }

    public static void updatePhone_no(Connection con, int roll_no, String phone_no) throws SQLException {
        String sql_query = "UPDATE students SET phone_no = \"" + phone_no + "\" WHERE roll_no = " + roll_no;
        DatabaseManipulation.updateRecords(con, sql_query);
    }

    // ! Print ResultSet
    public static void printResultSet(ResultSet rs) throws SQLException {
        System.out.println(
                "\n######################################################################################################################");
        System.out.printf(" | %-10S | %-40S | %-40S | %-15S\n", "roll_no", "name", "address", "phone_no");
        System.out.println(
                "-|------------|------------------------------------------|------------------------------------------|------------");
        while (rs.next()) {
            System.out.printf(" | %-10s", rs.getInt("roll_no"));
            System.out.printf(" | %-40s", rs.getString("name"));
            System.out.printf(" | %-40s", rs.getString("address"));
            System.out.printf(" | %-15s", rs.getString("phone_no"));
            System.out.println();
        }
        System.out.println(
                "######################################################################################################################");

    }
}
