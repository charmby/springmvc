package com.gsafety.shiro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsafety.shiro.po.UrlFilter;
import com.gsafety.shiro.service.UrlFilterService;

@Service  
public class UrlFilterServiceImpl implements UrlFilterService {

	@Override
	public UrlFilter createUrlFilter(UrlFilter urlFilter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UrlFilter updateUrlFilter(UrlFilter urlFilter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUrlFilter(Long urlFilterId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UrlFilter findOne(Long urlFilterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UrlFilter> findAll() {
		// TODO Auto-generated method stub
		return null;
	}  
 /*   @Autowired  
private ShiroFilerChainManager shiroFilerChainManager;  
  
    @Override  
    public UrlFilter createUrlFilter(UrlFilter urlFilter) {  
        urlFilterDao.createUrlFilter(urlFilter);  
        initFilterChain();  
        return urlFilter;  
    }  
    //其他方法请参考源码  
    @PostConstruct  
    public void initFilterChain() {  
        shiroFilerChainManager.initFilterChains(findAll());  
    }  */
}   