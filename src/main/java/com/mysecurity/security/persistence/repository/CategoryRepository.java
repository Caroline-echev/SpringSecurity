package com.mysecurity.security.persistence.repository;

import com.mysecurity.security.persistence.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
