package com.gsafety.dao;

import java.util.List;
import java.util.Map;

import com.gsafety.po.Permission;



public interface IPermissionDao {
	int deleteByPrimaryKey(Integer id);

	int insert(Permission record);

	int insertSelective(Permission record);

	Permission selectByPrimaryKey(Integer id);

	Permission selectByPermissionCode(Map<String, String> paramMap);
	
	int updateByPrimaryKeySelective(Permission record);

	int updateByPrimaryKey(Permission record);
	
	List<Permission> getAllPermission();
}