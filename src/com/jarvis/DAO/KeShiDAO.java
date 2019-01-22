package com.jarvis.DAO;

import com.jarvis.model.KeShi;
import com.jarvis.utlis.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KeShiDAO {
    private static String tbName="keshi";
    public int save(KeShi keShi){
        int status=0;
        try{
            String sql="insert into "+tbName+" (name,price) values (?,?)";
            Connection conn=new ConnectDB().getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,keShi.getName());
            ps.setInt(2,keShi.getPrice());
            status=ps.executeUpdate();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public int update(KeShi keShi){
        int status=0;
        try {
            String sql="update "+tbName+" set name=?,price=? where id=?";
            Connection conn=new ConnectDB().getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,keShi.getName());
            ps.setInt(2,keShi.getPrice());
            ps.setInt(3,keShi.getId());
            status=ps.executeUpdate();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public int delete(KeShi keShi){
        int status=0;
        try{
            String sql="delete from "+tbName+" where id=?";
            Connection conn=new ConnectDB().getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,keShi.getId());
            status=ps.executeUpdate();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public List<KeShi> getKeShiList(){
        List<KeShi> list=new ArrayList<>();
        try{
            String sql=" select * from "+tbName;
            Connection conn=new ConnectDB().getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                KeShi keShi=new KeShi();
                keShi.setId(rs.getInt("id"));
                keShi.setName(rs.getString("name"));
                keShi.setPrice(rs.getInt("price"));
                list.add(keShi);
            }
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
