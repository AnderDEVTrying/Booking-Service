package com.example.Hotelz.Domain.Reservation;

import com.example.Hotelz.DTO.ReservationRequestDTO;
import com.example.Hotelz.Domain.Rooms.Rooms;
import com.example.Hotelz.Service.RoomService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String customersEmails;
    @ManyToOne
    private Rooms rooms;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Status status;
    private Float totalPrice;

    public Reservations(ReservationRequestDTO requestDTO, RoomService roomService) {
        this.rooms = roomService.findRoomOrThrowException(requestDTO.roomNumber());
        this.checkIn = requestDTO.checkIn();
        this.checkOut = requestDTO.checkOut();
        this.status = Status.ACTIVE;
    }
}
