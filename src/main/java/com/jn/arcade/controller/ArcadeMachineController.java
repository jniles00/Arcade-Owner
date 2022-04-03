package com.jn.arcade.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	}

	// Create an ArcadeMachine object using Postman
	@PostMapping("/create")
	public ResponseEntity<ArcadeMachine> createArcadeMachine(@RequestBody ArcadeMachine arcadeMachine) {
		return new ResponseEntity<ArcadeMachine>(this.service.create(arcadeMachine), HttpStatus.CREATED);
	}

	// Read all ArcadeMachine objects in a list
	@GetMapping("/readAll")
	public ResponseEntity<List<ArcadeMachine>> readAll(){
		return new ResponseEntity<List<ArcadeMachine>>(this.service.readAll(), HttpStatus.OK);
	}
	
	// Update the information for an ArcadeMachine object
	@PutMapping("/update/{id}")
	public ResponseEntity<ArcadeMachine> updateArcadeMachine(@PathVariable long id, @RequestBody ArcadeMachine arcadeMachine){
		return new ResponseEntity<ArcadeMachine>(this.service.update(id, arcadeMachine), HttpStatus.ACCEPTED);
	}
	
	// Deletes the information for an ArcadeMachine object by find its ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteArcadeMachine(@PathVariable long id){
		// If the ArcadeMachine object is successfully deleted, it should return NO_CONTENT
		return(this.service.delete(id)) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT):
			// Else if it was not successful then it will return "NOT_FOUND"
			new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}
}