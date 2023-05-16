package com.example.day13sol.Model;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Task {

    private String id;
    private String title;
    private String description;
    private String status;

}
