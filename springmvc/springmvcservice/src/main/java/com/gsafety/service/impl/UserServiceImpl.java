package com.gsafety.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gsafety.dao.IUserDao;
import com.gsafety.po.User;
import com.gsafety.service.IUserService;

@Service("userService")  
public class UserServiceImpl implements IUserService {  
    @Resource  
    private IUserDao userDao;  
    @Override  
    public User getUserById(int userId) {  
        return this.userDao.selectByPrimaryKey(userId);  
    }
	@Override
	public User getUserByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}  
}  
