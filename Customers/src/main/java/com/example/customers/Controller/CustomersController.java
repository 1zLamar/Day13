package com.example.customers.Controller;

import com.example.customers.Model.Customers;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("api/v1/bank")
public class CustomersController {

    ArrayList<Customers> banks= new ArrayList<>();

    //read
    @GetMapping("/get")
    public ArrayList<Customers> getCustomers(){
        return banks;
    }

    //create
    @PostMapping("/add")
    public String addCustomers(@RequestBody Customers customer){
        banks.add(customer);
        return "added";
    }

    //update

    @PutMapping("/update/{indx}")
    public String updateCustomers(@RequestBody Customers customer , @PathVariable int indx){
        banks.set(indx,customer);
        return "task updated";
    }
    //delete
    @DeleteMapping("/delete/{indx}")
    public String deleteCustomers(@PathVariable int indx){
        banks.remove(indx);
        return "task deleted";
    }

    @PutMapping("/deposit/{userName}/{balance}")
    public String deposit(@PathVariable String userName, @PathVariable int balance) {
        boolean check = false;

        for (Customers customer : banks) {
            if (customer.getUsername().equals(userName)) {
                check = true;
                customer.setBalance(customer.getBalance() + balance);
            }
        }
        if (check) {
            return "Deposit balance successfully" ;
        } else {
            return "cannot deposite";
        }
    }

    @PutMapping("/withdraw/{userName}/{balance}")
    public String withdraw(@PathVariable String userName, @PathVariable int balance) {
        for (Customers customer : banks) {
            if (customer.getUsername().equals(userName)) {
                if (customer.getBalance() >= balance) {
                    customer.setBalance(customer.getBalance() - balance);
                    return "Withdraw balance successfully";
                } else {
                    return "don't have balance enough";
                }
            }
        }
        return "no record for this username ";
    }

}
