package com.example.Hotelz.Controller;

import com.example.Hotelz.DTO.ApiResponseDTO;
import com.example.Hotelz.DTO.ReservationRequestDTO;
import com.example.Hotelz.Domain.Reservation.Reservations;
import com.example.Hotelz.Service.AuthClientService;
import com.example.Hotelz.Service.ReservationService;
import com.example.Hotelz.Service.RoomService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hotelz") // Base URL for the Reservation API
@CrossOrigin(origins = "http://127.0.0.1:5500") // Allow cross-origin requests from specified origin
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private AuthClientService authClientService;

    /**
     * Endpoint to create a reservation.
     *
     * @param reservationRequestDTO The reservation details received from the client.
     * @param request The HTTP request containing the user's token.
     */
    @PostMapping("/reservation")
    public ResponseEntity<?> makeReservation(@RequestBody ReservationRequestDTO reservationRequestDTO,
                                             HttpServletRequest request) {

        String token = reservationService.recoverToken(request);


        ResponseEntity<?> responseEntity = authClientService.validateTokenAndGetCustomer(token);

        // Check if the token is valid and customer information is retrieved
        if (responseEntity.getStatusCode() == HttpStatus.OK && responseEntity.getBody() != null) {

            Reservations reservation = new Reservations(reservationRequestDTO, roomService);

            // Check room availability for the requested dates
            if (reservationService.checkAvailability(reservation)) {
                // Retrieve customer's email from the response body
                String email = responseEntity.getBody().toString();


                float price = reservationService.calculateTotalPrice(reservation);
                reservation.setTotalPrice(price);
                reservation.setCustomersEmails(email);

                reservationService.save(reservation);

                reservationService.reservationNotification(email);


                return ResponseEntity.ok(new ApiResponseDTO(true, "Reservation successful! \n Please check your email!"));
            } else {

                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body(new ApiResponseDTO(false, "Room is not available for the selected dates."));
            }
        } else {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ApiResponseDTO(false, "Invalid token or user not authenticated."));
        }
    }
}
