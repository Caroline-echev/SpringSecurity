package com.mysecurity.security.persistence.entity;

import com.mysecurity.security.persistence.util.ProductStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

;

@Entity
@Table(name = "categories")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;




}
