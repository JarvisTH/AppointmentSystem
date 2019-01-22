<%--
  Created by IntelliJ IDEA.
  User: Jarvis
  Date: 2019/1/14
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/register.css">
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="header">
        <div class="title">
            Personal File
        </div>
    </div>
    <div class="content">
        <div class="person-data">
            <form action="${pageContext.request.contextPath}/WebLoginServlet?method=add" method="post">
                <div class="input-line">
                    <label>Name:</label>
                    <input type="text" class="input-field" name="name">
                </div>
                <div class="input-line">
                    <label>Password:</label>
                    <input type="password" class="input-field" name="password">
                </div>
                <div class="input-line">
                    <label>age:</label>
                    <input type="text" class="input-field"  name="age">
                </div>
                <div class="input-line">
                    <label>Sex:</label>
                    <input type="text" class="input-field"  name="sex">
                </div>
                <div class="input-line">
                    <label>Address:</label>
                    <input type="text" class="input-field"  name="address">
                </div>
                <div class="input-line">
                    <label>Phone:</label>
                    <input type="text" class="input-field" name="phone">
                </div>
                <div class="input-line">
                    <input type="submit" value="Submit" class="btn" >
                </div>
            </form>
        </div>
    </div>
    <div class="footer">
        <address>
            <p>CSU</p>
            <p>Changsha City</p>
            <p>Hunan Province</p>
        </address>
        <p>All rights reserved</p>
        <p>201810</p>
    </div>
</div>
</body>
</html>
