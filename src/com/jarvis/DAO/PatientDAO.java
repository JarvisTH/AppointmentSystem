package com.jarvis.DAO;

import com.jarvis.model.Patient;
import com.jarvis.utlis.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    private static String tbName="patient";
    public int save(Patient patient){
        int status=0;
        try{
            String sql="insert into "+tbName+" (name,password,age,sex,address,phone) values (?,?,?,?,?,?)";
            Connection conn=new ConnectDB().getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,patient.getName());
            ps.setString(2,patient.getPassword());
            ps.setInt(3,patient.getAge());
            ps.setString(4,patient.getSex());
            ps.setString(5,patient.getAddr());
            ps.setString(6,patient.getPhone());
            status=ps.executeUpdate();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public int update(Patient patient){
        int status=0;
        try{
            String sql=" update "+tbName+" set name=?,password=?,age=?,sex=?,address=?,phone=? where id=?";
            Connection conn=new ConnectDB().getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,patient.getName());
            ps.setString(2,patient.getPassword());
            ps.setInt(3,patient.getAge());
            ps.setString(4,patient.getSex());
            ps.setString(5,patient.getAddr());
            ps.setString(6,patient.getPhone());
            ps.setInt(7,patient.getId());
            status=ps.executeUpdate();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public int delete(Patient patient){
        int status=0;
        try{
            String sql="delete from "+tbName+" where id=?";
            Connection conn=new ConnectDB().getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,patient.getId());
            status=ps.executeUpdate();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public List<Patient> getPatientList(){
        List<Patient> list=new ArrayList<>();
        try{
            String sql="select * from "+tbName;
            Connection conn=new ConnectDB().getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Patient patient=new Patient();
                patient.setId(rs.getInt("id"));
                patient.setName(rs.getString("name"));
                patient.setPassword(rs.getString("password"));
                patient.setSex(rs.getString("sex"));
                patient.setAge(rs.getInt("age"));
                patient.setAddr(rs.getString("address"));
                patient.setPhone(rs.getString("phone"));
                list.add(patient);
            }
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
