package com.skillpill.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class User {
	private String uuid;
	private String name;
	private LocalDate birthdate;
	private String address;
	private String city;
	private String phoneNumber;

	public User(String uuid, String name, String birthdate, String address, String city, String phoneNumber) {
		super();
		this.uuid = uuid;
		this.name = name;
		this.birthdate = LocalDate.parse(birthdate,
				DateTimeFormatter.ofPattern("dd/MMM/yyyy").withLocale(Locale.ENGLISH));
		this.address = address;
		this.city = city;
		this.phoneNumber = phoneNumber;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public int getAge() {
		return Period.between(birthdate, LocalDate.now()).getYears();
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "User [uuid=" + uuid + ", name=" + name + ", birthdate=" + birthdate + ", address=" + address + ", city="
				+ city + ", phoneNumber=" + phoneNumber + "]";
	}

}
