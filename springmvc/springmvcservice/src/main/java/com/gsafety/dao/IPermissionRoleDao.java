package com.gsafety.dao;

import java.util.List;
import java.util.Map;

import com.gsafety.po.PermissionRole;

public interface IPermissionRoleDao {
	int deleteByPrimaryKey(Integer id);
	int insert(PermissionRole record);
	int insertSelective(PermissionRole record);

	PermissionRole selectByPrimaryKey(Integer id);

	List<PermissionRole> selectByRoleId(Map<String, Integer> paramMap);
	List<PermissionRole> selectByPermissionId(Map<String, Integer> paramMap);
	PermissionRole selectByUserIdAndRoleId(Map<String, Integer> paramMap);
	int updateByPrimaryKeySelective(PermissionRole record);
	int updateByPrimaryKey(PermissionRole record);
	List<PermissionRole> getAllPermissionRole();
}
