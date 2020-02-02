package com.claim.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.claim.entity.UserNotification;
import com.claim.repository.UserNotificationRepository;

@CrossOrigin
@RestController
public class UserNotificationController 
{
	@Autowired
	UserNotificationRepository unr;
	
	@RequestMapping(value="/getMyNotifications", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<UserNotification>> getMyNotifications(@RequestParam String email)
	{
		List<UserNotification> notifications = this.unr.findMyNotifications(email);
		return new ResponseEntity<>(notifications, HttpStatus.OK);
	}
}
