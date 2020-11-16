package com.skillpill.readingdata;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.skillpill.utils.User;
import com.skillpill.utils.UserConstants;

public class ReadingDataStream {
	public static void main(String[] args) {
		String dataPath = UserConstants.getUsersDataPath();
		List<User> userList = new ArrayList<User>();
		try {
			Files.lines(Paths.get(dataPath)).forEach(userData -> {
				String[] userValues = userData.split("\\|");
				User currentUser = new User(userValues[0], userValues[1], userValues[2], userValues[3], userValues[4],
						userValues[5]);
				userList.add(currentUser);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (User u : userList) {
			System.out.println(u.toString());
		}
	}

}
