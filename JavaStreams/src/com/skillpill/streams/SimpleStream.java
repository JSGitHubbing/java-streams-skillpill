package com.skillpill.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.skillpill.utils.User;
import com.skillpill.utils.UserSupport;

public class SimpleStream {

	public static void main(String[] args) {
		List<User> users = UserSupport.getExampleUsers();
		users.stream().forEach(System.out::println);
		users.stream().filter(u -> u.getAge() == 30).forEach(System.out::println);

		Optional<User> eldestUser = users.stream().max(Comparator.comparing(User::getAge));
		eldestUser.ifPresent(u -> System.out.println(u.toString()));

	}

}
