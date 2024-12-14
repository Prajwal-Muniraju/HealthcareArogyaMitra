package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Room;

public interface RoomService {
	
	public Room addRoom(Room room);
	
	public List<Room> getAllRoom();
	
	public Room getRoomById(int roomid);
	
	public String deleteRoomById(int roomid );
	
	public Room updateRoomById(int roomid,Room room );

}
