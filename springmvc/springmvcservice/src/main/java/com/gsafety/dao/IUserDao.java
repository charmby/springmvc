package com.gsafety.dao;

import com.gsafety.po.User;

public interface IUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    
    User selectByUserName(String  userName);
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}