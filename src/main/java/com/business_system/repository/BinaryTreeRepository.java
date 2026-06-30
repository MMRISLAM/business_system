package com.business_system.repository;

import com.business_system.model.BinaryTree;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BinaryTreeRepository extends JpaRepository<BinaryTree, Long> {

    Optional<BinaryTree> findByUserId(Long userId);

    List<BinaryTree> findByParentId(Long parentId);
}
