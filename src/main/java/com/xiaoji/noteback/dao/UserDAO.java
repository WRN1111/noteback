package com.xiaoji.noteback.dao;

import com.xiaoji.noteback.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
