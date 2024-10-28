package com.example.Hotelz.Repositories;

import com.example.Hotelz.Domain.Rooms.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Rooms, Integer> {
    Optional<Rooms> findByRoomNumber(String roomNumber);

    @Override
    List<Rooms> findAll();
}
