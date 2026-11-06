package ru.productstar.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.productstar.servlets.model.Transaction;
import ru.productstar.servlets.model.TransactionType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExpensesServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var context = req.getServletContext();

        int freeMoney = (int) context.getAttribute("freeMoney");
        var transactions = new ArrayList<Transaction>(
                (List<Transaction>) context.getAttribute("expenses")
        );

        for (var parameter : req.getParameterMap().keySet()) {
            int value = Integer.parseInt(req.getParameter(parameter));

            freeMoney -= value;
            transactions.add(new Transaction(parameter, value, TransactionType.EXPENSE));
        }

        context.setAttribute("expenses", transactions);
        context.setAttribute("freeMoney", freeMoney);

        resp.sendRedirect("/summary");
    }
}