package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class Employee {

    @Id
    private String id;
    private String name;
    private String email;
    private LocalDate birhtDate;

    public Employee() {
    }

    public Employee(String id, String name, String email, LocalDate birhtDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birhtDate = birhtDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirhtDate() {
        return birhtDate;
    }

    public void setBirhtDate(LocalDate birhtDate) {
        this.birhtDate = birhtDate;
    }
}
