package com.mysecurity.security.controller;

import com.mysecurity.security.persistence.entity.Product;
import com.mysecurity.security.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;
    @GetMapping
    public ResponseEntity<Page<Product>> findAll(Pageable pageable) {

        Page<Product> products = productService.getAll(pageable);

        if(products.hasContent()) return ResponseEntity.ok(products);

        return ResponseEntity.notFound().build();

    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(Long id){

        Product product = productService.getById(id);

        return ResponseEntity.ok(product);

    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody  Product saveProduct){
        productService.save(saveProduct);
        return ResponseEntity.created(null).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id , @RequestBody  Product updateProduct){

        return ResponseEntity.created(null).body(productService.update(id, updateProduct));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Product> changeStatus(@PathVariable Long id){
        return ResponseEntity.created(null).body(productService.changeStatus(id));
    }

}
