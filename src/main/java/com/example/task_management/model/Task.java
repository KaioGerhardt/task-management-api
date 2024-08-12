
package com.example.task_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Task {
    
    @Id
    private Long id;
    private String title;
    private String description;

    // Getters e setters
}