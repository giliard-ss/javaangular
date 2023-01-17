package com.example.repository;

import com.example.model.RoleExampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleExampleRepository extends JpaRepository<RoleExampleEntity, Long> {
}
