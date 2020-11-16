package com.skillpill.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserSupport {

	public static List<User> getExampleUsers() {
		List<User> userList = new ArrayList<User>();
		try {
			Files.lines(Paths.get(UserConstants.getUsersDataPath())).forEach(userData -> {
				String[] userValues = userData.split("\\|");
				User currentUser = new User(userValues[0], userValues[1], userValues[2], userValues[3], userValues[4],
						userValues[5]);
				userList.add(currentUser);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList;
	}
}
