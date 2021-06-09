package com.javacto.dao;

import com.javacto.po.Computer;
import com.javacto.po.Phone;
import com.javacto.util.PageInfo;

import java.util.List;

public interface PhoneDao {
    /*
     * 添加
     * */
    public int addPhone(Phone phone);

    /*
     * 根据id删除
     * */
    public int deletePhone(int id);

    /*
     * 根据id查询
     * */
    public List<Object> queryPhoneById(int id);

    /*
     * 根据name查询
     * */
    public List<Object> queryPhoneByName(String name);

    /*
     * 修改
     * */
    public int updatephone(Phone phone);

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
    public List<Phone> pageQueryPhone(PageInfo pageInfo);
}
