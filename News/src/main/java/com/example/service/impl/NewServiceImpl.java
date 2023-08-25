package com.example.service.impl;

import com.example.converter.NewConverter;
import com.example.entity.CategoryEntity;
import com.example.entity.NewEntity;
import com.example.entity.StaffEntity;
import com.example.model.New;
import com.example.repository.CategoryRepository;
import com.example.repository.NewRepository;
import com.example.repository.StaffRepository;
import com.example.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewServiceImpl implements NewService {

    @Autowired
    private NewRepository newRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private StaffRepository staffRepository;

    @Override
    public List<New> getAllNew() {
        return newRepository.findAll().stream().map(NewConverter::toModel).
                collect(Collectors.toList());
    }

    @Override
    public void create(New aNew) {
        NewEntity newEntity = convertertoEntity(aNew);
        newRepository.save(newEntity);
    }

    @Override
    public List<New> findByTitle(String key) {
        return newRepository.findByTitleContainingOrSummaryContainingOrCategory_CateNameContaining(key, key, key).stream().map(NewConverter::toModel).
                collect(Collectors.toList());
    }

    private NewEntity convertertoEntity(New aNew) {
        NewEntity newEntity = NewConverter.toEntity(aNew);
        CategoryEntity categoryEntity = categoryRepository.findById(aNew.getCategory().getCateId())
                .orElseThrow(() -> new RuntimeException("Khong tim thay category"));
        newEntity.setCategory(categoryEntity);
        StaffEntity staffEntity = staffRepository.findById(aNew.getStaff().getStaffId())
                .orElseThrow(() -> new RuntimeException("Khong tim thay Staff"));
        newEntity.setStaff(staffEntity);
        return newEntity;
    }
}
