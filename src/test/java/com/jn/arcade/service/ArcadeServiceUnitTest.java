package com.jn.arcade.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.jn.arcade.entity.ArcadeMachine;
import com.jn.arcade.repo.ArcadeMachineRepo;

@SpringBootTest
public class ArcadeServiceUnitTest {

	// Injects the ArcadeMachineService class into the service variable
	@Autowired
	private ArcadeMachineService service;

	// Mocks the repo class as we don;t want to rely on the class itself
	@MockBean
	private ArcadeMachineRepo repo;

	@Test
	public void createArcadeMachineTest() {

		// This input does not have an ID
		ArcadeMachine machineInput = new ArcadeMachine("Deathsmiles", "Cave", "Cave", "Shoot 'em up", 1000, 1);
		// This input does have an ID
		ArcadeMachine machineOutput = new ArcadeMachine(1, "Deathsmiles", "Cave", "Cave", "Shoot 'em up", 1000, 1);

		// Testing so that what is saved (machineInput) will be returned when called
		// (machineOutput)
		Mockito.when(this.repo.save(machineInput)).thenReturn(machineOutput);

		// Checks to see if the expected value (machineOutput) 
		// is the same as the one entered (machineInput)
		assertEquals(machineOutput, this.service.create(machineInput));
		
		// Runs the repo one time before saving the value
		Mockito.verify(this.repo, Mockito.times(1)).save(machineInput);
	}
}