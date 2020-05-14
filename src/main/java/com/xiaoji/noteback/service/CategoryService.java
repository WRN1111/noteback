package com.xiaoji.noteback.service;


import com.xiaoji.noteback.dao.CategoryDAO;
import com.xiaoji.noteback.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    public List<Category> getAll(){
        return categoryDAO.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }
}
