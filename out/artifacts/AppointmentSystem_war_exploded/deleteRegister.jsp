<%--
  Created by IntelliJ IDEA.
  User: Jarvis
  Date: 2019/1/14
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/modify.css">
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="header">
        <div class="title">
            医院预约系统
        </div>
    </div>
    <%
        int patientId=Integer.parseInt(request.getParameter("patientId"));
        int keShiId=Integer.parseInt(request.getParameter("keShiId"));
        String keShiName=request.getParameter("keShiName");
        int doctorId=Integer.parseInt(request.getParameter("doctorId"));
        String doctorName=request.getParameter("doctorName");
        int roomNum=Integer.parseInt(request.getParameter("roomNum"));
        String time=request.getParameter("time");
        int registerId=Integer.parseInt(request.getParameter("registerId"));
    %>
    <div class="content">
        <div class="person-data">
            <form action="${pageContext.request.contextPath}/RegisterServlet?method=delete" method="post">
                <div class="input-line">
                    <label>科室名:</label>
                    <input type="text" class="input-field" value="<%=keShiName%>" name="ke-shi-name" disabled="disabled">
                </div>
                <div class="input-line">
                    <label>医生名:</label>
                    <input type="text" class="input-field" value="<%=doctorName%>" name="doctor-name" disabled="disabled">
                </div>
                <div class="input-line">
                    <label>房间号:</label>
                    <input type="text" class="input-field" value="<%=roomNum%>" name="room-num" disabled="disabled">
                </div>
                <div class="input-line">
                    <label>日期:</label>
                    <input type="text" class="input-field" value="<%=time%>" name="time" disabled="disabled">
                </div>
                <input type="hidden" value="<%=patientId%>" name="patient-id">
                <input type="hidden" value="<%=keShiId%>" name="ke-shi-id">
                <input type="hidden" value="<%=doctorId%>" name="doctor-id">
                <input type="hidden" value="<%=registerId%>" name="register-id">
                <div class="input-line">
                    <input type="submit" value="Delete" class="btn" >
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
