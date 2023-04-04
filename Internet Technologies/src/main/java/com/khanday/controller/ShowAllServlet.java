
package com.khanday.controller;

import java.io.IOException;

import com.khanday.model.DBValues;

import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/showAll")
public class ShowAllServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        // Request Dispatch to SearchAndShowServlet to show all students.

        String sql = "SELECT * FROM " + DBValues.database + "." + DBValues.table;

        req.setAttribute("sql", sql);
        RequestDispatcher rd = req.getRequestDispatcher("searchShowServlet");
        rd.forward(req, res);
    }
}