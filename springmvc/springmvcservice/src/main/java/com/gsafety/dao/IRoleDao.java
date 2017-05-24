package com.gsafety.dao;

import java.util.List;

import com.gsafety.po.Role;

public interface IRoleDao {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);
    
    Role selectByRoleName(String  roleName);
    
    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
     List<Role> getAllRole() ;
    
}
