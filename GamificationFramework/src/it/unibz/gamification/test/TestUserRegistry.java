package it.unibz.gamification.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import it.unibz.gamification.User;
import it.unibz.gamification.UserRegistry;

public class TestUserRegistry {
	@Test
	void usersInParallel() {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				UserRegistry.setCurrentUser(new User("u1"));
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("T1: " + UserRegistry.getCurrentUser().getName());
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				UserRegistry.setCurrentUser(new User("u2"));
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("T2: " + UserRegistry.getCurrentUser().getName());
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
