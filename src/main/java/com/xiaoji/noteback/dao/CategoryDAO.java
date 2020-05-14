package com.xiaoji.noteback.dao;

import com.xiaoji.noteback.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category,Integer> {
}
