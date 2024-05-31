package com.mysecurity.security.service;

import com.mysecurity.security.persistence.entity.Category;
import com.mysecurity.security.persistence.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
    Page<Category> getAll(Pageable pageable);
    Category getById(Long id);

    void save(Category Category);

    Category update( Long id,Category Category);


    Category changeStatus(Long id);
}
