package com.gsafety.service;

import com.gsafety.po.User;

public interface IUserService {  
    public User getUserById(int userId);  
    
    public User getUserByUserName(String username);
    
}  


