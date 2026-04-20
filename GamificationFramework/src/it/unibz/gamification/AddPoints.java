package it.unibz.gamification;

public class AddPoints implements GameRule {
    private int pointsToAdd;
    
    public AddPoints(int pointsToAdd) {
        super();
        this.pointsToAdd = pointsToAdd;
    }

    @Override
    public void executeRuleBefore() {
        UserRegistry.getCurrentUser().addPoints(pointsToAdd);
    }

    @Override
    public void executeRuleAfterReturning(Object returned) {
    }

	@Override
	public void exectuteRuleWhenException(Exception ex) {
		// TODO Auto-generated method stub
		
	}

}
