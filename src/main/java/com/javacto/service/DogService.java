package com.javacto.service;

import com.javacto.po.Dog;
import com.javacto.util.PageInfo;

import java.util.List;

/*
* 业务层     调用dao层的方法
* */
public interface DogService {

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
