
package com.khanday.controller;

import java.io.IOException;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

import com.khanday.model.DBValues;

import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        final String rollNo = req.getParameter("rollNo").trim();
        final String name = req.getParameter("name").trim();
        final String address = req.getParameter("address").trim();
        final String phoneNo = req.getParameter("phoneNo").trim();

        final boolean isFormValid = Validator.validateSearchForm(rollNo, name, address, phoneNo);
        if (!isFormValid) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("msg", "wrong-parameters");
            map.put("description", "Input data are wrong. Please check your parameters and try again.");
            Dispatchers.dispatchError(req, res, map);
            return;
        }

        String sql = "SELECT * FROM " + DBValues.database + "." + DBValues.table + " WHERE" +
                (rollNo == "" ? "" : (" " + DBValues.colRollNo + " = " + rollNo + " and")) +
                (name == "" ? "" : (" " + DBValues.colName + " = \"" + name + "\" and")) +
                (address == "" ? "" : (" " + DBValues.colAddress + " = \"" + address + "\" and")) +
                (phoneNo == "" ? "" : (" " + DBValues.colPhoneNo + " = \"" + phoneNo + "\""));

        if (sql.charAt(sql.length() - 1) == 'd')
            sql = sql.substring(0, sql.length() - 3);

        req.setAttribute("sql", sql);
        RequestDispatcher rd = req.getRequestDispatcher("searchShowServlet");
        rd.forward(req, res);
    }
}