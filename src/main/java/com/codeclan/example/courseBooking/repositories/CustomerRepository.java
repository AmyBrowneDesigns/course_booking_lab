package com.codeclan.example.courseBooking.repositories;

import com.codeclan.example.courseBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
