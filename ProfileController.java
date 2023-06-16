package com.avengers.bus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avengers.bus.entityModels.User;
import com.avengers.bus.services.FetchPassengers;
import com.avengers.bus.services.FetchTickets;
import com.avengers.bus.services.FetchUserservice;

@Controller
public class ProfileController {
	@Autowired
	FetchUserservice fetchuser;
	@Autowired
	FetchTickets fetchtickets;
	@Autowired
	FetchPassengers fetchpassengers;

	// @Autowired
	// public ProfileController(FetchUserservice fetchuser, FetchTickets fetchtickets) {
	// this.fetchuser = fetchuser;
	// this.fetchtickets = fetchtickets;
	// }
	//
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getDash(Model model) {
		System.out.print("User DashBoard");
		return ("dash1");

	}

	@RequestMapping(value = "/UserList", method = RequestMethod.GET)
	@ResponseBody
	public String UserDetailsController() {
		System.out.println("im working...");
		String userJson = fetchuser.getUserList();
		return userJson;

	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String Userupdate(@RequestBody User user) {
		System.out.println("updatingggg...");
		System.out.println(user.getUser_id());
		System.out.println(user.getFull_name());
		// System.out.println(user.getMobile());
		// FetchUser f1 = new FetchUser(ldao);
		fetchuser.add(user);
		// ldao.updateUser(user);
		return "Userdashboard";

	}

	@RequestMapping(value = "/ticketList", method = RequestMethod.GET)
	@ResponseBody
	public String ticketsDetails() {
		System.out.println("im working...");
		String userJson = fetchtickets.getticketList();
		return userJson;

	}

	@RequestMapping(value = "/passengersList", method = RequestMethod.GET)
	@ResponseBody
	public String passengersDetails() {
		System.out.println("im working...");
		String userJson = fetchpassengers.getPassengersList();
		return userJson;

	}

}
