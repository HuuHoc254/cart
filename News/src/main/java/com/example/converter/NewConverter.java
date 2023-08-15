package com.example.converter;

import com.example.entity.NewEntity;
import com.example.model.New;

import java.time.LocalDate;

public class NewConverter {
    public static New toModel(NewEntity newEntity) {
        New anew = new New();
        anew.setNewId(newEntity.getNewId());
        anew.setTitle(newEntity.getTitle());
        anew.setSummary(newEntity.getSummary());
        anew.setContents(newEntity.getContents());
        anew.setCreatedDate(newEntity.getCreateDate());
        anew.setCategory(newEntity.getCategory());
        anew.setStaff(newEntity.getStaff());
        return anew;
    }

    public static NewEntity toEntity(New aNew) {
        NewEntity entity = new NewEntity();
        entity.setContents(aNew.getContents());
        entity.setSummary(aNew.getSummary());
        entity.setTitle(aNew.getTitle());
        entity.setCreateDate(LocalDate.now());
        return entity;
    }
}
