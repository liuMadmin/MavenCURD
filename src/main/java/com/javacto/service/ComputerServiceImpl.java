package com.javacto.service;

import com.javacto.dao.ComputerDao;
import com.javacto.dao.ComputerDaoImpl;
import com.javacto.po.Computer;
import com.javacto.util.PageInfo;

import java.util.List;

public class ComputerServiceImpl implements ComputerService{

    ComputerDao computerDao = new ComputerDaoImpl();

    @Override
    public int addComputer(Computer computer) {
        return computerDao.addComputer(computer);
    }

    @Override
    public int deleteComputer(int id) {
        return computerDao.deleteComputer(id);
    }

    @Override
    public List<Object> queryComputerById(int id) {
        return computerDao.queryComputerById(id);
    }

    @Override
    public List<Object> queryComputerByName(String name) {
        return computerDao.queryComputerByName(name);
    }

    @Override
    public int updateComputer(Computer computer) {
        return computerDao.updateComputer(computer);
    }

    @Override
    public List<Object> queryAll() {
        return computerDao.queryAll();
    }

    @Override
    public int getTotalCount() {
        return computerDao.getTotalCount();
    }

    @Override
    public List<Computer> pageQueryComputer(PageInfo pageInfo) {
        return computerDao.pageQueryComputer(pageInfo);
    }
}
