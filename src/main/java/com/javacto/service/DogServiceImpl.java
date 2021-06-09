package com.javacto.service;

import com.javacto.dao.DogDao;
import com.javacto.dao.DogDaoImpl;
import com.javacto.po.Dog;
import com.javacto.util.PageInfo;

import java.util.List;

/*
* DogService的实现类
* */
public class DogServiceImpl implements DogService{

    DogDao dogDao = new DogDaoImpl();

    @Override
    public int addDog(Dog dog) {
        return dogDao.addDog(dog);
    }

    @Override
    public int deleteDog(int id) {
        return dogDao.deleteDog(id);
    }

    @Override
    public List<Object> queryDogById(int id) {
        return dogDao.queryDogById(id);
    }

    @Override
    public List<Object> queryDogByName(String name) {
        return dogDao.queryDogByName(name);
    }

    @Override
    public int updateDog(Dog dog) {
        return dogDao.updateDog(dog);
    }

    @Override
    public List<Object> queryAll() {
        return dogDao.queryAll();
    }

    @Override
    public int getTotalCount() {
        return dogDao.getTotalCount();
    }

    @Override
    public List<Dog> pageQueryDog(PageInfo pageInfo) {
        return dogDao.pageQueryDog(pageInfo);
    }
}
