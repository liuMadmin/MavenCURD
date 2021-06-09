package com.javacto.dao;

import com.javacto.po.Computer;
import com.javacto.po.Dog;
import com.javacto.util.PageInfo;

import java.util.List;

public interface ComputerDao {
    /*
     * 添加
     * */
    public int addComputer(Computer computer);

    /*
     * 根据id删除
     * */
    public int deleteComputer(int id);

    /*
     * 根据id查询
     * */
    public List<Object> queryComputerById(int id);

    /*
     * 根据name查询
     * */
    public List<Object> queryComputerByName(String name);

    /*
     * 修改
     * */
    public int updateComputer(Computer computer);

    /*
     * 查询所有
     * */
    public List<Object> queryAll();

    /*
     * 获取总条数据
     * */
    public int getTotalCount();

    /*
     * 分页查询
     * */
    public List<Computer> pageQueryComputer(PageInfo pageInfo);

}
