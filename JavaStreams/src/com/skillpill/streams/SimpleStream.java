package com.skillpill.streams;

import java.util.List;
import java.util.function.Predicate;

import com.skillpill.utils.User;
import com.skillpill.utils.UserSupport;

public class SimpleStream {

	public static void main(String[] args) {
		List<User> users = UserSupport.getExampleUsers();
		Predicate<User> condition = (User u) -> u.getAge() >= 30 && u.getAge() <= 35;

		users.stream().forEach(System.out::println);
		users.stream().filter(u -> u.getAge() == 30).forEach(System.out::println);

	}

}
