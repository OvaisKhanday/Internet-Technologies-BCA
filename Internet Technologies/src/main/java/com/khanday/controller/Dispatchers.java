package com.khanday.controller;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// this class dispatches the error or success message to error or success page respectively.
public class Dispatchers {
    public static void dispatchError(HttpServletRequest req, HttpServletResponse resp, Map<String, String> map) {
        req.setAttribute("error", map);
        RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
        try {
            rd.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void dispatchSuccess(HttpServletRequest req, HttpServletResponse resp, Map<String, String> map) {
        req.setAttribute("success", map);
        RequestDispatcher rd = req.getRequestDispatcher("success.jsp");
        try {
            rd.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
