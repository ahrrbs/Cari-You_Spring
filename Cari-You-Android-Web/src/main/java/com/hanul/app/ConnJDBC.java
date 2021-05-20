package com.hanul.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnJDBC {
   private Connection conn;
   private PreparedStatement pmst;
   private ResultSet rs;
   
   public Connection getConn() {
      String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
      String user = "android";
      String password = "0000";
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn = DriverManager.getConnection(url,user,password);
      }catch (Exception e) {
      }
      return conn;
   }
   
   public void dbClose() {
      try {
         if(rs != null)rs.close();
         if(pmst != null)pmst.close();
         if(conn != null)conn.close();
      }catch (Exception e) {
         // TODO: handle exception
      }
   }
   public ResultSet conntest()   {
      conn = getConn();
      
      String sql = "select 1 num from dual";
      try {
         pmst = conn.prepareStatement(sql);
         rs = pmst.executeQuery();
         while(rs.next()) {
            System.out.println(rs.getInt("num"));
         }
      }catch (Exception e) {
         System.out.println("Error DB Conn");
      }
      return rs;
      
   }
}