package com.skillpill.solutions;

import java.util.List;
import java.util.function.Predicate;

import com.skillpill.utils.User;
import com.skillpill.utils.UserSupport;

public class LambdaExercise2 {
	public static void main(String[] args) {
		List<User> users = UserSupport.getExampleUsers();
		printUsersWithCondition(users, u -> u.getAge() >= 30 && u.getAge() <= 35);
	}

	public static void printUsersWithCondition(List<User> roster, Predicate<User> condition) {
		for (User u : roster) {
			if (condition.test(u)) {
				System.out.println(u.toString());
			}
		}
	}
}
