package com.metinagan.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metinagan.dto.DtoHome;
import com.metinagan.dto.DtoRoom;
import com.metinagan.entities.Home;
import com.metinagan.entities.Room;
import com.metinagan.repository.HomeRepository;
import com.metinagan.services.IHomeService;

@Service
public class HomeServiceImpl implements IHomeService{

	@Autowired
	private HomeRepository homerepository;
	
	@Override
	public DtoHome findHomeById(Long id) {
		Optional<Home> optional = homerepository.findById(id);
		
		DtoHome dtohome=new DtoHome();
		
		if(optional.isPresent()) {
			
			Home dbhome=new Home();
			dbhome =optional.get();
			
			List<Room> dbroom=optional.get().getRoom();
			
			BeanUtils.copyProperties(dbhome, dtohome);
			
			if (dbroom!=null && !dbroom.isEmpty()) {
				for (Room room : dbroom) {
					DtoRoom dtoroom= new DtoRoom();
					BeanUtils.copyProperties(room, dtoroom);
					dtohome.getRoom().add(dtoroom);
				}
				return dtohome;
			}	
		}
		return null;
	}

	
	
}
