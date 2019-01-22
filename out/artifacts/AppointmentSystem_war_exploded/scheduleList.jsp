<%@ page import="com.jarvis.model.Schedule" %>
<%@ page import="com.jarvis.DAO.ScheduleDAO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Jarvis
  Date: 2019/1/14
  Time: 15:17
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
        int doctorId=Integer.parseInt(request.getParameter("doctorId"));
        System.out.println(doctorId);
        String doctorName=request.getParameter("doctorName");
        ScheduleDAO scheduleDAO=new ScheduleDAO();
        List<Schedule> list=scheduleDAO.getScheduleList(doctorId);
    %>
    <div class="main">
        <div class="sidebar">
            <a href="homepage.jsp?patientId=<%=patientId%>" class="sidebar-button" >返回主页</a>
        </div>
        <div class="content">
            <div class="detail page-project">
                日程列表：
                <table border="1" cellspacing="10">
                    <tr>
                        <th>房间号</th>
                        <th>医师名字</th>
                        <th>时间</th>
                        <th>预约</th>
                    </tr>
                    <%for(int i=0;i<list.size();i++){%>
                    <tr>
                        <td><%=list.get(i).getRoom_num()%></td>
                        <td><%=list.get(i).getDoctorName()%></td>
                        <td><%=list.get(i).getDetail_time()%></td>
                        <td><a href="affirm.jsp?patientId=<%=patientId%>&keShiId=<%=keShiId%>&keShiName=<%=keShiName%>&doctorId=<%=doctorId%>&doctorName=<%=doctorName%>
                        &roomNum=<%=list.get(i).getRoom_num()%>&time=<%=list.get(i).getDetail_time()%>" >预约</a></td>
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