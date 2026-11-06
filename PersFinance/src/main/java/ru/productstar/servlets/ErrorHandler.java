package ru.productstar.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ErrorHandler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        handleError(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        handleError(req, resp);
    }

    private void handleError(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        Object status = req.getAttribute("jakarta.servlet.error.status_code");
        int statusCode = status == null ? 500 : (int) status;

        resp.setStatus(statusCode);
        resp.setContentType("text/plain;charset=UTF-8");

        if (statusCode == 404) {
            resp.getWriter().println("Page not found (404)");
        } else {
            resp.getWriter().println("Internal server error (500)");
        }
    }
}