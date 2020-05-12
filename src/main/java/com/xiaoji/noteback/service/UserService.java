package com.xiaoji.noteback.service;

import com.xiaoji.noteback.dao.UserDAO;
import com.xiaoji.noteback.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public User getUserByUsername(String username){
        return userDAO.findByUsername(username);
    }
}
