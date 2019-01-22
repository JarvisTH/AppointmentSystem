<%@ page import="com.jarvis.DAO.KeShiDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jarvis.model.KeShi" %>
<%@ page import="com.jarvis.DAO.RegisterDAO" %>
<%@ page import="com.jarvis.model.Register" %>
<%@ page import="com.jarvis.DAO.PatientDAO" %>
<%@ page import="com.jarvis.model.Patient" %>
<%--
  Created by IntelliJ IDEA.
  User: Jarvis
  Date: 2019/1/13
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/manage.css">
    <title>医疗预约系统</title>
</head>
<body>
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
<div class="container">
    <div class="header">
        <div class="title">
            医疗预约系统
        </div>
    </div>
    <div class="main">
        <div class="sidebar">
            <a href="#" class="sidebar-button" id="person-btn">我的预约</a>
            <a href="#" class="sidebar-button" id="project-btn">预约挂号</a>
            <a href="#" class="sidebar-button" id="skill-btn">个人资料</a>
        </div>
        <div class="content">
            <%
                RegisterDAO registerDAO=new RegisterDAO();
                List<Register> registers=registerDAO.getRegisterList(index);
            %>
            <div class="detail page-person" id="page-person">
                <table border="1" cellspacing="10">
                    <tr>
                        <th>科室</th>
                        <th>医师</th>
                        <th>房间号</th>
                        <th>日期</th>
                    </tr>
                    <%for(int i=0;i<registers.size();i++){%>
                    <tr>
                        <td><%=registers.get(i).getKeshi_name()%></td>
                        <td><%=registers.get(i).getDr_name()%></td>
                        <td><%=registers.get(i).getRoom_num()%></td>
                        <td><%=registers.get(i).getDetail_time()%></td>
                        <td><a href="deleteRegister.jsp?registerId=<%=registers.get(i).getId()%>&patientId=<%=registers.get(i).getPatient_id()%>&keShiId=<%=registers.get(i).getKeShi_id()%>&keShiName=<%=registers.get(i).getKeshi_name()%>
                        &doctorId=<%=registers.get(i).getDr_id()%>&doctorName=<%=registers.get(i).getDr_name()%>
                        &roomNum=<%=registers.get(i).getRoom_num()%>&time=<%=registers.get(i).getDetail_time()%>" >Delete</a></td>
                    </tr>
                    <%}%>
                </table>
            </div>
            <%
                KeShiDAO keShiDAO=new KeShiDAO();
                List<KeShi> list=keShiDAO.getKeShiList();
            %>
            <div class="detail page-project" id="page-project">
                科目列表：
                <%for(int i=0;i<list.size();i++){%>
                    <div class="info-part">
                        科目：<a href="drList.jsp?patientId=<%=index%>&keShiId=<%=list.get(i).getId()%>&keShiName=<%=list.get(i).getName()%>" ><%=list.get(i).getName()%></a>
                    </div>
                <%}%>
            </div>
            <div class="detail page-skill" id="page-skill">
                <div class="info-part">
                   姓名：<%=patient.getName()%>
                </div>
                <div class="info-part">
                    性别：<%=patient.getSex()%>
                </div>
                <div class="info-part">
                    年龄：<%=patient.getAge()%>
                </div>
                <div class="info-part">
                    地址：<%=patient.getAddr()%>
                </div>
                <div class="info-part">
                    电话：<%=patient.getPhone()%>
                </div>
                <div class="space">
                    <a href="modifyPersonalData.jsp?patientId=<%=patient.getId()%>" class="btn">modify</a>
                </div>
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
<script src="js/sidebar.js"></script>
</body>
</html>