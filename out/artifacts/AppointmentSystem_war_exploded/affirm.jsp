<%--
  Created by IntelliJ IDEA.
  User: Jarvis
  Date: 2019/1/14
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/affirm.css">
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
    %>
    <div class="content">
        <div class="person-data">
            <form action="${pageContext.request.contextPath}/RegisterServlet?method=add&roomnum=<%=roomNum%>&keshiname=<%=keShiName%>&doctorname=<%=doctorName%>
                &time=<%=time%>&patientid=<%=patientId%>&keshiid=<%=keShiId%>&doctorid=<%=doctorId%>" method="post">
                <div class="input-line">
                    <label>科室名:</label>
                    <input type="text" class="input-field" value="<%=keShiName%>" disabled="disabled">
                </div>
                <div class="input-line">
                    <label>医生名:</label>
                    <input type="text" class="input-field" value="<%=doctorName%>"  disabled="disabled">
                </div>
                <div class="input-line">
                    <label>房间号:</label>
                    <input type="text" class="input-field" value="<%=roomNum%>" disabled="disabled">
                </div>
                <div class="input-line">
                    <label>日期:</label>
                    <input type="text" class="input-field" value="<%=time%>" disabled="disabled">
                </div>
                <input type="hidden" value="<%=patientId%>" >
                <input type="hidden" value="<%=keShiId%>" >
                <input type="hidden" value="<%=doctorId%>" >
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
