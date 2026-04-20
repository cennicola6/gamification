package it.unibz.gamification;

public interface GameRule {
    public void executeRuleBefore();

    public void executeRuleAfterReturning(Object returned);

    public void exectuteRuleWhenException(Exception ex);

}
