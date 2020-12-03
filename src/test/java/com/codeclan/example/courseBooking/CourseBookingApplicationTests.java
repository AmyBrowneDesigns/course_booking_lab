package com.codeclan.example.courseBooking;

import com.codeclan.example.courseBooking.models.Booking;
import com.codeclan.example.courseBooking.models.Course;
import com.codeclan.example.courseBooking.models.Customer;
import com.codeclan.example.courseBooking.repositories.BookingRepository;
import com.codeclan.example.courseBooking.repositories.CourseRepository;
import com.codeclan.example.courseBooking.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class CourseBookingApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	void contextLoads() {
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



}
