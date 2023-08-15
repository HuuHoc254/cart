package com.example.converter;

import com.example.entity.StaffEntity;
import com.example.model.Staff;

public class StaffConverter {
    public static Staff toModel(StaffEntity staffEntity) {
        Staff staff = new Staff();
        staff.setStaffId(staffEntity.getStaffId());
        staff.setStaffName(staffEntity.getStaffName());
        staff.setStaffAddress(staffEntity.getStaffAddress());
        staff.setEmail(staffEntity.getEmail());
        staff.setPhone(staffEntity.getPhone());
        return staff;
    }
}
