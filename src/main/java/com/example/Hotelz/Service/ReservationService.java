package com.example.Hotelz.Service;

import com.example.Hotelz.DTO.EmailRequest;
import com.example.Hotelz.Domain.Reservation.Reservations;
import com.example.Hotelz.Domain.Rooms.Rooms;
import com.example.Hotelz.Repositories.ReservationRepository;
import com.example.Hotelz.Repositories.RoomRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private EmailClient emailClient;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private RoomRepository roomRepository;

    public void save(Reservations reservation) {
        reservationRepository.save(reservation);
    }

    public float calculateTotalPrice(Reservations reservations) {
        Rooms roomNumber = reservations.getRooms();
        LocalDate check_in = reservations.getCheckIn();
        LocalDate chec_out = reservations.getCheckOut();

        int days = check_in.until(chec_out).getDays();

        float totalPrice = roomNumber.getPrice() * days;

        reservations.setTotalPrice(totalPrice);
        return totalPrice;
    }

    public boolean checkAvailability(Reservations reservations) {
        Rooms rooms = reservations.getRooms();
        LocalDate check_in = reservations.getCheckIn();
        LocalDate check_out = reservations.getCheckOut();

        List<Reservations> existingReservation = reservationRepository.findByRoomAndDates(rooms, check_in, check_out);
        return existingReservation.isEmpty();
    }

    public void reservationNotification(String to) {
       String subject = "Confirmation";
        String body = "Your reservation was a success. \n Thank you for trusting in us";
        EmailRequest emailRequest = new EmailRequest(to, subject, body);
        emailClient.sendEmail(emailRequest);
    }

    public String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }

}
