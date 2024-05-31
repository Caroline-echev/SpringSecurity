package com.mysecurity.security.controller;

import com.mysecurity.security.persistence.entity.Category;
import com.mysecurity.security.persistence.entity.Product;
import com.mysecurity.security.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryService categoryService;
    @GetMapping
    public ResponseEntity<Page<Category>> findAll(Pageable pageable) {

        Page<Category> categorys = categoryService.getAll(pageable);

        if(categorys.hasContent()) return ResponseEntity.ok(categorys);

        return ResponseEntity.notFound().build();

    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(Long id){

        Category category = categoryService.getById(id);

        return ResponseEntity.ok(category);

    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody  Category savecategory){
        categoryService.save(savecategory);
        return ResponseEntity.created(null).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id , @RequestBody  Category updatecategory){

        return ResponseEntity.created(null).body(categoryService.update(id, updatecategory));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Category> changeStatus(@PathVariable Long id){
        return ResponseEntity.created(null).body(categoryService.changeStatus(id));
    }


}
