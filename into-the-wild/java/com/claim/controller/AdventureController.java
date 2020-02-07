package com.claim.controller;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.multipart.MultipartFile;

import com.claim.entity.Adventure;
import com.claim.entity.User;
import com.claim.repository.AdventureRepository;
import com.claim.repository.UserRepository;

@CrossOrigin
@RestController
public class AdventureController 
{
	@Autowired
	AdventureRepository ar;
	@Autowired
	UserRepository ur;
	
	@RequestMapping(value="/getAllAdventures", produces= MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	@Autowired
	public ResponseEntity<List<Adventure>> getAllAdventures(){
		List<Adventure> allAdventures = this.ar.findAll();
		Collections.reverse(allAdventures);
		return new ResponseEntity<List<Adventure>>(allAdventures, HttpStatus.OK);
	}

	@RequestMapping(value="/findMyAdventures", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Adventure>> findMyAdventures(@RequestParam String email)
	{
		List<Adventure> adventures = this.ar.findPartyLeaderAdventures(email);
		return new ResponseEntity<>(adventures, HttpStatus.OK);
	}

	@RequestMapping(value="/createNewAdventure", method= RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void createNewAdventure(@RequestParam("image")  MultipartFile file, @RequestParam("partyLeader")String email, 
			@RequestParam("name")String name, @RequestParam("park") String park, @RequestParam("activity") String activity, @RequestParam("where") String where, 
			@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("post") String post)
	{	
		byte[] img = null;
		try {
			img = file.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User partyLeader = ur.findByEmail(email);
		Adventure adventure = new Adventure();
		adventure.setPartyLeader(partyLeader);
		adventure.setName(name);
		adventure.setPark(park);
		adventure.setActivity(activity);
		adventure.setWhere(where);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date start = new Date();
		Date end = new Date();
		
		try {
			start = formatter.parse(startDate);
			end = formatter.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		adventure.setStartDate(start);
		adventure.setEndDate(end);
		
		Date postDate = new Date();
		adventure.setPost(post);
		adventure.setPostDate(postDate);
		
		adventure.setPic(img);
		this.ar.save(adventure);

	}

	@RequestMapping(value="/findAdventure", produces= MediaType.APPLICATION_JSON_VALUE, method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Adventure> findAdventure(@RequestParam String adventureId)
	{
		String[] splitId = adventureId.split("\"");
		String splitNum = splitId[3];
		int id = Integer.parseInt(splitNum);
		Optional<Adventure> adventure = this.ar.findById(id);
		if(adventure.isPresent())
		{
			return new ResponseEntity<>(adventure.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
