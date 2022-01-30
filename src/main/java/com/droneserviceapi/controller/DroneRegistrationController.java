package com.droneserviceapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.droneserviceapi.modal.DroneDto;
import com.droneserviceapi.springboot.service.DroneSeriviceImpl;

@RestController
@RequestMapping("/drone/register")
public class DroneRegistrationController {
	@Autowired
	private DroneSeriviceImpl droneService;

	 @PostMapping("/add")
	    public ResponseEntity<MessageResponse> registerDrone( @RequestBody EmployeeRequest employee) {
	        MessageResponse newEmployee = employeeService.createEmployee(employee);
	        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
	    }

}
