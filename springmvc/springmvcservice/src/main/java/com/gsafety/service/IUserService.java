package com.gsafety.service;

import com.gsafety.po.User;

public interface IUserService {  
	/**
	 * 根据id查询用户
	 * @param userId
	 * @return
	 */
	public User getUserById(int userId);  


	/**
	 * 根据用户名和密码查询用户
	 * @param username
	 * @return
	 */
	public User getUserByUserNameAndPassword(String username,String password);
	
	/**
	 * 根据id删除用户
	 * @param id
	 * @return
	 */
	public  int deleteByPrimaryKey(Integer id);

	/**
	 * 新增用户
	 * @param record
	 * @return
	 */
	public int insert(User record);

	/**
	 * 新增用户
	 * @param record
	 * @return
	 */
	public int insertSelective(User record);

	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	public  User getUserByUserName(String  userName);
	
	/**
	 * 更新用户
	 * @param record
	 * @return
	 */
	public  int updateByPrimaryKeySelective(User record);
	/**
	 * 更新用户
	 * @param record
	 * @return
	 */
	public  int updateByPrimaryKey(User record);
}  


