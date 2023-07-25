package com.example.service.impl;

import com.example.converter.ProductConverter;
import com.example.domain.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll().
                stream().map(ProductConverter::toModel).
                collect(Collectors.toList());
    }

    @Override
    public Product getByID(Long productId) {
        return ProductConverter.toModel(productRepository.findById(productId).get());
    }
}
