<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 31.10.2018
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="item" scope="request" class="com.manyatkin.crudwithservlet.Model.Item"/>
<html>
<head>
    <title>CrUD3</title>
</head>
<body>
<h1>Item</h1>
<form method="post" action="/item">
    <label>Vendor code:
        <input type="text" name="vendorCode" value="${item.vendorCode}" readonly="readonly"><br/>
    </label>
    <label>Name:
        <input type="text" name="name" value="${item.name}"><br/>
    </label>
    <label>Cost:
        <input type="number" name="cost" value="${item.cost}"><br/>
    </label>
    <button type="submit" name="action" value="update">Update</button>
    <button type="submit" name="action" value="delete">Delete</button>
</form>
<a href="/">Back to main menu</a>
</body>
</html>
