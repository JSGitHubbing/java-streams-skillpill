package com.skillpill.exercises;

import java.util.List;

import com.skillpill.utils.User;
import com.skillpill.utils.UserSupport;

public class LambdaExercise {
	public static void main(String[] args) {
		List<User> users = UserSupport.getExampleUsers();

		// Create a new Object of type CheckUser
		// It should implement the checkCondition(User u) interface method
		//
		// The condition should check if the User's age is between 30 and 35 both
		// included
		CheckUser condition = null;

		printUsersWithAgeBetweenThan(users, condition);

	}

	public static void printUsersWithAgeBetweenThan(List<User> roster, CheckUser condition) {
		for (User u : roster) {
			if (condition.checkCondition(u)) {
				System.out.println(u.toString());
			}
		}
	}

	public interface CheckUser {
		boolean checkCondition(User u);
	}
}
