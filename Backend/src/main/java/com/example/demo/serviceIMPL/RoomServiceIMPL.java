package com.example.demo.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Room;
import com.example.demo.repository.RoomRepository;
import com.example.demo.service.RoomService;

@Service
public class RoomServiceIMPL implements RoomService{

	
	@Autowired
    private RoomRepository roomRepository;
	
	
	@Override
	public Room addRoom(Room room) {
		// TODO Auto-generated method stub
		return roomRepository.save(room);
	}

	
	@Override
	public List<Room> getAllRoom() {
		// TODO Auto-generated method stub
		return roomRepository.findAll();
	}

	@Override
	public Room getRoomById(int roomid) {
		// TODO Auto-generated method stub
		return roomRepository.findById(roomid).get();
	}

	@Override
	public String deleteRoomById(int roomid) {
		// TODO Auto-generated method stub
		Room room = getRoomById(roomid);// to check the id is present in the table or not
		roomRepository.deleteById(room.getRoomId());
				return "record deleted successfully";
	}

	@Override
	public Room updateRoomById(int roomid, Room room) {
		// TODO Auto-generated method stub
		Room room1 = getRoomById(roomid);// to check the id is present in the table or not
//		patient1.setPname(patient.getPname());
//		patient1.setPatientUsername(patient.getPatientUsername());
//		patient1.setContInfo(patient.getContInfo());
//		patient1.setInsurance_Info(patient.getInsurance_Info());
//		patient1.setPatientPassword(patient.getPatientPassword());
		return roomRepository.save(room1);
	}
		

}
