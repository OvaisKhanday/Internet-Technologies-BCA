package com.khanday.controller;

import java.io.IOException;
import java.lang.String;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.khanday.model.DBValues;
import com.khanday.model.Student;

import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/searchShowServlet")
public class SearchShowServlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        String sql = req.getAttribute("sql").toString();

        ArrayList<Student> studentsList = new ArrayList<Student>();
        Connection con;
        Statement stmt = null;
        ResultSet rs = null;
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
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg", "no-execution");
            map.put("description", e.getMessage());
            Dispatchers.dispatchError(req, res, map);
            return;
        }
        try {
            while (rs.next()) {
                Student s = new Student();
                s.setRollNo(rs.getLong(DBValues.colRollNo));
                s.setName(rs.getString(DBValues.colName));
                s.setAddress(rs.getString(DBValues.colAddress));
                s.setPhoneNo(rs.getString(DBValues.colPhoneNo));
                studentsList.add(s);
            }
        } catch (SQLException e) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg", "unexpected-error");
            map.put("description", "Unexpected error occurred.");
            Dispatchers.dispatchError(req, res, map);
            return;
        }

        req.setAttribute("list", studentsList);
        req.setAttribute("sql", sql);
        RequestDispatcher rd = req.getRequestDispatcher("search.jsp");
        rd.forward(req, res);

    }
}