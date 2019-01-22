package com.jarvis.DAO;

import com.jarvis.model.Doctor;
import com.jarvis.utlis.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
    private static String tbName="doctor";

    public int save(Doctor doctor){
        int status=0;
        try{
            String sql="insert into "+tbName+" (name,password,sex,phone,introduction,keshi_id) values (?,?,?,?,?,?)";
            Connection conn=new ConnectDB().getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,doctor.getName());
            ps.setString(2,doctor.getPassword());
            ps.setString(3,doctor.getSex());
            ps.setString(4,doctor.getPhone());
            ps.setString(5,doctor.getIntroduction());
            ps.setInt(6,doctor.getKeShiId());
            status=ps.executeUpdate();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public int update(Doctor doctor ){
        int status=0;
        try{
            String sql="update "+tbName+" set name=?,password=?,sex=?,phone=?,introduction=?,keshi_id=? where id=?";
            Connection conn=new ConnectDB().getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,doctor.getName());
            ps.setString(2,doctor.getPassword());
            ps.setString(3,doctor.getSex());
            ps.setString(4,doctor.getPhone());
            ps.setString(5,doctor.getIntroduction());
            ps.setInt(6,doctor.getKeShiId());
            ps.setInt(7,doctor.getId());
            status=ps.executeUpdate();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public int delete(Doctor doctor){
        int status=0;
        try{
            String sql="delete from "+tbName+" where id=?";
            Connection conn=new ConnectDB().getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,doctor.getId());
            status=ps.executeUpdate();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public List<Doctor> getDoctorList(int keShiId){
        List<Doctor> list=new ArrayList<>();
        try{
            String sql="select * from "+tbName+" where keshi_id=?";
            Connection conn=new ConnectDB().getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,keShiId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Doctor doctor=new Doctor();
                doctor.setId(rs.getInt("id"));
                doctor.setName(rs.getString("name"));
                doctor.setPassword(rs.getString("password"));
                doctor.setSex(rs.getString("sex"));
                doctor.setPhone(rs.getString("phone"));
                doctor.setIntroduction(rs.getString("introduction"));
                doctor.setKeShiId(rs.getInt("keshi_id"));
                list.add(doctor);
            }
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }
}
