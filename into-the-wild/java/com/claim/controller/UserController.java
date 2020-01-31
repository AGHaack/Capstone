package com.claim.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.claim.entity.User;
import com.claim.repository.UserRepository;

@CrossOrigin
@RestController
public class UserController 
{
	@Autowired
	UserRepository ur;
	
	@RequestMapping(value="/createNewUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createNewUser(@RequestBody User user)
	{
		this.ur.save(user);
	}
	
	@RequestMapping(value="/findUserByEmail", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	private ResponseEntity<User> findUser( String email)
	{	
		Optional<User> user = this.ur.findById(email);
		if(user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>( HttpStatus.OK);

	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	private ResponseEntity<Optional<User>> login(@RequestBody User user)
	{
		Optional<User> user2 = this.ur.login(user.getEmail(), user.getPassword());
		if(user2.isPresent())
		{
			return new ResponseEntity<>(user2, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@RequestMapping(value = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	@Autowired
	private ResponseEntity<List<User>> getAllUsers()
	{
		List<User> users = this.ur.findAll();
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
}
