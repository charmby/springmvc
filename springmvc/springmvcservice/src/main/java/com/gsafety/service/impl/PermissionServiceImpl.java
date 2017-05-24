package com.gsafety.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gsafety.dao.IPermissionDao;
import com.gsafety.po.Permission;
import com.gsafety.service.IPermissionService;

@Service("permissionService")  
public class PermissionServiceImpl implements IPermissionService {
	@Resource  
	private IPermissionDao permissionDao;
	@Override
	public Permission getPermissionById(int id) {
		return permissionDao.selectByPrimaryKey(id);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return permissionDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Permission record) {
		return permissionDao.insert(record);
	}

	@Override
	public int insertSelective(Permission record) {
		return permissionDao.insertSelective(record);
	}

	@Override
	public Permission selectByPermissionCode(String pName) {
		Map<String,String> map = new HashMap<String,String>();
		return permissionDao.selectByPermissionCode(map);
	}

	@Override
	public int updateByPrimaryKeySelective(Permission record) {
		return permissionDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Permission record) {
		return permissionDao.updateByPrimaryKey(record);
	}

	@Override
	public List<Permission> getAllPermission() {
		return permissionDao.getAllPermission();
	}

}
