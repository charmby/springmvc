package com.gsafety.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.gsafety.po.User;

public interface IUserDao {
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	User selectByUserName(@Param("userName")String userName);
	User selectByUserNameAndPassword(String userName,String password);
	User selectByUserNameAndPasswordByParam(@Param("userName")String userName,@Param("password") String password);
	User selectByUserNameAndPasswordwhere(Map<String, String> paramMap);
	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
	List<User> getAllUser();
}