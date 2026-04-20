package it.unibz.gamification.test;

import it.unibz.gamification.FailedExecutionException;
import it.unibz.gamification.Task;

public class MockTask implements Task {
	private boolean wasExecuted = false;

	@Override
	public Object execute() throws FailedExecutionException {
		wasExecuted = true;
		return null;
	}

	public boolean wasExecuted() {
		return wasExecuted;
	}

	public void setWasExecuted(boolean wasExecuted) {
		this.wasExecuted = wasExecuted;
	}

}
