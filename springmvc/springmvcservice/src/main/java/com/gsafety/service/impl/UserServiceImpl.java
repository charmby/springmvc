package com.gsafety.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public User getUserByUserNameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.selectByUserNameAndPassword(username, password);
	}
	@Override
	public User selectByUserNameAndPasswordwhere(String userName, String password) {
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("userName",userName);
		paramMap.put("password",password);
		return userDao.selectByUserNameAndPasswordwhere(paramMap);
	}
	@Override
	public User selectByUserNameAndPasswordByParam(String userName, String password) {
		return userDao.selectByUserNameAndPasswordByParam(userName,password);
	}
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userDao.deleteByPrimaryKey(id);
	}
	@Override
	public int insert(User record) {
		// TODO Auto-generated method stub
		return userDao.insert(record);
	}
	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return userDao.insertSelective(record);
	}
	@Override
	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return userDao.selectByUserName(userName);
	}
	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return userDao.updateByPrimaryKeySelective(record);
	}
	@Override
	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return userDao.updateByPrimaryKey(record);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}  
}  
