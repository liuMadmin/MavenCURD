package com.javacto.dao;

import com.javacto.po.Dog;
import com.javacto.po.User;
import com.javacto.util.PageInfo;

import java.util.List;

/*
* dao层   持久层   封装了对数据库数据的操作
* */
public interface DogDao {
    /*
    * 添加
    * */
    public int addDog(Dog dog);

    /*
     * 根据id删除
     * */
    public int deleteDog(int id);

    /*
     * 根据id查询
     * */
    public List<Object> queryDogById(int id);

    /*
     * 根据name查询
     * */
    public List<Object> queryDogByName(String name);

    /*
     * 修改
     * */
    public int updateDog(Dog dog);

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
    public List<Dog> pageQueryDog(PageInfo pageInfo);
}
