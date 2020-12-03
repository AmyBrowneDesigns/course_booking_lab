package com.codeclan.example.courseBooking;

import com.codeclan.example.courseBooking.models.Booking;
import com.codeclan.example.courseBooking.models.Course;
import com.codeclan.example.courseBooking.models.Customer;
import com.codeclan.example.courseBooking.repositories.BookingRepository;
import com.codeclan.example.courseBooking.repositories.CourseRepository;
import com.codeclan.example.courseBooking.repositories.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseBookingApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canCreateCourseAndSave() {
		Course course1 = new Course("Dark spells", "HogsMeade", 3);
		courseRepository.save(course1);
	}

	@Test
	public void canFindCourseByRating(){
		List<Course> foundCourses = courseRepository.findCoursesByRating(4);
		assertEquals(1, foundCourses.size());
	}

	@Test
	public void findCustomersByCourseId(){
		List<Customer> foundCustomers = customerRepository.findCustomersByBookingsCourseId(1L);
		assertEquals(1, foundCustomers.size());
	}

	@Test
	public void findCoursesByCustomerId(){
		List<Course> foundCourses = courseRepository.findCoursesByBookingsCustomerId(1L);
		assertEquals(1, foundCourses.size());
	}

	@Test
	public void findBookingsByDate() {
		List<Booking> foundBookings = bookingRepository.findBookingsByDate("12-01-21");
		assertEquals(2, foundBookings.size());
	}

	@Test
	public void findCustomersByTownAndCourseId(){
		List<Customer> foundCustomer = customerRepository.findAllByTownAndBookingsCourseId("Kent",1L);
		assertEquals("Hermione Grainger", foundCustomer.get(0).getName());
	}

	@Test
	public void findCustomersGreaterThanAgeAndTownAndCourse() {
		List<Customer> foundCustomer = customerRepository.findAllByAgeGreaterThanAndTownAndBookingsCourseId(13, "Kent", 1L);
		assertEquals("Hermione Grainger", foundCustomer.get(0).getName());
	}

}
