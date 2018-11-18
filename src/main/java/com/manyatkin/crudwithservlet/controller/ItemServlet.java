package com.manyatkin.crudwithservlet.controller;

import com.manyatkin.crudwithservlet.Model.Item;
import com.manyatkin.crudwithservlet.Model.MyDataBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String vendorCode = req.getParameter("vendorCode");
        Item item = null;
        try {
            item = MyDataBase.getInstance().findItemByVendorCode(vendorCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("item", item);
        req.getRequestDispatcher("views/item.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String vendorCode = req.getParameter("vendorCode");

        MyDataBase myDataBase = MyDataBase.getInstance();

        if (action.equals("delete")) {
            try {
                myDataBase.delete(vendorCode);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (action.equals("update")) {
            String name = req.getParameter("name");
            String sCost = req.getParameter("cost");
            int cost = 0;
            if (!sCost.equals("")) {
                cost = Integer.parseInt(sCost);
            }

            try {
                myDataBase.update(vendorCode, name, cost);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            req.setAttribute("vendorCode", vendorCode);
        }

        doGet(req, resp);
    }
}
