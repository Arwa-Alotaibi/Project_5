package com.example.project_5.Controller;


import com.example.project_5.Model.Customer;
import com.example.project_5.Service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @GetMapping("/all")
    public ResponseEntity GetAll(){
        List<Customer> customerList =customerService.GetAll();
        return ResponseEntity.status(200).body(customerList);
    }

    @PostMapping("/add")
    public ResponseEntity AddCustomer(@Valid @RequestBody Customer customer){
        customerService.AddCustomer(customer);
        return ResponseEntity.status(200).body("customer added! :) ");
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity UpdateCustomer(@PathVariable Integer id,@Valid @RequestBody Customer customer){
        customerService.UpdateCustomer(id,customer);
        return ResponseEntity.status(200).body("customer updated! :) ");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity DeleteCustomer(@PathVariable Integer id){
        customerService.DeleteCustomer(id);
        return ResponseEntity.status(200).body("customer deleted! :) ");
    }

    @PutMapping("/cutomer/{customer_id}/store/{store_id}")
    public ResponseEntity Assign(@PathVariable Integer customer_id, @PathVariable Integer store_id){
        customerService.AssignCustomerToStore(customer_id, store_id);
        return ResponseEntity.status(200).body("assign  successfully! :) ");
    }
   // Create endpoint thar takes storeid and return all customers

    @GetMapping("/all/cutomers/{store_id}")
    public ResponseEntity ReturnAllCustomer(@PathVariable Integer store_id){
        List<Customer> customer =customerService.ReturnAllCustomer(store_id);
        return ResponseEntity.status(200).body(customer);


    }


}
