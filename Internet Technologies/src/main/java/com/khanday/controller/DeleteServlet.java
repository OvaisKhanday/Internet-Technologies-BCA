package com.khanday.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.khanday.model.DBValues;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        // Getting all the parameters set by an user
        final String rollNo = req.getParameter("rollNo").trim();
        final String name = req.getParameter("name").trim();
        final String address = req.getParameter("address").trim();
        final String phoneNo = req.getParameter("phoneNo").trim();

        // Validation checking and publishing the error page if parameters are not
        // valid.
        final boolean isFormValid = Validator.validateDeleteForm(rollNo, name, address, phoneNo);
        if (!isFormValid) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg", "wrong-parameters");
            map.put("error", "Input data are wrong. Please check your parameters and try again.");
            Dispatchers.dispatchError(req, res, map);
            return;
        }

        // Generating a sql query
        String sql = "DELETE FROM " + DBValues.database + "." + DBValues.table + " WHERE" +
                (rollNo == "" ? "" : (" " + DBValues.colRollNo + " = " + rollNo + " and")) +
                (name == "" ? "" : (" " + DBValues.colName + " = \"" + name + "\" and")) +
                (address == "" ? "" : (" " + DBValues.colAddress + " = \"" + address + "\" and")) +
                (phoneNo == "" ? "" : (" " + DBValues.colPhoneNo + " = \"" + phoneNo + "\""));

        if (sql.charAt(sql.length() - 1) == 'd') {
            sql = sql.substring(0, sql.length() - 3);
        }

        Connection con = null;
        Statement stmt = null;
        int rowsAffected = -1; // number of rows affected in database

        // Getting connection to database and creating a statement.
        try {
            con = ConnectDB.getConnection();
            stmt = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg", "no-connection-to-db");
            map.put("description", e.getMessage());
            Dispatchers.dispatchError(req, res, map);
            return;
        }

        // Executing the sql query
        try {
            rowsAffected = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg", "no-execution");
            map.put("description", e.getMessage());
            Dispatchers.dispatchError(req, res, map);
            return;
        }

        // result from the sql query
        if (rowsAffected > 0) {
            // if at least one row is affected, it means it has been deleted successfully
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg", "record-deleted");
            map.put("description", rowsAffected + " record(s) successfully deleted from the database.");
            Dispatchers.dispatchSuccess(req, res, map);
            return;
        } else if (rowsAffected == 0) {
            // 0 means no record were found which pertain the sql query
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg", "record-not-found-to-delete");
            map.put("description", "Record(s) not found in the database.");
            Dispatchers.dispatchError(req, res, map);
            return;
        } else {
            // some error
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg", "unexpected-error");
            map.put("description", "Unexpected error occurred.");
            Dispatchers.dispatchError(req, res, map);
            return;

        }

    }
}