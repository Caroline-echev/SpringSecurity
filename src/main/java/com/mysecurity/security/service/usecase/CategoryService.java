package com.mysecurity.security.service.usecase;

import com.mysecurity.security.exception.CategoryNotFoundException;
import com.mysecurity.security.persistence.entity.Category;
import com.mysecurity.security.persistence.repository.CategoryRepository;
import com.mysecurity.security.persistence.util.ProductStatus;
import com.mysecurity.security.service.ICategoryService;
import com.mysecurity.security.service.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepository CategoryRepository;
    @Override
    public Page<Category> getAll(Pageable pageable) {
        return CategoryRepository.findAll(pageable);
    }

    @Override
    public Category getById(Long id) {
        return CategoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(Constants.CATEGORY_NOT_FOUND));
    }

    @Override
    public void save(Category Category) {
        CategoryRepository.save(Category);
    }

    @Override
    public Category update(Long id, Category newCategory) {
        Category oldCategory = getById(id);
        oldCategory.setName(newCategory.getName());
        oldCategory.setStatus(newCategory.getStatus());
        save(oldCategory);
        return oldCategory;
    }

    @Override
    public Category changeStatus(Long id) {
        Category oldCategory = getById(id);
        if(oldCategory.getStatus() == ProductStatus.ENABLED){
            oldCategory.setStatus(ProductStatus.DISABLED);
        }else{
            oldCategory.setStatus(ProductStatus.ENABLED);
        }
        save(oldCategory);
        return oldCategory;
    }


}
