package com.example.service;

import com.example.model.New;

import java.util.List;

public interface NewService {
    List<New> getAllNew();

    void create(New aNew);

    List<New> findByTitle(String title);
}
