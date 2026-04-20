package it.unibz.gamification;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class User {
	private String name;
	private int points = 0;
	private Set<String> badges = new HashSet<>();
	
	public User(String name) {
		super();
		this.name = name;
	}
	
	public void addPoints(int pointsToAdd) {
		points += pointsToAdd;
	}
	
	public void removePoints(int pointsToRemove) {
		points -= pointsToRemove;
	}
	
	public void addBadge(String badge) {
		badges.add(badge);
	}

	public void removeBadge(String badge) {
		badges.remove(badge);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Set<String> getBadges() {
		return Collections.unmodifiableSet(badges);
	}

	public void setBadges(Set<String> badges) {
		this.badges = badges;
	}

	public boolean hasBadge(String badge) {
		return badges.contains(badge);
	}

}
