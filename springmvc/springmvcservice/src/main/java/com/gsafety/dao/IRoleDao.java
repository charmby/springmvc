package com.gsafety.dao;

import java.util.List;
import java.util.Map;

import com.gsafety.po.Role;

public interface IRoleDao {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);
    
    Role selectByRoleName(Map<String,String>  paramName);
    
    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
     List<Role> getAllRole() ;
    
}
