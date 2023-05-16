package com.example.customers.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Customers {

    private String id;
    private String username;
    private int balance;

}
