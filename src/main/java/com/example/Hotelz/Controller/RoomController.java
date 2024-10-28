package com.example.Hotelz.Controller;

import com.example.Hotelz.Domain.Rooms.Rooms;
import com.example.Hotelz.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hotelz")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class RoomController {
    @Autowired
    private RoomService roomService;
    //Endoint to return listing of room
    @GetMapping("/rooms")
    public ResponseEntity<List<Rooms>> getAll(){
        List<Rooms> rooms = roomService.findAllRooms();
        return ResponseEntity.ok(rooms);
    }
}
