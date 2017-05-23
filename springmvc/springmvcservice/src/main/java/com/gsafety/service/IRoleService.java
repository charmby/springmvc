package com.gsafety.service;

import com.gsafety.po.Role;

public interface IRoleService {  
	/**
	 * 根据id查询角色
	 * @param userId
	 * @return
	 */
	public Role getRoleById(int roleId);  


	
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
	public int insert(Role record);

	/**
	 * 新增角色
	 * @param record
	 * @return
	 */
	public int insertSelective(Role record);

	/**
	 * 根据角色名查询角色
	 * @param roleName
	 * @return
	 */
	public  Role selectByRoleName(String  roleName);
	
	/**
	 * 更新角色
	 * @param record
	 * @return
	 */
	public  int updateByPrimaryKeySelective(Role record);
	/**
	 * 更新角色
	 * @param record
	 * @return
	 */
	public  int updateByPrimaryKey(Role record);
}  


