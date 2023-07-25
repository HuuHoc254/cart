package com.example.converter;

import com.example.domain.Product;
import com.example.entity.ProductEntity;

public class ProductConverter {
    public static Product toModel(ProductEntity productEntity) {
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setProductName(productEntity.getProductName());
        product.setProductDescription(productEntity.getProductDescription());
        product.setUnitPrice(productEntity.getUnitPrice());
        return product;
    }

    public static ProductEntity toEntity(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(product.getId());
        productEntity.setProductName(product.getProductName());
        productEntity.setProductDescription(product.getProductDescription());
        productEntity.setUnitPrice(product.getUnitPrice());
        return productEntity;
    }
}
