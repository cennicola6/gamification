package it.unibz.gamification;

public class AddBadgeIfPositive implements GameRule {

	public AddBadgeIfPositive() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executeRuleBefore() {
		// TODO Auto-generated method stub

	}

	@Override
	public void executeRuleAfterReturning(Object returned) {
		if(returned instanceof Integer && (Integer) returned > 0) {
			UserRegistry.getCurrentUser().addBadge("Positive");
		}

	}

	@Override
	public void exectuteRuleWhenException(Exception ex) {
		// TODO Auto-generated method stub

	}

}
