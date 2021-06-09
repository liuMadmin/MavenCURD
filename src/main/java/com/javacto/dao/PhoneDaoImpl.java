package com.javacto.dao;

import com.javacto.util.BaseDao;
import com.javacto.util.JDBCUtils;
import com.javacto.po.Phone;
import com.javacto.util.PageInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDaoImpl implements PhoneDao{

    Connection coon=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;

    @Override
    public int addPhone(Phone phone) {
        String sql = "insert into Phone(pname,color,money) values(?,?,?)";
        Object arr[] = {phone.getpName(),phone.getColor(),phone.getMoney()};
        return BaseDao.myExecuteUpdate(sql,arr);
    }

    @Override
    public int deletePhone(int id) {
        String sql = "delete from Phone where id=?";
        Object arr[] = {id};
        return BaseDao.myExecuteUpdate(sql,arr);
    }


    @Override
    public int updatephone(Phone phone) {
        String sql = "update Phone set pname=?,color=?,money=? where id=?";
        Object arr[] = {phone.getpName(),phone.getColor(),phone.getMoney(),phone.getId()};
        return BaseDao.myExecuteUpdate(sql,arr);
    }

    @Override
    public List<Object> queryPhoneById(int id) {
        String sql = "SELECT * FROM Phone WHERE id=?";
        return BaseDao.myExecuteQuery(sql,id);
    }

    @Override
    public List<Object> queryPhoneByName(String name) {
        String sql = "SELECT * FROM Phone WHERE pname=?";
        return BaseDao.myExecuteQuery(sql,name);
    }

    @Override
    public List<Object> queryAll() {
        String sql = "SELECT * FROM Phone ";
        return BaseDao.myExecuteQuery(sql,null);
    }

    @Override
    public int getTotalCount() {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM Phone";
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
    public List<Phone> pageQueryPhone(PageInfo pageInfo) {
        List<Phone> list = new ArrayList<Phone>();
        String sql = "SELECT * FROM Phone LIMIT ?,?";

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
                Phone phone = new Phone();
                phone.setId(rs.getInt(1));
                phone.setpName(rs.getString(2));
                phone.setColor(rs.getString(3));
                phone.setMoney(rs.getDouble(4));
                list.add(phone);
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
