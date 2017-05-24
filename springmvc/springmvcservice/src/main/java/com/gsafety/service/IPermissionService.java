package com.gsafety.service;

import java.util.List;

import com.gsafety.po.Permission;

public interface IPermissionService {
	/**
	 * 根据id查询角色
	 * @param userId
	 * @return
	 */
	public Permission getPermissionById(int id);  


	
	/**
	 * 根据id删除角色
	 * @param id
	 * @return
	 */
	public  int deleteByPrimaryKey(Integer id);

	/**
	 * 新增角色
	 * @param record
	 * @return
	 */
	public int insert(Permission record);

	/**
	 * 新增角色
	 * @param record
	 * @return
	 */
	public int insertSelective(Permission record);

	/**
	 * 根据角色名查询角色
	 * @param roleName
	 * @return
	 */
	public  Permission selectByPermissionCode(String  pName);
	
	/**
	 * 更新角色
	 * @param record
	 * @return
	 */
	public  int updateByPrimaryKeySelective(Permission record);
	/**
	 * 更新角色
	 * @param record
	 * @return
	 */
	public  int updateByPrimaryKey(Permission record);
	/**
	 * 获得所有角色新
	 */
	
	public List<Permission> getAllPermission();
}
