package com.manyatkin.crudwithservlet.controller;

import com.manyatkin.crudwithservlet.model.Item;
import com.manyatkin.crudwithservlet.model.MyDataBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String vendorCode = req.getParameter("vendorCode");
        String name = req.getParameter("name");
        String sCost = req.getParameter("cost");
        int cost = 0;
        if (!sCost.equals("")) {
            cost = Integer.parseInt(sCost);
        }

        if (!vendorCode.equals("") && !name.equals("")) {
            MyDataBase myDataBase = MyDataBase.getInstance();
            Item item = new Item(vendorCode, name, cost);

            try {
                myDataBase.add(item);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            req.setAttribute("item", item.toString());
        }

        doGet(req, resp);
    }

}