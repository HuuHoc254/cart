package com.example.domain;

import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<OrderDetail> items ;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<OrderDetail> getItems() {
        return items;
    }



}
