package com.mysecurity.security.service.usecase;

import com.mysecurity.security.exception.ProductNotFoundException;
import com.mysecurity.security.persistence.entity.Product;
import com.mysecurity.security.persistence.repository.ProductRepository;
import com.mysecurity.security.persistence.util.ProductStatus;
import com.mysecurity.security.service.IProductService;
import com.mysecurity.security.service.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(Constants.PRODUCT_NOT_FOUND));
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }



    @Override
    public Product update(Long id, Product newProduct) {
        Product oldProduct = getById(id);
        oldProduct.setName(newProduct.getName());
        oldProduct.setPrice(newProduct.getPrice());
        oldProduct.setStatus(newProduct.getStatus());
        save(oldProduct);
        return oldProduct;
    }

    @Override
    public Product changeStatus(Long id) {
        Product oldProduct = getById(id);
        if(oldProduct.getStatus() == ProductStatus.ENABLED){
            oldProduct.setStatus(ProductStatus.DISABLED);
        }else{
            oldProduct.setStatus(ProductStatus.ENABLED);
        }
        save(oldProduct);
        return oldProduct;
    }


}
