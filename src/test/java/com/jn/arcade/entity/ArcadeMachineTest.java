package com.jn.arcade.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.jn.arcade.entity.ArcadeMachine;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ArcadeMachineTest {

	@Test
	public void testEquals() {
		EqualsVerifier.forClass(ArcadeMachine.class).usingGetClass().verify();
	}

	// Testing getters and setters
	@Test
	public void getterAndSetterTest() {

		// Creates an empty object
		ArcadeMachine arcadeMachine = new ArcadeMachine();

		// Using setters to add values
		arcadeMachine.setName("Deathsmiles");
		arcadeMachine.setPublisher("Cave");
		arcadeMachine.setDeveloper("Cave");
		arcadeMachine.setGenre("Shoot 'em up");
		arcadeMachine.setPurchaseCost(1000);
		arcadeMachine.setCostToPlay(1);

		// Checks values set above are not null
		assertNotNull(arcadeMachine.getName());
		assertNotNull(arcadeMachine.getPublisher());
		assertNotNull(arcadeMachine.getDeveloper());
		assertNotNull(arcadeMachine.getGenre());
		assertNotNull(arcadeMachine.getPurchaseCost());
		assertNotNull(arcadeMachine.getCostToPlay());

		// Checks the getters are getting the correct values
		assertEquals(arcadeMachine.getId(), 0);
		assertEquals(arcadeMachine.getName(), "Deathsmiles");
		assertEquals(arcadeMachine.getPublisher(), "Cave");
		assertEquals(arcadeMachine.getDeveloper(), "Cave");
		assertEquals(arcadeMachine.getGenre(), "Shoot 'em up");
		assertEquals(arcadeMachine.getPurchaseCost(), 1000);
		assertEquals(arcadeMachine.getCostToPlay(), 1);
	}
}