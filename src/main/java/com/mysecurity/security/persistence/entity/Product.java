package com.mysecurity.security.persistence.entity;

import com.mysecurity.security.persistence.util.ProductStatus;
import jakarta.persistence.*;
import lombok.Data;
;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;
}
