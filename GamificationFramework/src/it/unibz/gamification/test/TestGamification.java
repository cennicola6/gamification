package it.unibz.gamification.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibz.gamification.AddBadgeIfPositive;
import it.unibz.gamification.AddPoints;
import it.unibz.gamification.FailedExecutionException;
import it.unibz.gamification.GamificationFacade;
import it.unibz.gamification.User;
import it.unibz.gamification.UserRegistry;

class TestGamification {
	
	@BeforeEach
	void setup() {
		GamificationFacade.getInstance().cleanRules();
	}

	@Test
	void ExecuteTaskNoRule() throws FailedExecutionException {
		MockTask mockTask = new MockTask();
		GamificationFacade facade = GamificationFacade.getInstance();
		
		facade.executeTask(mockTask);
		
		assertTrue(mockTask.wasExecuted());
		
	}
	
	@Test
	void addPoints() throws FailedExecutionException {
		User u = new User("Guerra");
		UserRegistry.setCurrentUser(u);
		
		GamificationFacade facade = GamificationFacade.getInstance();
		facade.setGameRule(new AddPoints(10), MockTask.class);
		
		MockTask mockTask = new MockTask();
		facade.executeTask(mockTask);
		facade.executeTask(mockTask);
		
		assertEquals(20, UserRegistry.getCurrentUser().getPoints());
		
	}
	
	@Test
	void addPositveBadge() throws FailedExecutionException {
		User u = new User("Guerra");
		UserRegistry.setCurrentUser(u);
		
		GamificationFacade facade = GamificationFacade.getInstance();
		facade.setGameRule(new AddBadgeIfPositive(), TaskThatReturnsAnInteger.class);
		
		TaskThatReturnsAnInteger mockTask = new TaskThatReturnsAnInteger(5);
		facade.executeTask(mockTask);
		
		assertTrue(UserRegistry.getCurrentUser().hasBadge("Positive"));
		
	}

	@Test
	void doNotDeservePositveBadge() throws FailedExecutionException {
		User u = new User("Guerra");
		UserRegistry.setCurrentUser(u);
		
		GamificationFacade facade = GamificationFacade.getInstance();
		facade.setGameRule(new AddBadgeIfPositive(), TaskThatReturnsAnInteger.class);
		
		TaskThatReturnsAnInteger mockTask = new TaskThatReturnsAnInteger(-5);
		facade.executeTask(mockTask);
		
		assertFalse(UserRegistry.getCurrentUser().hasBadge("Positive"));
		
	}
	
	@Test
	void threeGameRules() throws FailedExecutionException {
		User u = new User("Guerra");
		UserRegistry.setCurrentUser(u);
		
		GamificationFacade facade = GamificationFacade.getInstance();
		facade.setGameRule(new AddBadgeIfPositive(), TaskThatReturnsAnInteger.class);
		facade.setGameRule(new AddPoints(50), TaskThatReturnsAnInteger.class);
		facade.setGameRule(new AddPoints(7), TaskThatReturnsAnInteger.class);
		
		TaskThatReturnsAnInteger mockTask = new TaskThatReturnsAnInteger(5);
		facade.executeTask(mockTask);
		
		assertTrue(UserRegistry.getCurrentUser().hasBadge("Positive"));
		assertEquals(57, UserRegistry.getCurrentUser().getPoints());
		
	}
}
