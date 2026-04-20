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

	private GamificationFacade() {
	}
	
	private Map<Class<? extends Task>, GameRule> rules = new HashMap<>();

	public Object executeTask(Task task) throws FailedExecutionException {
		GameRule rule = rules.get(task.getClass());

		if (rule == null) {
			rule = new NullRule();
		}
		rule.executeRuleBefore();
		
		try {
			Object returned = task.execute();
			rule.executeRuleAfterReturning(returned);
			return returned;
		} catch (FailedExecutionException ex) {
			rule.exectuteRuleWhenException(ex);
			throw ex;
		}
	}

	public void setGameRule(GameRule rule, Class<? extends Task> taskClazz) {
		if(rules.containsKey(taskClazz)) {
			GameRule exisintgRule = rules.get(taskClazz);
			rules.put(taskClazz, new CompositeRule(exisintgRule, rule));
		}else {
			rules.put(taskClazz, rule);
		}
	}

	public void cleanRules() {
		rules = new HashMap<>();
	}
}
