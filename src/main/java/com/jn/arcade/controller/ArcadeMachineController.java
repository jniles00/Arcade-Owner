package com.jn.arcade.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jn.arcade.entity.ArcadeMachine;
import com.jn.arcade.service.ArcadeMachineService;

@RestController
@RequestMapping("/arcadeMachine")
public class ArcadeMachineController {

	// Assign ArcadeMachine Service to a variable
	private ArcadeMachineService service;

	private ArcadeMachineController(ArcadeMachineService service) {
		this.service = service;
		
		// Create a book object using Postman
		@PostMapping("/create")
		public ResponseEntity<ArcadeMachine> createArcadeMachine(@RequestBody ArcadeMachine arcadeMachine){
			return new ResponseEntity<ArcadeMachine>(this.service.create(arcadeMachine), HttpStatus.CREATED);
		}
	}
}