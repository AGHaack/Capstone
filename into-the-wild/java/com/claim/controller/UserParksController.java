package com.claim.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.claim.entity.User;
import com.claim.entity.UserParks;
import com.claim.repository.UserParksRepository;
import com.claim.repository.UserRepository;

@CrossOrigin
@RestController
public class UserParksController {
	@Autowired
	UserParksRepository upr;
	@Autowired
	UserRepository ur;
	
	@RequestMapping(value="/getUsersWhoVisitedPark", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserParks>> getUsersWhoVisitedPark(@RequestParam("park") String park){
		List<UserParks> parkList = this.upr.findUsersWhoVisitedPark(park);
		
		return new ResponseEntity<>(parkList, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getUserParks", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserParks>> getUserParks(@RequestParam String email){
		
		List<UserParks> parks = this.upr.findUserParks(email);
		return new ResponseEntity<>(parks, HttpStatus.OK);
	}
	
	@RequestMapping(value="/addNewPark", method= RequestMethod.POST, consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
	public void addNewPark(@RequestParam("email") String email, @RequestParam("parkName") String park, @RequestParam("year") String visited, @RequestParam("parkCode") String parkCode, @RequestParam("activity") String activity, @RequestParam("where") String where) {
		User user = this.ur.findByEmail(email);
		List<UserParks> upVisited = this.upr.findUserParks(email);
		UserParks up = new UserParks();
		boolean hasVisited = up.checkVisited(upVisited, park);
		if(hasVisited == false) {
			int parkCount = user.getParkCount() + 1;
			user.setParkCount(parkCount);
			this.ur.save(user);
			up.setUserKey(user);
			up.setParkName(park);
			up.setParkCode(parkCode);
			int year = Integer.parseInt(visited);
			up.setVisited(year);
			up.setActivity(activity);
			up.setLocation(where);
			this.upr.save(up);
		} else {
			up.setUserKey(user);
			up.setParkName(park);
			up.setParkCode(parkCode);
			int year = Integer.parseInt(visited);
			up.setVisited(year);
			up.setActivity(activity);
			up.setLocation(where);
			this.upr.save(up);
		}
		
	}
}
