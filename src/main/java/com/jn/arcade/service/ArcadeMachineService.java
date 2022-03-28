package com.jn.arcade.service;

import java.util.List;
import java.util.Optional;

import com.jn.arcade.entity.ArcadeMachine;
import com.jn.arcade.repo.ArcadeMachineRepo;

public class ArcadeMachineService implements ServiceMethods<ArcadeMachine> {

	// Creates an ArcadeMachine Repo variable
	private ArcadeMachineRepo repo;

	public ArcadeMachineService(ArcadeMachineRepo repo) {
		this.repo = repo;
	}

	// Create a new ArcadeMachine object
	@Override
	public ArcadeMachine create(ArcadeMachine ArcadeMachine) {
		return this.repo.save(ArcadeMachine);
	}

	// Displays all ArcadeMachine objects in the list
	@Override
	public List<ArcadeMachine> readAll() {
		return this.repo.findAll();
	}

	// Finds ArcadeMachine by its ID and displays it
	@Override
	public ArcadeMachine readById(Long id) {
		Optional<ArcadeMachine> getArcadeMachine = this.repo.findById(id);

		// If the ID is present then it will display the information
		if (getArcadeMachine.isPresent()) {
			return getArcadeMachine.get();
		}
		return null;
	}

	// Finds ArcadeMachine by ID and updates its information using the setters and
	// getters
	@Override
	public ArcadeMachine update(Long id, ArcadeMachine ArcadeMachine) {
		Optional<ArcadeMachine> updatingMachine = this.repo.findById(id);

		// If the machine exists then the information will be updated
		if (updatingMachine.isPresent()) {
			ArcadeMachine update = updatingMachine.get();
			update.setName(ArcadeMachine.getName());
			update.setPublisher(ArcadeMachine.getPublisher());
			update.setDeveloper(ArcadeMachine.getDeveloper());
			update.setGenre(ArcadeMachine.getGenre());
			update.setPuchaseCost(ArcadeMachine.getPuchaseCost());
			update.setCostToPlay(ArcadeMachine.getCostToPlay());

			// Saves the changes and then flushes the buffer
			return this.repo.saveAndFlush(update);
		}
		return null;
	}

	// Delete ArcadeMachine object by ID and checks to see if it still exists
	// If it returns true then it has been deleted successfully
	@Override
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return false;
	}
}