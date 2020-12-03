package com.codeclan.example.courseBooking.repositories;

import com.codeclan.example.courseBooking.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
