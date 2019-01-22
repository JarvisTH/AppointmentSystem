<%@ page import="com.jarvis.DAO.PatientDAO" %>
<%@ page import="com.jarvis.model.Patient" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Jarvis
  Date: 2019/1/14
  Time: 18:27
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
            Personal File
        </div>
    </div>
    <%
        int index=Integer.parseInt(request.getParameter("patientId"));
        PatientDAO patientDAO=new PatientDAO();
        List<Patient> patients=patientDAO.getPatientList();
        Patient patient=null;
        for(int i=0;i<patients.size();i++){
            if(patients.get(i).getId()==index){
                patient=patients.get(i);
                break;
            }
        }
    %>
    <div class="content">
        <div class="person-data">
            <form action="${pageContext.request.contextPath}/WebLoginServlet?method=modify" method="post">
                <div class="input-line">
                    <label>Name:</label>
                    <input type="text" class="input-field" value="<%=patient.getName()%>" name="patient-name">
                </div>
                <div class="input-line">
                    <label>Password:</label>
                    <input type="password" class="input-field" value="<%=patient.getPassword()%>" name="patient-password">
                </div>
                <div class="input-line">
                    <label>Sex:</label>
                    <input type="text" class="input-field" value="<%=patient.getSex()%>" name="patient-sex">
                </div>
                <div class="input-line">
                    <label>Age:</label>
                    <input type="text" class="input-field" value="<%=patient.getAge()%>" name="patient-age">
                </div>
                <div class="input-line">
                    <label>Address:</label>
                    <input type="text" class="input-field" value="<%=patient.getAddr()%>" name="patient-addr">
                </div>
                <div class="input-line">
                    <label>Phone:</label>
                    <input type="text" class="input-field" value="<%=patient.getPhone()%>" name="patient-phone">
                </div>
                <input type="hidden" value="<%=patient.getId()%>" name="patient-id">
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
