package com.library.config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCBlobTest
{

    public static void main(String[] args)
    {
        String sqlStr="update manager set user_photo=?;";
        Connection con=null;
        PreparedStatement pstm=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/library","root","");
            pstm=con.prepareStatement(sqlStr);
            InputStream input=JDBCBlobTest.class.getResourceAsStream("3e43372c1d3dee2a.jpg");
            byte[] bytes=new byte[input.available()];
            input.read(bytes);
            pstm.setBytes(1, bytes);
            int i=pstm.executeUpdate();
            System.out.println(i);
            input.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                pstm.close();
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
