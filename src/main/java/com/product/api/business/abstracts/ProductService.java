package com.product.api.business.abstracts;

import com.product.api.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    List<Product> find();
    Product create (Product product);
    Product update (Long id, int quantity);
    void delete(Long id);
}
