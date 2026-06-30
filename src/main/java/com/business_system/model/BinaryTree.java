package com.business_system.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "binary_tree")
public class BinaryTree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long parentId;

    private String position; // LEFT / RIGHT

    private int level;
    private String username;
    private String status; // ACTIVE / EMPTY
}
