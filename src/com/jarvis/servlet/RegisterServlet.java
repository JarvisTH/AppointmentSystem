package com.jarvis.servlet;

import com.jarvis.DAO.RegisterDAO;
import com.jarvis.model.Register;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method=req.getParameter("method");
        if(method.equals("add")){
            add(req,resp);
        }else if(method.equals("delete")){
            delete(req,resp);
        }
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        int patientId=Integer.parseInt(req.getParameter("patient-id"));
        int id=Integer.parseInt(req.getParameter("register-id"));
        int status=new RegisterDAO().delete(id);
        if(status==1){
            resp.sendRedirect(req.getContextPath()+"/homepage.jsp?patientId="+patientId);
        }else {
            resp.sendRedirect(req.getContextPath()+"/error.html");
        }
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("utf-8");
        int patientId=Integer.parseInt(req.getParameter("patientid"));
        int keShiId=Integer.parseInt(req.getParameter("keshiid"));
        String keShiName=req.getParameter("keshiname");
        String doctorName=req.getParameter("doctorname");
        int doctorId=Integer.parseInt(req.getParameter("doctorid"));
        int roomNum=Integer.parseInt(req.getParameter("roomnum"));
        String time=req.getParameter("time");
        Register register=new Register();
        register.setPatient_id(patientId);
        register.setKeShi_id(keShiId);
        register.setKeshi_name(keShiName);
        register.setDr_name(doctorName);
        register.setDr_id(doctorId);
        register.setRoom_num(roomNum);
        register.setDetail_time(time);
        RegisterDAO registerDAO=new RegisterDAO();
        int status=registerDAO.save(register);
        if(status==1){
            resp.sendRedirect(req.getContextPath()+"/homepage.jsp?patientId="+patientId);
        }else {
            resp.sendRedirect(req.getContextPath()+"/error.html");
        }
    }
}
