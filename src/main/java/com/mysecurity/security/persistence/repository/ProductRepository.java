package com.mysecurity.security.persistence.repository;

import com.mysecurity.security.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
