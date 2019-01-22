<%@ page import="com.jarvis.DAO.DoctorDAO" %>
<%@ page import="com.jarvis.model.Doctor" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Jarvis
  Date: 2019/1/14
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/manage.css">
    <title>医疗预约系统</title>
</head>
<body>
<div class="container">
    <div class="header">
        <div class="title">
            医疗预约系统
        </div>
    </div>
    <%
        int patientId=Integer.parseInt(request.getParameter("patientId"));
        int keShiId=Integer.parseInt(request.getParameter("keShiId"));
        String keShiName=request.getParameter("keShiName");
        DoctorDAO doctorDAO=new DoctorDAO();
        List<Doctor> doctors=doctorDAO.getDoctorList(keShiId);
    %>
    <div class="main">
        <div class="sidebar">
            <a href="homepage.jsp?patientId=<%=patientId%>" class="sidebar-button" >返回主页</a>
        </div>
        <div class="content">
            <div class="detail page-project">
                医师列表：
                <table border="1" cellspacing="10">
                    <tr>
                        <th>医师名字</th>
                        <th>性别</th>
                        <th>电话</th>
                        <th>介绍</th>
                        <th>科室</th>
                        <th>选择</th>
                    </tr>
                    <%for(int i=0;i<doctors.size();i++){%>
                    <tr>
                        <td><%=doctors.get(i).getName()%></td>
                        <td><%=doctors.get(i).getSex()%></td>
                        <td><%=doctors.get(i).getPhone()%></td>
                        <td><%=doctors.get(i).getIntroduction()%></td>
                        <td><%=doctors.get(i).getKeShiId()%></td>
                        <td><a href="scheduleList.jsp?patientId=<%=patientId%>&keShiId=<%=keShiId%>&keShiName=<%=keShiName%>&doctorId=<%=doctors.get(i).getId()%>&doctorName=<%=doctors.get(i).getName()%>">选择</a></td>
                    </tr>
                    <%}%>
                </table>
            </div>
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