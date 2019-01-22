package com.jarvis.DAO;

import com.jarvis.model.Schedule;
import com.jarvis.utlis.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO {
    private static String tbName="schedule_";
    public int save(Schedule schedule){
        int status=0;
        try{
            String sql="insert into "+tbName+" (dr_id,room_num,doctor_name,detail_time) values (?,?,?,?)";
            Connection conn=new ConnectDB().getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,schedule.getDr_id());
            ps.setInt(2,schedule.getRoom_num());
            ps.setString(3,schedule.getDoctorName());
            ps.setString(4,schedule.getDetail_time());
            status=ps.executeUpdate();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public int update(Schedule schedule){
        int status=0;
        try{
            String sql="update "+tbName+" set dr_id=?,room_num=?,dortor_name=?,detail_time=? where id=?";
            Connection conn=new ConnectDB().getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,schedule.getDr_id());
            ps.setInt(2,schedule.getRoom_num());
            ps.setString(3,schedule.getDoctorName());
            ps.setString(4,schedule.getDetail_time());
            ps.setInt(4,schedule.getId());
            status=ps.executeUpdate();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public int delete(Schedule schedule){
        int status=0;
        try{
            String sql="delete from "+tbName+" where id=?";
            Connection conn=new ConnectDB().getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,schedule.getId());
            status=ps.executeUpdate();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public List<Schedule> getScheduleList(int doctorId){
        List<Schedule> list=new ArrayList<>();
        try{
            String sql="select * from "+tbName+" where dr_id=?";
            Connection conn=new ConnectDB().getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,doctorId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Schedule schedule=new Schedule();
                schedule.setId(rs.getInt("id"));
                schedule.setDr_id(rs.getInt("dr_id"));
                schedule.setDoctorName(rs.getString("doctor_name"));
                schedule.setRoom_num(rs.getInt("room_num"));
                schedule.setDetail_time(rs.getString("detail_time"));
                list.add(schedule);
            }
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
