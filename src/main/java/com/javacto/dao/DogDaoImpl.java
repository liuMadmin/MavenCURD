package com.javacto.dao;

import com.javacto.util.BaseDao;
import com.javacto.po.Dog;
import com.javacto.util.JDBCUtils;
import com.javacto.util.PageInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogDaoImpl implements DogDao{

    private Connection coon=null;
    private PreparedStatement pstmt=null;
    private ResultSet rs=null;

    @Override
    public int addDog(Dog dog) {
        String sql = "insert into Dog(dname,health,strain) values(?,?,?)";
        Object arr[] = {dog.getdName(),dog.getHealth(),dog.getStrain()};
        return BaseDao.myExecuteUpdate(sql,arr);
    }

    @Override
    public int deleteDog(int id) {
        String sql = "delete from Dog where id=?";
        Object arr[] = {id};
        return BaseDao.myExecuteUpdate(sql,arr);
    }

    @Override
    public int updateDog(Dog dog) {
        String sql = "update Dog set dname=?,health=?,strain=? where id=?";
        Object arr[] = {dog.getdName(),dog.getHealth(),dog.getStrain(),dog.getId()};
        return BaseDao.myExecuteUpdate(sql,arr);
    }

    @Override
    public List<Object> queryDogById(int id) {
        String sql = "SELECT * FROM Dog WHERE id=?";
        return BaseDao.myExecuteQuery(sql,id);
    }

    @Override
    public List<Object> queryDogByName(String name) {
        String sql = "SELECT * FROM Dog WHERE dname=?";
        return BaseDao.myExecuteQuery(sql,name);
    }


    @Override
    public List<Object> queryAll() {
        String sql = "SELECT * FROM Dog";
        return BaseDao.myExecuteQuery(sql,null);
    }

    @Override
    public int getTotalCount() {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM Dog";
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
    public List<Dog> pageQueryDog(PageInfo pageInfo) {
        List<Dog> list = new ArrayList<Dog>();
        String sql = "SELECT * FROM Dog LIMIT ?,?";

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
                Dog dog = new Dog();
                dog.setId(rs.getInt(1));
                dog.setdName(rs.getString(2));
                dog.setHealth(rs.getInt(3));
                dog.setStrain(rs.getString(4));
                list.add(dog);
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
