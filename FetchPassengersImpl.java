package com.avengers.bus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avengers.bus.dao.UserPassengersDao;
import com.avengers.bus.entityModels.UserPassengers;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class FetchPassengersImpl implements FetchPassengers {

	@Autowired
	private UserPassengersDao updao;

	@Override
	public String getPassengersList() {
		List<UserPassengers> Userpassengers = updao.getAllUserPassengers(1);
		ObjectMapper om = new ObjectMapper();

		try {
			// Convert the list to JSON
			String json = om.writeValueAsString(Userpassengers);
			System.out.println(json);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
