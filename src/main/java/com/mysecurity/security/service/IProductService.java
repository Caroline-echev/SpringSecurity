package com.mysecurity.security.service;

import com.mysecurity.security.persistence.entity.Product;
import com.mysecurity.security.persistence.util.ProductStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> getAll(Pageable pageable);
    Product getById(Long id);

    void save(Product product);

    Product update( Long id,Product product);

    Product changeStatus( Long id);
}
