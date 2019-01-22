package com.jarvis.DAO;

import com.jarvis.model.Register;
import com.jarvis.utlis.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegisterDAO {
    private static String tbName="register";
    public int save(Register register){
        int status=0;
        try{
            String sql="insert into "+tbName+" (patient_id,keshi_id,keshi_name,dr_name,dr_id,room_num,detail_time) values (?,?,?,?,?,?,?)";
            Connection conn=new ConnectDB().getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,register.getPatient_id());
            ps.setInt(2,register.getKeShi_id());
            ps.setString(3,register.getKeshi_name());
            ps.setString(4,register.getDr_name());
            ps.setInt(5,register.getDr_id());
            ps.setInt(6,register.getRoom_num());
            ps.setString(7,register.getDetail_time());
            status=ps.executeUpdate();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public int update(Register register){
        int status=0;
        try{
            String sql="update "+tbName+" set patient_id=?,keshi_id=?,keshi_name=?,dr_name=?,dr_id=?,room_num=?,detail_time=? where id=?";
            Connection conn=new ConnectDB().getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,register.getPatient_id());
            ps.setInt(2,register.getKeShi_id());
            ps.setString(3,register.getKeshi_name());
            ps.setString(4,register.getDr_name());
            ps.setInt(5,register.getDr_id());
            ps.setInt(6,register.getRoom_num());
            ps.setString(7,register.getDetail_time());
            ps.setInt(8,register.getId());
            status=ps.executeUpdate();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public int delete(int id){
        int status=0;
        try{
            String sql="delete from "+tbName+" where id=?";
            Connection conn=new ConnectDB().getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,id);
            status=ps.executeUpdate();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public List<Register> getRegisterList(int patientId){
        List<Register> list=new ArrayList<>();
        try{
            String sql="select * from "+tbName+" where patient_id=?";
            Connection conn=new ConnectDB().getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,patientId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Register register=new Register();
                register.setId(rs.getInt("id"));
                register.setPatient_id(rs.getInt("patient_id"));
                register.setKeShi_id(rs.getInt("keshi_id"));
                register.setKeshi_name(rs.getString("keshi_name"));
                register.setDr_name(rs.getString("dr_name"));
                register.setDr_id(rs.getInt("dr_id"));
                register.setRoom_num(rs.getInt("room_num"));
                register.setDetail_time(rs.getString("detail_time"));
                list.add(register);
            }
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
