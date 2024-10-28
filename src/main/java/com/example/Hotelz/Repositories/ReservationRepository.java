package com.example.Hotelz.Repositories;

import com.example.Hotelz.Domain.Reservation.Reservations;
import com.example.Hotelz.Domain.Rooms.Rooms;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservations, Integer> {
    @Query("SELECT r FROM Reservations r WHERE r.rooms = :room AND " +
            "((r.checkIn <= :checkOut AND r.checkOut >= :checkIn))")
    List<Reservations> findByRoomAndDates(@Param("room") Rooms room, @Param("checkIn") LocalDate checkIn,
                                          @Param("checkOut") LocalDate checkOut);

}
