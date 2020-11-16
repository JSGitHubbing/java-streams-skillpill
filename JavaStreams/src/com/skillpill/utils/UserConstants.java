package com.skillpill.utils;

public abstract class UserConstants {
	public static String PATH = "";

	public static String getUsersDataPath() {
		return System.getProperty("user.dir") + "\\resources\\users.txt";
	}
}
