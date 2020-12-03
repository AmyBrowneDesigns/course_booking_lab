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
        Course course3 = new Course("Advanced Potions", "Hogwarts", 5);
        courseRepository.save(course3);
        Course course4 = new Course("Care of magical creatures", "Forbidden Forest", 2);
        courseRepository.save(course4);

        //Customer

        Customer customer1 = new Customer("Harry Potter", "London", 13);
        customerRepository.save(customer1);
        Customer customer2 = new Customer("Hermione Grainger", "Kent", 14);
        customerRepository.save(customer2);
        Customer customer3 = new Customer("Ron Weasley", "Swansea", 13);
        customerRepository.save(customer3);
        Customer customer4 = new Customer("Draco Malfoy", "Hull", 14);
        customerRepository.save(customer4);


        //Booking

        Booking booking1 = new Booking("25-12-20", customer1, course2);
        bookingRepository.save(booking1);
        Booking booking2 = new Booking("12-01-21", customer2, course1);
        bookingRepository.save(booking2);
        Booking booking3 = new Booking("12-01-21", customer3, course4);
        bookingRepository.save(booking3);
        Booking booking4 = new Booking("10-08-22", customer4, course3);
        bookingRepository.save(booking4);
    }


}
