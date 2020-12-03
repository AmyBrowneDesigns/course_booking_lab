package com.codeclan.example.courseBooking.repositories;

import com.codeclan.example.courseBooking.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findCoursesByRating(int rating);

    List<Course> findCoursesByBookingsCustomerId(Long Id);
}
