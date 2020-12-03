package com.codeclan.example.courseBooking.repositories;

import com.codeclan.example.courseBooking.models.Booking;
import com.codeclan.example.courseBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findCustomersByBookingsCourseId(Long id);
    List<Customer> findAllByTownAndBookingsCourseId(String town, Long id);

}
