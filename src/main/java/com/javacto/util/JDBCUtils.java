package com.javacto.util;
/*
* 属于model
* */
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource ds;

    static {
        try {
            Properties pro = new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("driud.properties");
            pro.load(is);

            ds = DruidDataSourceFactory.createDataSource(pro);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取数据库连接池
    public static DataSource getDataSource(){
        return ds;
    }

    //获取链接
    public static Connection getConnection(DataSource ds) throws SQLException {
        return ds.getConnection();
    }

    //归还连接
    public static void close(Connection coon, PreparedStatement pstmt, ResultSet rs) throws SQLException {
        if (rs!=null){
            rs.close();
        }
        if (pstmt!=null){
            pstmt.close();
        }
        if (coon!=null){
            coon.close();
        }
    }

    public static void close(Connection coon,PreparedStatement pstmt) throws SQLException {
        close(coon,pstmt,null);
    }
}
