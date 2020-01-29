package com.claim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.claim.entity.UserNotification;
import com.claim.repository.UserNotificationRepository;

@CrossOrigin
@RestController
public class UserNotificationController 
{
	@Autowired
	UserNotificationRepository unr;
	/*
	 * @RequestMapping(value="/createNewNotification", method= RequestMethod.POST,
	 * consumes= MediaType.APPLICATION_JSON_VALUE) public void
	 * createNewNotification(@RequestBody List<String> emails) { this.unr.save(un);
	 * }
	 */
}
