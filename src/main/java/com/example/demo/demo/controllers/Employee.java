package com.example.demo.demo.controllers;


import lombok.AllArgsConstructor;
import lombok.Data;
 import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
     private Long id;
     private String name;
    private String email;
    private String department;

    

}
