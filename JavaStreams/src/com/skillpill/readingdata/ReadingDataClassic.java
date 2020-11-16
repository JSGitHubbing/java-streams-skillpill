package com.skillpill.readingdata;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.skillpill.utils.User;
import com.skillpill.utils.UserConstants;

public class ReadingDataClassic {
	public static void main(String[] args) {
		String dataPath = UserConstants.getUsersDataPath();

		List<User> userList = new ArrayList<User>();
		List<String> inputData = new ArrayList<String>();
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(dataPath);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		String line;
		try {
			while ((line = br.readLine()) != null) {
				inputData.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String userData : inputData) {
			String[] userValues = userData.split("\\|");
			User currentUser = new User(userValues[0], userValues[1], userValues[2], userValues[3], userValues[4],
					userValues[5]);
			userList.add(currentUser);
		}

		for (User u : userList) {
			System.out.println(u.toString());
		}

	}

}
