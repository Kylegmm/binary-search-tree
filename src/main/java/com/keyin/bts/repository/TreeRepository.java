// src/main/java/com/example/bst/repository/TreeRepository.java
package com.keyin.bts.repository;

import com.keyin.bts.entity.TreeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepository extends JpaRepository<TreeEntity, Long> {
}
