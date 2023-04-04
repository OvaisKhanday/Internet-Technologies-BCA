package com.khanday.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        final String existingRollNo = req.getParameter("existingRollNo").trim();
        final String rollNo = req.getParameter("rollNo").trim();
        final String name = req.getParameter("name").trim();
        final String address = req.getParameter("address").trim();
        final String phoneNo = req.getParameter("phoneNo").trim();

        final boolean isFormValid = Validator.validateUpdateForm(existingRollNo, rollNo, name, address, phoneNo);
        if (!isFormValid) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg", "wrong-parameters");
            map.put("description", "Input data are wrong. Please check your parameters and try again.");
            Dispatchers.dispatchError(req, res, map);
            return;
        }

        String sqlDoesUserExist = "SELECT * FROM " + DBValues.database + "." + DBValues.table + " WHERE " +
                DBValues.colRollNo + " = " + existingRollNo;

        Connection con = null;
        Statement stmt = null;
        int rowsAffected = -1;
        boolean isUserPresent = false;

        try {
            con = ConnectDB.getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlDoesUserExist);
            isUserPresent = rs.next();
        } catch (ClassNotFoundException | SQLException e) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg", "no-connection-to-db");
            map.put("description", e.getMessage());
            Dispatchers.dispatchError(req, res, map);
            return;
        }

        if (!isUserPresent) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg", "record-not-found-to-update");
            map.put("description", "No student with roll no (" + existingRollNo + ") found in the database to update.");
            Dispatchers.dispatchError(req, res, map);
            return;
        }

        String sql = "UPDATE " + DBValues.database + "." + DBValues.table + " SET" +
                (rollNo == "" ? "" : (" " + DBValues.colRollNo + " = " + rollNo + ",")) +
                (name == "" ? "" : (" " + DBValues.colName + " = \"" + name + "\",")) +
                (address == "" ? "" : (" " + DBValues.colAddress + " = \"" + address + "\",")) +
                (phoneNo == "" ? "" : (" " + DBValues.colPhoneNo + " = \"" + phoneNo + "\""));

        if (sql.charAt(sql.length() - 1) == ',')
            sql = sql.substring(0, sql.length() - 1);

        sql = sql + " WHERE (" + DBValues.colRollNo + " = " + existingRollNo + ");";

        try {
            rowsAffected = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg", "no-execution");
            map.put("description", e.getMessage());
            Dispatchers.dispatchError(req, res, map);
            return;
        }

        if (rowsAffected > 0) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg", "record-updated");
            map.put("description", "record successfully updated into the database.");
            Dispatchers.dispatchSuccess(req, res, map);
            return;
        } else {
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg", "unexpected-error");
            map.put("description", "Unexpected error occurred.");
            Dispatchers.dispatchError(req, res, map);
            return;

        }

    }
}