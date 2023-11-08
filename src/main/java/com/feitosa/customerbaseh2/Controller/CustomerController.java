package com.feitosa.customerbaseh2.Controller;

import com.feitosa.customerbaseh2.model.Customer;
import com.feitosa.customerbaseh2.repositories.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

    @GetMapping(path="/{customer_id}")
    public ResponseEntity<Optional<Customer>> getById(@PathVariable Long customer_id){
        Optional<Customer> customer;
        try{
            customer = customerRepository.findById(customer_id);
            return new ResponseEntity<Optional<Customer>>(customer, HttpStatus.OK);
        } catch(NoSuchElementException nsee){
            return new ResponseEntity<Optional<Customer>>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path="/{customer_id}")
    public ResponseEntity<Optional<Customer>> deleteById(@PathVariable Long customer_id){
        try {
            customerRepository.deleteById(customer_id);
            return new ResponseEntity<Optional<Customer>>(HttpStatus.OK);
        } catch (NoSuchElementException nsee){
            return new ResponseEntity<Optional<Customer>>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{customer_id}")
    public ResponseEntity<Customer> update(@PathVariable Long customer_id, @RequestBody Customer newCustomer){
        return customerRepository.findById(customer_id)
                .map(customer -> {
                    customer.setNameCustomer(newCustomer.getNameCustomer());
                    Customer customerUpdated = customerRepository.save(customer);
                    return ResponseEntity.ok().body(customerUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }



}
