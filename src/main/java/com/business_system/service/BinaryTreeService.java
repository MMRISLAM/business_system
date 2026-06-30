package com.business_system.service;

import com.business_system.model.BinaryTree;
import com.business_system.repository.BinaryTreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BinaryTreeService {

    @Autowired
    private BinaryTreeRepository repo;

    // ✅ AUTO PLACE (LEFT → RIGHT → SPILLOVER)
    public BinaryTree autoPlace(Long userId, Long parentId) {

        List<BinaryTree> children = repo.findByParentId(parentId);

        String position = "LEFT";

        for (BinaryTree node : children) {
            if ("LEFT".equals(node.getPosition())) {
                position = "RIGHT";
            }
        }

        // if both full → spillover logic (go deeper)
        if (children.size() >= 2) {
            BinaryTree nextParent = children.get(0);
            return autoPlace(userId, nextParent.getUserId());
        }

        BinaryTree node = new BinaryTree();
        node.setUserId(userId);
        node.setParentId(parentId);
        node.setPosition(position);

        return repo.save(node);
    }

    public List<BinaryTree> getChildren(Long parentId) {
        return repo.findByParentId(parentId);
    }
}
