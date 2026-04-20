package it.unibz.gamification.test;

import it.unibz.gamification.FailedExecutionException;
import it.unibz.gamification.Task;

public class TaskThatReturnsAnInteger implements Task {

	private int toBeReturned = 0;
	
	public TaskThatReturnsAnInteger(int toBeReturned) {
		this.toBeReturned = toBeReturned;
	}

	@Override
	public Object execute() throws FailedExecutionException {
		return toBeReturned;
	}

}
