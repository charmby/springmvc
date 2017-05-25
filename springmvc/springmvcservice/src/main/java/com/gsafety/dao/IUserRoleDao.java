package com.gsafety.dao;

import java.util.List;
import java.util.Map;

import com.gsafety.po.UserRole;

public interface IUserRoleDao {
	int deleteByPrimaryKey(Integer id);
	int insert(UserRole record);

	int insertSelective(UserRole record);

	UserRole selectByPrimaryKey(Integer id);

	List<UserRole> selectByRoleId(Map<String, Integer> paramMap);
	List<UserRole> selectByUserId(Map<String, Integer> paramMap);
	UserRole selectByUserIdAndRoleId(Map<String, Integer> paramMap);
	int updateByPrimaryKeySelective(UserRole record);
	int updateByPrimaryKey(UserRole record);
	List<UserRole> getAllUserRole();
}
