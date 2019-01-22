package com.jarvis.servlet;

import com.jarvis.DAO.PatientDAO;
import com.jarvis.model.Patient;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class WebLoginServlet extends HttpServlet {
        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            req.setCharacterEncoding("utf-8");
            String method=req.getParameter("method");
            if(method.equals("login")){
                login(req,resp);
            }else if(method.equals("add")){
                add(req,resp);
            }else if(method.equals("modify")){
                modify(req,resp);
            }
        }

    public void modify(HttpServletRequest req,HttpServletResponse resp)throws IOException{
            req.setCharacterEncoding("utf-8");
            int patientId=Integer.parseInt(req.getParameter("patient-id"));
            Patient patient=null;
            PatientDAO patientDAO=new PatientDAO();
            List<Patient> list=patientDAO.getPatientList();
            for(int i=0;i<list.size();i++){
                if(list.get(i).getId()==patientId){
                    patient=list.get(i);
                }
            }
            patient.setName(req.getParameter("patient-name"));
            patient.setAddr(req.getParameter("patient-addr"));
            patient.setSex(req.getParameter("patient-sex"));
            patient.setAge(Integer.parseInt(req.getParameter("patient-age")));
            patient.setPhone(req.getParameter("patient-phone"));
            patient.setPassword(req.getParameter("patient-password"));
            int status=patientDAO.update(patient);
            if(status==1){
                resp.sendRedirect(req.getContextPath()+"/homepage.jsp?patientId="+patientId);
            }else {
                resp.sendRedirect(req.getContextPath()+"/error.html");
            }
        }

    public void login(HttpServletRequest req,HttpServletResponse resp)throws IOException{
            int index=-1;
            req.setCharacterEncoding("utf-8");
            String username=req.getParameter("account");
            String password=req.getParameter("password");
            if(username==null || password==null ){
                try {
                    resp.sendRedirect(req.getContextPath()+"/error.html");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else{
                try{
                    PatientDAO patientDAO=new PatientDAO();
                    List<Patient> list=null;
                    list=patientDAO.getPatientList();
                    for(int i=0;i<list.size();i++){
                        if(list.get(i).getName().equals(username)&&list.get(i).getPassword().equals(password)){
                            index=list.get(i).getId();
                            break;
                        }
                    }
                    if(index==-1){
                        try{
                            resp.sendRedirect(req.getContextPath()+"/error.html");
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }else {
                        try{
                            resp.sendRedirect(req.getContextPath()+"/homepage.jsp?patientId="+index);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

    protected void add(HttpServletRequest req,HttpServletResponse resp)throws IOException{
        req.setCharacterEncoding("utf-8");
        Patient patient=new Patient();
        patient.setName(req.getParameter("name"));
        patient.setAddr(req.getParameter("address"));
        patient.setSex(req.getParameter("sex"));
        patient.setAge(Integer.parseInt(req.getParameter("age")));
        patient.setPhone(req.getParameter("phone"));
        patient.setPassword(req.getParameter("password"));
        int status=new PatientDAO().save(patient);
        if(status==1){
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
        }else {
            resp.sendRedirect(req.getContextPath()+"/error.html");
        }
    }

}
