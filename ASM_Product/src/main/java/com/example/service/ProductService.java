package com.example.service;

import com.example.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();

    Product getByID(Long productId);
}
