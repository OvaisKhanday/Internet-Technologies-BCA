package com.khanday.controller;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import com.khanday.model.DBValues;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class InsertServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        final String rollNo = req.getParameter("rollNo").trim();
        final String name = req.getParameter("name").trim();
        final String address = req.getParameter("address").trim();
        final String phoneNo = req.getParameter("phoneNo").trim();

        final boolean isFormValid = Validator.validateAddForm(rollNo, name, address, phoneNo);
        if (!isFormValid) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg", "wrong-parameters");
            map.put("description", "Input data are wrong. Please check your parameters and try again.");
            Dispatchers.dispatchError(req, res, map);
            return;
        }

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        int rowsAffected = -1;
        boolean isRecordPresent = false;

        String recordAlreadyPresent = "SELECT * FROM " + DBValues.database + "." + DBValues.table + " WHERE "
                + DBValues.colRollNo + " = " + rollNo;

        String sql = "INSERT INTO " + DBValues.database + "." + DBValues.table + " (" +
                DBValues.colRollNo + ", " + DBValues.colName + ", " + DBValues.colAddress + ", " + DBValues.colPhoneNo +
                ") VALUES( " + rollNo + ", \"" + name + "\", \"" + address + "\", \"" + phoneNo + "\");";

        try {
            con = ConnectDB.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(recordAlreadyPresent);
            isRecordPresent = rs.next();
        } catch (ClassNotFoundException | SQLException e) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg", "no-connection-to-db");
            map.put("description", e.getMessage());
            Dispatchers.dispatchError(req, res, map);
            return;
        }

        if (isRecordPresent) {
            // res.setContentType("text/html");
            // out.println("<script type=\"text/javascript\">");
            // out.println("alert('Student with same roll no already registered');");
            // out.println("location='index.html';");
            // out.println("</script>");
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg", "record-already-exists");
            map.put("description", "The record is existent with:" +
                    "</br> roll no = " + rollNo +
                    "</br> name = " + name +
                    "</br> address = " + address +
                    "</br> phone no = " + phoneNo);
            Dispatchers.dispatchError(req, res, map);
            return;
        }

        try {
            rowsAffected = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg", "no-execution");
            map.put("description", e.getMessage());
            Dispatchers.dispatchError(req, res, map);
            return;
        }

        if (rowsAffected == 1) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg", "record-added");
            map.put("description", "Entry has been made into the database with:" +
                    "</br> roll no = " + rollNo +
                    "</br> name = " + name +
                    "</br> address = " + address +
                    "</br> phone no = " + phoneNo);
            Dispatchers.dispatchSuccess(req, res, map);
            return;
        } else {
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg", "record-not-added");
            map.put("description", "something unexpected happened. No records were added into the database.");
            Dispatchers.dispatchError(req, res, map);
            return;
        }

    }

}
