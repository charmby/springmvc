package com.gsafety.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gsafety.dao.IPermissionRoleDao;
import com.gsafety.po.PermissionRole;
import com.gsafety.service.IPermissionRoleService;
@Service("permissionRoleService")
public class PermissionRoleServiceImpl implements  IPermissionRoleService{
	@Resource  
	private IPermissionRoleDao permissionRoleDao;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return permissionRoleDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(PermissionRole record) {
		// TODO Auto-generated method stub
		return permissionRoleDao.insert(record);
	}

	@Override
	public int insertSelective(PermissionRole record) {
		// TODO Auto-generated method stub
		return permissionRoleDao.insertSelective(record);
	}

	@Override
	public PermissionRole selectByPrimaryKey(Integer id) {
		return permissionRoleDao.selectByPrimaryKey(id);
	}

	@Override
	public List<PermissionRole> selectByRoleId(Integer roleId) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("roleId",roleId);
		return permissionRoleDao.selectByRoleId(map);
	}

	@Override
	public List<PermissionRole> selectByPermissionId(Integer permissionId) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("permissionId",permissionId);
		return permissionRoleDao.selectByPermissionId(map);
	}

	@Override
	public PermissionRole selectByPermissionIdAndRoleId(Integer permissionId,Integer roleId) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		return permissionRoleDao.selectByUserIdAndRoleId(map);
	}

	@Override
	public int updateByPrimaryKeySelective(PermissionRole record) {
		// TODO Auto-generated method stub
		return permissionRoleDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(PermissionRole record) {
		// TODO Auto-generated method stub
		return permissionRoleDao.updateByPrimaryKey(record);
	}

	@Override
	public List<PermissionRole> getAllPermissionRole() {
		// TODO Auto-generated method stub
		return permissionRoleDao.getAllPermissionRole();
	}

	

}  


