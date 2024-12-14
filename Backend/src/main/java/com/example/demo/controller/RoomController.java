package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Room;
import com.example.demo.service.RoomService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/room/")
//@CrossOrigin(origins="")
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	
	@PostMapping
	public ResponseEntity<Room> addRoom(@Valid@RequestBody Room room)
	{
		return new ResponseEntity<Room>(roomService.addRoom(room),HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public List<Room> getAllRoom()
	{
		return roomService.getAllRoom();
	}
	
	@GetMapping("{roomid}")
	//used to read the data which is passing through URL
	public ResponseEntity<Room> getRoomById(@PathVariable("roomid") int roomid)
	{
		return new ResponseEntity<Room>(roomService.getRoomById(roomid),HttpStatus.OK);
	}
	
	@DeleteMapping("{roomid}")
	public ResponseEntity<String> deleteRoomById(@PathVariable("roomid") int roomid) {
		return new ResponseEntity<String>(roomService.deleteRoomById(roomid), HttpStatus.OK);
	}
 
	@PutMapping("{roomid}")
	public ResponseEntity<Room> updateRoomById(@PathVariable("roomid") int roomid,
			@RequestBody Room room) {
		return new ResponseEntity<Room>(roomService.updateRoomById(roomid, room), HttpStatus.OK);

	}
}
