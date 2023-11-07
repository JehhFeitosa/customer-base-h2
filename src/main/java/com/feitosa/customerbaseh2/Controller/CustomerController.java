package com.feitosa.customerbaseh2.Controller;

import com.feitosa.customerbaseh2.model.Customer;
import com.feitosa.customerbaseh2.repositories.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path= "/customers")
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository){
        super();
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public ResponseEntity<Customer> save (@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAll(){
        List<Customer> customer = new ArrayList<>();
        customer = customerRepository.findAll();
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

}
