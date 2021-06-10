package com.javacto.dao;

import com.javacto.po.User;
import com.javacto.util.BaseDao;
import com.javacto.util.JDBCUtils;
import com.javacto.util.PageInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDaoImpl implements UserDao{

    private Connection coon=null;
    private PreparedStatement pstmt=null;
    private ResultSet rs=null;

    @Override
    public int addUser(User user) {
        String sql = "INSERT INTO TUSER(t_name,t_password,t_sex,t_date,t_address,t_state) VALUES(?,?,?,NOW(),?,0)";
        Object arr[] = {user.getUserName(),user.getPwd(),user.getSex(),user.getAddress()};
        return BaseDao.myExecuteUpdate(sql,arr);
    }

    @Override
    public int deleteUser(int id) {
        String sql = "DELETE FROM TUSER WHERE t_id=?";
        Object arr[] = {id};
        return BaseDao.myExecuteUpdate(sql,arr);
    }

    @Override
    public int updateUser(User user) {
        String sql = "UPDATE TUSER SET t_name=?,t_password=?,t_sex=?,t_address=? WHERE  t_id=?";
        Object arr[] = {user.getUserName(),user.getPwd(),user.getSex(),user.getAddress(),user.getId()};
        return BaseDao.myExecuteUpdate(sql,arr);
    }

    @Override
    public List<Object> queryUserByID(int id) {
        String sql = "SELECT * FROM TUSER WHERE t_id=?";
        return BaseDao.myExecuteQuery(sql,id);
    }

    @Override
    public User queryUserByName(String userName) {
        User user = null;
        String sql = "SELECT * FROM TUSER WHERE t_name = ?";
        try {
            coon = JDBCUtils.getDataSource().getConnection();
            pstmt = coon.prepareStatement(sql);
            pstmt.setString(1,userName);
            rs = pstmt.executeQuery();
            while (rs.next()){
                user = new User();
                user.setId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setPwd(rs.getString(3));
                user.setSex(rs.getInt(4));
                user.setDate(rs.getDate(5));
                user.setAddress(rs.getString(6));
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
        return user;
    }

    @Override
    public List<Object> queryAll() {
        String sql = "SELECT * FROM TUSER";
        return BaseDao.myExecuteQuery(sql,null);
    }

    @Override
    public HashMap<String,String> queryUserNP() {
        String sql = "SELECT t_name,t_password FROM TUSER";
        HashMap<String,String> hashMap = new HashMap<String,String>();

        try {
            coon = JDBCUtils.getDataSource().getConnection();
            pstmt = coon.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                hashMap.put(rs.getString(1),rs.getString(2));
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

        return hashMap;
    }

    @Override
    public List<Object> queryAll2() {
        List<Object> list = new ArrayList<Object>();
        String sql = "SELECT * FROM TUSER";

        try {
            coon = JDBCUtils.getDataSource().getConnection();
            pstmt = coon.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                HashMap<String,Object> hashMap = new HashMap<String,Object>();
                hashMap.put("id",rs.getInt(1));
                hashMap.put("name",rs.getString(2));
                hashMap.put("password",rs.getString(3));
                hashMap.put("sex",rs.getInt(4));
                hashMap.put("birthday",rs.getDate(5));
                hashMap.put("address",rs.getString(6));
                list.add(hashMap);
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
        return  list;
    }

    @Override
    public int getTotalCount() {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM TUSER";
        try {
            coon = JDBCUtils.getDataSource().getConnection();
            pstmt = coon.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                count = rs.getInt(1);
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

        return count;
    }


    @Override
    public List<User> pageQueryUser(PageInfo pageInfo) {
        List<User> list = new ArrayList<User>();
        String sql = "SELECT * FROM TUSER LIMIT ?,?";

        int pageNo = pageInfo.getPageNo();
        int pageSize = pageInfo.getPageSize();
        int begin = (pageNo-1)*pageSize;

        try {
            coon = JDBCUtils.getDataSource().getConnection();
            pstmt = coon.prepareStatement(sql);
            pstmt.setInt(1,begin);
            pstmt.setInt(2,pageSize);
            rs = pstmt.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setPwd(rs.getString(3));
                user.setSex(rs.getInt(4));
                user.setDate(rs.getDate(5));
                user.setAddress(rs.getString(6));
                list.add(user);
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
