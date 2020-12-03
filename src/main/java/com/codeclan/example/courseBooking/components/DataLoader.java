package com.codeclan.example.courseBooking.components;

import com.codeclan.example.courseBooking.models.Booking;
import com.codeclan.example.courseBooking.models.Course;
import com.codeclan.example.courseBooking.models.Customer;
import com.codeclan.example.courseBooking.repositories.BookingRepository;
import com.codeclan.example.courseBooking.repositories.CourseRepository;
import com.codeclan.example.courseBooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements ApplicationRunner {


    @Autowired
    CourseRepository courseRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){}

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Course

        Course course1 = new Course("Dark spells", "HogsMeade", 3);
        courseRepository.save(course1);
        Course course2 = new Course("Herbology", "Greenhouses", 4);
        courseRepository.save(course2);

        //Customer

        Customer customer1 = new Customer("Harry Potter", "London", 13);
        customerRepository.save(customer1);
        Customer customer2 = new Customer("Hermione", "Kent", 14);
        customerRepository.save(customer2);


        //Booking

        Booking booking1 = new Booking("25-12-20", customer1, course2);
        bookingRepository.save(booking1);
        Booking booking2 = new Booking("12-01-21", customer2, course1);
        bookingRepository.save(booking2);

    }


}
