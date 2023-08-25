package com.example.service.impl;

import com.example.converter.NewConverter;
import com.example.converter.StaffConverter;
import com.example.model.Staff;
import com.example.repository.StaffRepository;
import com.example.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffRepository staffRepository;

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll().stream().map(StaffConverter::toModel).
                collect(Collectors.toList());
    }
}
