package com.product.api.business.concretes;

import com.product.api.business.abstracts.ProductService;
import com.product.api.dataAccess.ProductRepository;
import com.product.api.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> find() {
        return productRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, int quantity) {
        return productRepository.findById(id)
                .map(existingProduct ->{
                    existingProduct.setQuantitiy(quantity);
                    return productRepository.save(existingProduct);
                })
                .orElse(null);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
