package com.jarvis.service;

import com.jarvis.DAO.*;
import com.jarvis.model.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;


@WebServlet(name = "AndroidServlet")
public class AndroidServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 解决中文乱码
        response.setCharacterEncoding("UTF-8");
        String method=request.getParameter("method");
        if(method.equals("login")){
            login(request,response);
        }else if(method.equals("register")){
            registerUser(request,response);
        }else if(method.equals("getDoctors")){
            getDoctors(request,response);
        }else if(method.equals("appoint")){
            appoint(request,response);
        }else if(method.equals("getSchedules")){
            getSchedules(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public void getSchedules(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("content-type","text/html;charset=UTF-8");
        int doctorId=Integer.parseInt(request.getParameter("doctorId"));
        ScheduleDAO scheduleDAO=new ScheduleDAO();
        List<Schedule> schedules=scheduleDAO.getScheduleList(doctorId);

        JSONArray jsonDoctors=new JSONArray();
        for(int i=0;i<schedules.size();i++){
            JSONObject jo=new JSONObject();
            jo.put("id",schedules.get(i).getId());
            jo.put("doctorId",schedules.get(i).getDr_id());
            jo.put("roomNum",schedules.get(i).getRoom_num());
            jo.put("doctorName",schedules.get(i).getDoctorName());
            jo.put("detailTime",schedules.get(i).getDetail_time());
            jsonDoctors.add(jo);
        }

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("scheduleList",jsonDoctors);

        try {
            OutputStream out=response.getOutputStream();
            out.write(jsonObject.toString().getBytes("UTF-8"));
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void appoint(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("content-type","text/html;charset=UTF-8");
        int patientId=Integer.parseInt(request.getParameter("patientId"));
        int keShiId=Integer.parseInt(request.getParameter("keShiId"));
        String keShiName=request.getParameter("keShiName");
        String doctorName=request.getParameter("doctorName");
        int doctorId=Integer.parseInt(request.getParameter("doctorId"));
        int roomNum=Integer.parseInt(request.getParameter("roomNum"));
        String time=request.getParameter("time");
        Register register=new Register();
        register.setPatient_id(patientId);
        register.setKeShi_id(keShiId);
        register.setKeshi_name(keShiName);
        register.setDr_id(doctorId);
        register.setDr_name(doctorName);
        register.setRoom_num(roomNum);
        register.setDetail_time(time);

        RegisterDAO registerDAO=new RegisterDAO();
        int status=registerDAO.save(register);



        if(status==1){
            String str="true";
            try {
                OutputStream out=response.getOutputStream();
                out.write(str.getBytes("UTF-8"));
                out.flush();
                out.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            String string="false";
            try {
                OutputStream out=response.getOutputStream();
                out.write(string.getBytes("UTF-8"));
                out.flush();
                out.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void getDoctors(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("content-type","text/html;charset=UTF-8");
        int keShiId=Integer.parseInt(request.getParameter("keShiId"));
        DoctorDAO doctorDAO=new DoctorDAO();
        List<Doctor> doctors=doctorDAO.getDoctorList(keShiId);

        JSONArray jsonDoctors=new JSONArray();
        for(int i=0;i<doctors.size();i++){
            JSONObject jo=new JSONObject();
            jo.put("id",doctors.get(i).getId());
            jo.put("name",doctors.get(i).getName());
            jo.put("sex",doctors.get(i).getSex());
            jo.put("phone",doctors.get(i).getPhone());
            jo.put("intro",doctors.get(i).getIntroduction());
            jo.put("keShiId",doctors.get(i).getKeShiId());
            jsonDoctors.add(jo);
        }

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("doctorsList",jsonDoctors);

        try {
            OutputStream out=response.getOutputStream();
            out.write(jsonObject.toString().getBytes("UTF-8"));
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void registerUser(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("content-type","text/html;charset=UTF-8");
        String patientName=request.getParameter("patientName");
        String password=request.getParameter("password");
        int age=Integer.parseInt(request.getParameter("age"));
        String sex=request.getParameter("sex");
        String address=request.getParameter("address");
        String phone=request.getParameter("phone");
        Patient patient=new Patient();
        patient.setName(patientName);
        patient.setPassword(password);
        patient.setAge(age);
        patient.setSex(sex);
        patient.setAddr(address);
        patient.setPhone(phone);
        PatientDAO patientDAO=new PatientDAO();
        int status=patientDAO.save(patient);
        if(status==1){
            String str="true";
            try {
                OutputStream out=response.getOutputStream();
                out.write(str.getBytes("UTF-8"));
                out.flush();
                out.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            String string="false";
            try {
                OutputStream out=response.getOutputStream();
                out.write(string.getBytes("UTF-8"));
                out.flush();
                out.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void login(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("content-type","text/html;charset=UTF-8");
        String patientName=request.getParameter("patientName");
        String password=request.getParameter("password");
        Patient patient=null;
        boolean flag=false;
        PatientDAO patientDAO=new PatientDAO();
        List<Patient> list=patientDAO.getPatientList();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getName().equals(patientName)&&list.get(i).getPassword().equals(password)){
                patient=list.get(i);
                flag=true;
                break;
            }
        }
        if(!flag){
            //登录失败
            try {
                OutputStream out=response.getOutputStream();
                out.write(Boolean.toString(flag).getBytes("UTF-8"));
                out.flush();
                out.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            KeShiDAO keShiDAO=new KeShiDAO();
            List<KeShi> keShis=keShiDAO.getKeShiList();

            RegisterDAO registerDAO=new RegisterDAO();
            List<Register> registers=registerDAO.getRegisterList(patient.getId());

            JSONArray jsonKeShi=new JSONArray();
            for(int i=0;i<keShis.size();i++){
                JSONObject jo=new JSONObject();
                jo.put("id",keShis.get(i).getId());
                jo.put("name",keShis.get(i).getName());
                jo.put("price",keShis.get(i).getPrice());
                jsonKeShi.add(jo);
            }

            JSONArray jsonRegister=new JSONArray();
            for(int i=0;i<registers.size();i++){
                JSONObject jo=new JSONObject();
                jo.put("id",registers.get(i).getId());
                jo.put("patient_id",registers.get(i).getPatient_id());
                jo.put("keshi_id",registers.get(i).getKeShi_id());
                jo.put("keshi_name",registers.get(i).getKeshi_name());
                jo.put("dr_name",registers.get(i).getDr_name().trim());
                jo.put("dr_id",registers.get(i).getDr_id());
                jo.put("room_num",registers.get(i).getRoom_num());
                jo.put("detail_time",registers.get(i).getDetail_time());
                jsonRegister.add(jo);
            }

            JSONObject joPatient=new JSONObject();
            joPatient.put("id",patient.getId());
            joPatient.put("name",patient.getName());
            joPatient.put("age",patient.getAge());
            joPatient.put("address",patient.getAddr());
            joPatient.put("phone",patient.getPhone());
            joPatient.put("password",patient.getPassword());
            joPatient.put("sex",patient.getSex());

            JSONObject json=new JSONObject();
            json.put("patient",joPatient);
            json.put("keShiList",jsonKeShi);
            json.put("registerList",jsonRegister);
            try {
                OutputStream out=response.getOutputStream();
                out.write(json.toString().getBytes("UTF-8"));
                out.flush();
                out.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
