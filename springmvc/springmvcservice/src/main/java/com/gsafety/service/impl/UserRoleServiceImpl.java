package com.gsafety.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gsafety.dao.IUserRoleDao;
import com.gsafety.po.UserRole;
import com.gsafety.service.IUserRoleService;
@Service("userRoleService")
public class UserRoleServiceImpl implements IUserRoleService {

    @Resource
	IUserRoleDao userRoleDao;
    
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userRoleDao.deleteByPrimaryKey(id);
	}
	
	@Override
	public int insert(UserRole record) {
		// TODO Auto-generated method stub
		return userRoleDao.insert(record);
	}

	@Override
	public int insertSelective(UserRole record) {
		// TODO Auto-generated method stub
		return userRoleDao.insertSelective(record);
	}

	@Override
	public UserRole selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userRoleDao.selectByPrimaryKey(id);
	}

	@Override
	public List<UserRole> selectByRoleId(Integer roleId) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("roleId",roleId);
		return userRoleDao.selectByRoleId(map);
	}

	@Override
	public List<UserRole> selectByUserId(Integer userId) {
		// TODO Auto-generated method stub
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("userId",userId);
		return userRoleDao.selectByUserId(map);
	}

	@Override
	public UserRole selectByUserIdAndRoleId(Integer roleId, Integer userId) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("roleId",roleId);
		map.put("userId",userId);
		return userRoleDao.selectByUserIdAndRoleId(map);
	}

	@Override
	public int updateByPrimaryKeySelective(UserRole record) {
		// TODO Auto-generated method stub
		return userRoleDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(UserRole record) {
		// TODO Auto-generated method stub
		return userRoleDao.updateByPrimaryKey(record);
	}

	@Override
	public List<UserRole> getAllUserRole() {
		// TODO Auto-generated method stub
		return userRoleDao.getAllUserRole();
	}



	
}  


