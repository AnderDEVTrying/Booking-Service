package com.example.Hotelz.DTO;

import java.time.LocalDate;

public record ReservationRequestDTO( String roomNumber, LocalDate checkIn, LocalDate checkOut) {
}
