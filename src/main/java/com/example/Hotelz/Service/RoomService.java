package com.example.Hotelz.Service;

import com.example.Hotelz.Domain.Rooms.Rooms;
import com.example.Hotelz.Repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public Rooms findRoomOrThrowException(String roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber)
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));
    }

    public List<Rooms> findAllRooms (){
        return roomRepository.findAll();
    }

}
