package com.example.service.impl;


import com.example.domain.Cart;
import com.example.domain.OrderDetail;
import com.example.domain.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    ProductService productService;

    public Cart addItem(Long productId, Cart cart) {
        OrderDetail orderDetail = new OrderDetail();
        Product product = productService.getByID(productId);
        orderDetail.setProduct(product);
        orderDetail.setQuantity(1);
        cart.getItems().add(orderDetail);
        return cart;
    }

    public boolean findProduct(Long productId,Cart cart) {
        for(OrderDetail item : cart.getItems()){
            if(item.getProduct().getId()==productId){
                return true;
            }
        }
        return false;
    }

    public Cart updateQuantity(Long productId, int quantity, Cart cart) {
        OrderDetail orderDetail = cart.getItems().get(cart.getItems().indexOf(productService.getByID(productId)));
        orderDetail.setQuantity(orderDetail.getQuantity()+quantity);
        cart.getItems().set(cart.getItems().indexOf(productService.getByID(productId)),orderDetail);
        return cart;
    }
}
