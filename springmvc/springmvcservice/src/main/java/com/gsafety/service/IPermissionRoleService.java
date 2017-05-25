package com.gsafety.service;

import java.util.List;

import com.gsafety.po.PermissionRole;

public interface IPermissionRoleService {  
	int deleteByPrimaryKey(Integer id);
	int insert(PermissionRole record);
	int insertSelective(PermissionRole record);

	PermissionRole selectByPrimaryKey(Integer id);
	int updateByPrimaryKeySelective(PermissionRole record);
	int updateByPrimaryKey(PermissionRole record);
	List<PermissionRole> getAllPermissionRole();
	List<PermissionRole> selectByRoleId(Integer roleId) ;
	List<PermissionRole> selectByPermissionId(Integer permissionId);
	PermissionRole selectByPermissionIdAndRoleId(Integer permissionId,Integer roleId) ;
}  


