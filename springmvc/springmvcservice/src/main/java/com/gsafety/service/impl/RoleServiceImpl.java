package com.gsafety.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gsafety.dao.IRoleDao;
import com.gsafety.po.Role;
import com.gsafety.service.IRoleService;

@Service("roleService")  
public class RoleServiceImpl implements IRoleService {  
    @Resource  
    private IRoleDao roleDao;

	@Override
	public Role getRoleById(int roleId) {
		// TODO Auto-generated method stub
		return roleDao.selectByPrimaryKey(roleId);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return roleDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Role record) {
		// TODO Auto-generated method stub
		return roleDao.insert(record);
	}

	@Override
	public int insertSelective(Role record) {
		// TODO Auto-generated method stub
		return roleDao.insertSelective(record);
	}

	@Override
	public Role selectByRoleName(String roleName) {
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("roleName",roleName);
		return roleDao.selectByRoleName(paramMap);
	}

	@Override
	public int updateByPrimaryKeySelective(Role record) {
		// TODO Auto-generated method stub
		return roleDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Role record) {
		// TODO Auto-generated method stub
		return roleDao.updateByPrimaryKey(record);
	}

	@Override
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		return roleDao.getAllRole();
	}  
  
}  
