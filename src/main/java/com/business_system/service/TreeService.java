package com.business_system.service;

import com.business_system.model.BinaryTree;
import com.business_system.repository.BinaryTreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeService {

    @Autowired
    private BinaryTreeRepository repo;

    // ✅ ADD USER (AUTO LEVEL + POSITION)
    public BinaryTree addUser(Long userId, Long parentId, String position) {

        BinaryTree node = new BinaryTree();
        node.setUserId(userId);
        node.setParentId(parentId);
        node.setPosition(position);

        node.setStatus("ACTIVE");

        return repo.save(node);
    }

    // ✅ DIRECT CHILD
    public List<BinaryTree> getDirectTree(Long parentId) {
        return repo.findByParentId(parentId);
    }

    // ✅ FULL TREE (LIMIT 15 USERS)
    public List<BinaryTree> getTree(Long parentId) {
        List<BinaryTree> list = repo.findByParentId(parentId);
        return list.size() > 15 ? list.subList(0, 15) : list;
    }
}
