package com.example.entity;

import com.example.domain.OrderDetail;
import com.example.domain.Product;
import com.example.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartEntity {
    @Autowired
    private ProductService productService;

    @Autowired
    private HttpSession httpSession;

    private List<OrderDetail> items;

    public CartEntity() {
        this.items = new ArrayList<>();
    }

    public List<OrderDetail> getItems() {
        return items;
    }

    public void addToCart(Long productId) {
        // Kiểm tra xem sản phẩm đã tồn tại trong giỏ hàng chưa
        for (OrderDetail item : items) {
            if (item.getProduct().getId().equals(productId)) {
                item.setQuantity(item.getQuantity() + 1);
                saveCartToSession();
                return;
            }
        }

        // Nếu sản phẩm chưa tồn tại trong giỏ hàng, thêm mới vào giỏ hàng
        OrderDetail orderDetail = new OrderDetail();
        Product product = productService.getByID(productId);
        orderDetail.setProduct(product);
        orderDetail.setQuantity(1);
        items.add(orderDetail);
        saveCartToSession();
    }

    public void updateQuantity(Long productId, int quantity) {
        for (OrderDetail item : items) {
            if (item.getProduct().getId().equals(productId)) {
                item.setQuantity(quantity);
                return;
            }
        }
    }

    public void delete(Long productId) {
        Iterator<OrderDetail> iterator = items.iterator();
        while (iterator.hasNext()) {
            OrderDetail item = iterator.next();
            if (item.getProduct().getId().equals(productId)) {
                iterator.remove();
                return;
            }
        }
    }

    public double getTotal() {
        return items.stream()
                .mapToDouble(orderDetail -> orderDetail.getProduct().getUnitPrice() * orderDetail.getQuantity())
                .sum();
    }

    public void emptyCart() {
        items = new ArrayList<>();
    }

    private void saveCartToSession() {
        httpSession.setAttribute("cart", this);
    }
}
