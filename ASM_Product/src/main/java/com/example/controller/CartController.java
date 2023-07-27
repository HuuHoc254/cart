package com.example.controller;

import com.example.converter.OrderConverter;
import com.example.converter.OrderDetailConverter;
import com.example.domain.Order;
import com.example.entity.CartEntity;
import com.example.entity.OrderDetailEntity;
import com.example.entity.OrderEntity;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RequestMapping("cart")
@Controller
public class CartController {

    @Autowired
    private CartEntity cart;

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String showCart(Model model) {
        model.addAttribute("cartItems", cart.getItems());
        model.addAttribute("total", cart.getTotal());
        return "cart/listCart";
    }

    @GetMapping("/addToCart")
    public String addToCart(@RequestParam("id") Long productId,Model model) {
        cart.addToCart(productId);
        return "redirect:/products";
    }

    @GetMapping("/update-quantity")
    public String updateQuantity(@RequestParam("id") Long productId, @RequestParam("quantity") int quantity) {
        cart.updateQuantity(productId, quantity);
        return "redirect:/cart";
    }

    @GetMapping("/delete")
    public String deleteItem(@RequestParam("id") Long productId) {
        cart.delete(productId);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String showForm(Model model) {
        Order order = new Order();
        model.addAttribute("Order",order);
        return "cart/checkout";
    }

    @PostMapping("/checkout")
    public String checkOut(Model model, @ModelAttribute Order order) {
        order.setDate(LocalDate.now());
        OrderEntity orderEntity = OrderConverter.toEntity(order);
        orderService.saveOrder(orderEntity, OrderDetailConverter.toEntity(cart.getItems()));
        return "redirect:/cart/empty";
    }

    @GetMapping("/empty")
    public String empty(Model model, @ModelAttribute Order order){
        cart.emptyCart();
        return "redirect:/cart";
    }
}
