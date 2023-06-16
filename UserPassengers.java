package com.avengers.bus.entityModels;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "btrs_user_passengers")
@IdClass(UserPassengersId.class)
public class UserPassengers {
	@Id
	private int user_id;
	@Id
	private String passenger_name;
	@Id
	private int age;
	@Id
	private String gender;

	@Override
	public String toString() {
		return "UserPassengers [user_id=" + user_id + ", passenger_name=" + passenger_name + ", age=" + age
				+ ", gender=" + gender + "]";
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getPassenger_name() {
		return passenger_name;
	}

	public void setPassenger_name(String passenger_name) {
		this.passenger_name = passenger_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
