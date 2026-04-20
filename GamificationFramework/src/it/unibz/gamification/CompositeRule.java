package it.unibz.gamification;

public class CompositeRule implements GameRule {

	private GameRule r1;
	private GameRule r2;
	
	public CompositeRule(GameRule r1, GameRule r2) {
		super();
		this.r1 = r1;
		this.r2 = r2;
	}

	@Override
	public void executeRuleBefore() {
		r1.executeRuleBefore();
		r2.executeRuleBefore();

	}

	@Override
	public void executeRuleAfterReturning(Object returned) {
		r1.executeRuleAfterReturning(returned);
		r2.executeRuleAfterReturning(returned);

	}

	@Override
	public void exectuteRuleWhenException(Exception ex) {
		r1.exectuteRuleWhenException(ex);
		r2.exectuteRuleWhenException(ex);

	}

}
