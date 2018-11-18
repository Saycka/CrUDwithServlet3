<%@ page import="com.manyatkin.crudwithservlet.model.Item" %>
<%@ page import="java.util.ArrayList" %><
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<jsp:useBean id="itemsList" scope="request" class="java.util.ArrayList"/>
<html>
<head>
    <title>CrUD</title>
</head>
<body>
<h1>List of items</h1>
<form method="get" action="/item">
    <table>
        <tbody>
        <tr>
            <th>Selected</th>
            <th>Vendor code</th>
            <th>Name</th>
            <th>Cost</th>
        </tr>
        <%
            for (Item item : (ArrayList<Item>) itemsList) {
                out.println("<tr>");
                out.println("<td> <input type=\"radio\" name=\"vendorCode\" value=\"" + item.getVendorCode() + "\" >" + "</td>");
                out.println("<td>" + item.getVendorCode() + "</td>");
                out.println("<td>" + item.getName() + "</td>");
                out.println("<td>" + item.getCost() + "</td>");
                out.println("</tr>");
            }
        %>
        </tbody>
    </table>
    <button type="submit">details</button>
</form>
<a href="/">Back to main menu</a>
</body>
</html>
