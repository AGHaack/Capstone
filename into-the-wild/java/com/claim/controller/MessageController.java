package com.claim.controller;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.claim.entity.Message;
import com.claim.entity.User;
import com.claim.repository.MessageRepository;
import com.claim.repository.UserRepository;

@CrossOrigin
@RestController
public class MessageController {
	@Autowired
	MessageRepository mr;
	@Autowired
	UserRepository ur;
	
	@RequestMapping(value="/getMyIncomingMessages", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Message>> getMyIncomingMessages(@RequestParam String email){
		List<Message> myMessages = this.mr.findMyIncomingMessages(email);

		return new ResponseEntity<>(myMessages, HttpStatus.OK);
	}
	
	@RequestMapping(value="/sendMessage", method= RequestMethod.POST, consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
	public void sendMessage(@RequestParam("to") String toEmail, @RequestParam("from") String fromEmail, @RequestParam("message") String message) {
		User toUser = this.ur.findByEmail(toEmail);
		User fromUser = this.ur.findByEmail(fromEmail);
		Message m = new Message();
		LocalDate today = LocalDate.now();
		m.setTo(toUser);
		m.setFrom(fromUser);
		m.setSent(today);
		m.setSeen(false);
		m.setMessage(message);
		
		this.mr.save(m);
	}
	@RequestMapping(value="/getMySentMessages", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Message>> getMySentMessages(@RequestParam String email){
		List<Message> messages = this.mr.findMyOutGoingMessages(email);
		
		return new ResponseEntity<>(messages, HttpStatus.OK);
	}
}
