package com.claim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.claim.entity.UserParks;
import com.claim.repository.UserParksRepository;

@CrossOrigin
@RestController
public class UserParksController {
	@Autowired
	UserParksRepository upr;
	
	@RequestMapping(value="/getUserParks", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserParks>> getUserParks(@RequestParam String email){
		List<UserParks> parks = this.upr.findUserParks(email);
		
		return new ResponseEntity<>(parks, HttpStatus.OK);
	}
}
