package com.comurg.redesoljob.repository;

import com.comurg.redesoljob.model.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleRepository extends JpaRepository<Example, String> {
}
