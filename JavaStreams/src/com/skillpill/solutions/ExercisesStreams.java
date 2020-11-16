package com.skillpill.solutions;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.skillpill.utils.User;

public class ExercisesStreams {
	/**
	 * Exercise 1
	 * 
	 * Create a list with the users with name starting with character
	 * "startingCharacter"
	 */
	public static void printTheList(final List<User> userList) {
		userList.forEach(System.out::println);
	}

	/**
	 * Exercise 2
	 * 
	 * Find if there is an user with the name equals to "nameToFind"
	 */
	public static boolean isNameInTheList(final List<User> userList, final String nameToFind) {
		return userList.stream().anyMatch(u -> u.getName().equals(nameToFind));
	}

	/**
	 * Exercise 3
	 * 
	 * Create a list with the users with name starting with character
	 * "startingCharacter"
	 */
	public static List<User> getUsersWithStartingCharacter(final List<User> userList, final String startingCharacter) {

		return userList.stream().filter(u -> u.getName().charAt(0) == startingCharacter.toUpperCase().charAt(0))
				.collect(Collectors.toList());
	}

	/**
	 * Exercise 4
	 * 
	 * Create a list with the name of the city the users live in The names of the
	 * city should be Uppercase
	 */
	public static List<String> getUppercaseCities(final List<User> userList) {
		return userList.stream().map(u -> u.getCity().toUpperCase()).collect(Collectors.toList());
	}

	/**
	 * THAT WAS THE EASY PART
	 */

	/**
	 * Exercise 5
	 * 
	 * Get the number of Users that live in the "targetCity"
	 */
	public static long usersLivingInCity(final List<User> userList, final String targetCity) {
		return userList.stream().filter(u -> u.getCity().equals(targetCity)).count();
	}

	/**
	 * Exercise 6
	 * 
	 * Get a list of the names of the users, no duplicates
	 */
	public static List<String> noDuplicatedNames(final List<User> userList) {
		return userList.stream().map(u -> u.getName()).distinct().collect(Collectors.toList());
	}

	/**
	 * Exercise 7
	 * 
	 * Count the number of Users living in each city Save the information in a map
	 * <city, numberUsers>
	 */
	public static Map<String, Long> usersPerCity(final List<User> userList) {
		return userList.stream().map(u -> u.getCity()).distinct()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}

	/**
	 * Exercise 8
	 * 
	 * Order the list from the young to the oldest user for the same age order by
	 * name
	 */
	public static List<User> orderFromYoungerToOldest(final List<User> userList) {
		Comparator<User> myComparator = Comparator.comparing(User::getAge)
				.thenComparing(Comparator.comparing(User::getName));

		return userList.stream().sorted(myComparator).collect(Collectors.toList());
	}

}
