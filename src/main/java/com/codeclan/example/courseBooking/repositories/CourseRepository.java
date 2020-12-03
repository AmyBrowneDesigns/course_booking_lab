package com.codeclan.example.courseBooking.repositories;

import com.codeclan.example.courseBooking.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
