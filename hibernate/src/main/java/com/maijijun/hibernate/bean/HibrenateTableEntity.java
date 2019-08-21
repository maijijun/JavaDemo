package com.maijijun.hibernate.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "hibrenateTable", schema = "hibernate-test")
public class HibrenateTableEntity {
	private int id;
	private String name;
	private String sex;
	private int age;
	private int height;
	private int weight;
	private Timestamp time;

	@Id
	@Column(name = "ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "Sex")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Basic
	@Column(name = "Age")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Basic
	@Column(name = "Height")
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Basic
	@Column(name = "Weight")
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Basic
	@Column(name = "Time")
	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		HibrenateTableEntity that = (HibrenateTableEntity) o;
		return id == that.id &&
				age == that.age &&
				height == that.height &&
				weight == that.weight &&
				Objects.equals(name, that.name) &&
				Objects.equals(sex, that.sex) &&
				Objects.equals(time, that.time);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, sex, age, height, weight, time);
	}
}
