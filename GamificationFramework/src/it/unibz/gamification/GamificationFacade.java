package it.unibz.gamification;

import java.util.HashMap;
import java.util.Map;

public class GamificationFacade {
	private static GamificationFacade instance;

	public synchronized static GamificationFacade getInstance() {
		if (instance == null) {
			instance = new GamificationFacade();

		}
		return instance;
	}

	private Map<Class<? extends Task>, GameRule> rules = new HashMap<>();

	private GamificationFacade() {
	}

	public Object executeTask(Task task) throws FailedExecutionException {
		GameRule rule = rules.get(task.getClass());

		rule.executeRuleBefore();
		try {
			Object returned = task.execute();
			rule.executeRuleAfterReturning(returned);
			return returned;
		} catch (FailedExecutionException ex) {
			rule.exectuteRuleAfterThrowing(ex);
			throw ex;
		}
	}

	void setGameRule(GameRule rule, Class<? extends Task> taskClass) {
		rules.put(taskClass, rule);
	}

}
