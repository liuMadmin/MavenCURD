package com.javacto.util;

import com.javacto.po.Computer;
import com.javacto.po.Dog;
import com.javacto.po.Phone;
import com.javacto.po.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {

    private static Connection coon=null;
    private static PreparedStatement pstmt=null;
    private static ResultSet rs=null;

    public static int myExecuteUpdate(String sql,Object sbq[]){
        int num=0;
        try {
            coon = JDBCUtils.getConnection(JDBCUtils.getDataSource());
            pstmt = coon.prepareStatement(sql);
            for (int i=0;i<sbq.length;i++){
                pstmt.setObject(i+1,sbq[i]);
            }
            num = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.close(coon,pstmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return num;
    }

    public static List<Object> myExecuteQuery(String sql,Object sbq){
        List<Object> list = new ArrayList<Object>();
        try {
            coon = JDBCUtils.getConnection(JDBCUtils.getDataSource());
            pstmt = coon.prepareStatement(sql);
            if (null!=sbq){
                pstmt.setObject(1,sbq);
            }
            rs = pstmt.executeQuery();
            while (rs.next()){
                if (sql.contains("TUSER")){
                    User user = new User();
                    user.setId(rs.getInt(1));
                    user.setUserName(rs.getString(2));
                    user.setPwd(rs.getString(3));
                    user.setSex(rs.getInt(4));
                    user.setDate(rs.getDate(5));
                    user.setAddress(rs.getString(6));
                    list.add(user);
                } else if (sql.contains("Dog")){
                    Dog dog = new Dog();
                    dog.setId(rs.getInt(1));
                    dog.setdName(rs.getString(2));
                    dog.setHealth(rs.getInt(3));
                    dog.setStrain(rs.getString(4));
                    list.add(dog);
                } else if (sql.contains("Phone")){
                    Phone phone = new Phone();
                    phone.setId(rs.getInt(1));
                    phone.setpName(rs.getString(2));
                    phone.setColor(rs.getString(3));
                    phone.setMoney(rs.getDouble(4));
                    list.add(phone);
                } else if (sql.contains("Computer")){
                    Computer computer = new Computer();
                    computer.setId(rs.getInt(1));
                    computer.setcName(rs.getString(2));
                    computer.setColor(rs.getString(3));
                    computer.setMoney(rs.getDouble(4));
                    list.add(computer);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.close(coon,pstmt,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
