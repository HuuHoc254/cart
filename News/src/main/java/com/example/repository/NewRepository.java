package com.example.repository;

import com.example.entity.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewRepository extends JpaRepository<NewEntity,Integer> {
    List<NewEntity> findByTitleContainingOrSummaryContainingOrCategory_CateNameContaining(String keyword1, String keyword2, String keyword3);
}
