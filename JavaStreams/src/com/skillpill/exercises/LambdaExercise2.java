package com.skillpill.exercises;

import java.util.List;

import com.skillpill.utils.User;
import com.skillpill.utils.UserSupport;

public class LambdaExercise2 {
	public static void main(String[] args) {
		List<User> users = UserSupport.getExampleUsers();

		// Transform the code to use a Predicate instead of CheckUser
		CheckUser condition = u -> u.getAge() >= 30 && u.getAge() <= 35;

		printUsersWithCondition(users, condition);

	}

	// Remember to change the type of the input parameter
	public static void printUsersWithCondition(List<User> roster, CheckUser condition) {
		for (User u : roster) {
			// Predicate has as only method .test()
			if (condition.checkCondition(u)) {
				System.out.println(u.toString());
			}
		}
	}

	public interface CheckUser {
		boolean checkCondition(User u);
	}
}
