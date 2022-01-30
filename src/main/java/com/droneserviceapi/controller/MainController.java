package com.droneserviceapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.droneserviceapi.springboot.service.DroneService;


@RestController
@RequestMapping("/api")
public class MainController {
	
	@Autowired
	private DroneService droneService;
	
	@PostMapping(path = "/register") 
	public String registerDone() {
		return droneService.register(null);
	}
	
	
	
	

}
