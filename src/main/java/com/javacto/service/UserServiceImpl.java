package com.javacto.service;

import com.javacto.dao.UserDao;
import com.javacto.dao.UserDaoImpl;
import com.javacto.po.User;
import com.javacto.util.PageInfo;

import java.util.HashMap;
import java.util.List;

public class UserServiceImpl implements UserService{

    UserDao userDao= new UserDaoImpl();

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }

    @Override
    public List<Object> queryUserById(int id) {
        return  userDao.queryUserByID(id);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public List<Object> queryAll() {
        return userDao.queryAll();
    }

    @Override
    public List<Object> queryAll2() {
        return userDao.queryAll2();
    }

    @Override
    public int getTotalCount() {
        return userDao.getTotalCount();
    }

    @Override
    public HashMap<String, String> queryUserNP() {
        return userDao.queryUserNP();
    }

    @Override
    public List<User> pageQueryUser(PageInfo pageInfo) {
        return userDao.pageQueryUser(pageInfo);
    }
}
