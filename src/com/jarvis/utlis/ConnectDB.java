package com.jarvis.utlis;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    public Connection getConnection(){
        Connection conn=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest?useSSL=false&character=urf8&serverTimezone=GMT%2B8&autoReconnect=true",
                    "root","TangHui123#");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("数据库连接失败！");
        }
        return conn;
    }
}
