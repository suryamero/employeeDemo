package com.example.employeeDemo.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {
@Id
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    private String name;


    @Min(value = 18, message = "Age must be at least 18")
    private String age;

    private String id;

    // no-arg constructor required by Spring Data
    public Employee() {}

    public Employee(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Employee(String name, String age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    } public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
