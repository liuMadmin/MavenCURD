package com.javacto.dao;

import com.javacto.util.BaseDao;
import com.javacto.po.Computer;
import com.javacto.util.JDBCUtils;
import com.javacto.util.PageInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComputerDaoImpl implements ComputerDao {

    Connection coon=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;

    @Override
    public int addComputer(Computer computer) {
        String sql = "insert into Computer(cname,color,money) values(?,?,?)";
        Object arr[] = {computer.getcName(),computer.getColor(),computer.getMoney()};
        return BaseDao.myExecuteUpdate(sql,arr);
    }

    @Override
    public int deleteComputer(int id) {
        String sql = "delete from Computer where id=?";
        Object arr[] = {id};
        return BaseDao.myExecuteUpdate(sql,arr);
    }

    @Override
    public int updateComputer(Computer computer) {
        String sql = "update Computer set cname=?,color=?,money=? where id=?";
        Object arr[] = {computer.getcName(),computer.getColor(),computer.getMoney(),computer.getId()};
        return BaseDao.myExecuteUpdate(sql,arr);
    }

    @Override
    public List<Object> queryComputerById(int id) {
        String sql = "SELECT * FROM Computer WHERE id=?";
        return BaseDao.myExecuteQuery(sql,id);
    }

    @Override
    public List<Object> queryComputerByName(String name) {
        String sql = "SELECT * FROM Computer WHERE cname=?";
        return BaseDao.myExecuteQuery(sql,name);
    }

    @Override
    public List<Object> queryAll() {
        String sql = "SELECT * FROM Computer ";
        return BaseDao.myExecuteQuery(sql,null);
    }

    @Override
    public int getTotalCount() {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM Computer";
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
    public List<Computer> pageQueryComputer(PageInfo pageInfo) {
        List<Computer> list = new ArrayList<Computer>();
        String sql = "SELECT * FROM Computer LIMIT ?,?";

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
                Computer computer = new Computer();
                computer.setId(rs.getInt(1));
                computer.setcName(rs.getString(2));
                computer.setColor(rs.getString(3));
                computer.setMoney(rs.getDouble(4));
                list.add(computer);
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
