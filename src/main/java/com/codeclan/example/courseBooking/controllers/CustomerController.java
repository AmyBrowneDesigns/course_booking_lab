package com.codeclan.example.courseBooking.controllers;

import com.codeclan.example.courseBooking.models.Customer;
import com.codeclan.example.courseBooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value ="/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(@RequestParam(name= "courseId", required = false)Long courseId,
                                                          @RequestParam(name= "customerTown", required = false)String customerTown,
                                                          @RequestParam(name= "age", required = false) Integer age) {
        if(courseId !=null){
            return new ResponseEntity<>(customerRepository.findCustomersByBookingsCourseId(courseId), HttpStatus.OK);
        }
        if(customerTown !=null && courseId !=null){
            return new ResponseEntity<>(customerRepository.findAllByTownAndBookingsCourseId(customerTown, courseId), HttpStatus.OK);
        }
        if(age !=null && customerTown !=null && courseId !=null) {
            return new ResponseEntity<>(customerRepository.findAllByAgeGreaterThanAndTownAndBookingsCourseId(age, customerTown, courseId), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}
