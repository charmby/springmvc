package com.gsafety.service;

import java.util.List;

import com.gsafety.po.UserRole;

public interface IUserRoleService {  
	int deleteByPrimaryKey(Integer id);
	int insert(UserRole record);
	int insertSelective(UserRole record);
	UserRole selectByPrimaryKey(Integer id);
	List<UserRole> selectByRoleId(Integer roleId);
	List<UserRole> selectByUserId(Integer userId);
	UserRole selectByUserIdAndRoleId(Integer roleId,Integer userId);
	int updateByPrimaryKeySelective(UserRole record);
	int updateByPrimaryKey(UserRole record);
	List<UserRole> getAllUserRole();
}  


