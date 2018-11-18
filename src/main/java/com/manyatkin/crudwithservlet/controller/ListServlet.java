package com.manyatkin.crudwithservlet.controller;

import com.manyatkin.crudwithservlet.Model.MyDataBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("itemsList", MyDataBase.getInstance().getItemsList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("views/list.jsp").forward(req, resp);
    }
}
