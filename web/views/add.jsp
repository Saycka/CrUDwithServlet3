<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 03.11.2018
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CrUD</title>
</head>
<body>
<h1>Add new item</h1>
<form method="post">
    <label>Vendor code:
        <input type="text" name="vendorCode"><br/>
    </label>
    <label>Name:
        <input type="text" name="name"><br/>
    </label>
    <label>Cost:
        <input type="number" name="cost"><br/>
    </label>
    <button type="submit">Add</button>
</form>
<a href="/">Back to main menu</a>
</body>
</html>
