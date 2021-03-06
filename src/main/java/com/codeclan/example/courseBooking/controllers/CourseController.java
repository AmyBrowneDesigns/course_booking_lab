package com.codeclan.example.courseBooking.controllers;

import com.codeclan.example.courseBooking.models.Course;
import com.codeclan.example.courseBooking.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses
            (@RequestParam(name = "rating", required = false) Integer rating,
             @RequestParam(name = "customerId", required = false)Long customerId)
    {
        if (rating != null){
            return new ResponseEntity<>(courseRepository.findCoursesByRating(rating), HttpStatus.OK);
        }
        if (customerId !=null){
            return new ResponseEntity<>(courseRepository.findCoursesByBookingsCustomerId(customerId), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);

    }

}
