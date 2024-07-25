package com.example.entity;

import jakarta.persistence.*;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private Set<Expense> expenses; // Relationship with Expense entity

    // Default constructor
    public Category() {}

    // Parameterized constructor
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters and Setters
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(Set<Expense> expenses) {
        this.expenses = expenses;
    }

    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", name=" + name + ", description=" + description + "]";
    }
}
