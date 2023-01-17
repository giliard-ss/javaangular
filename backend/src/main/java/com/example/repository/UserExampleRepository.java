package com.example.repository;

import com.example.model.UserExampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserExampleRepository extends JpaRepository<UserExampleEntity, Long> {

    Optional<UserExampleEntity> findByUsername(String username);
}
