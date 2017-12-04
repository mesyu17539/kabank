package com.kabank.web.bean;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MemberBean {
	private int customNum;
	private String name;
	private int age;
	private String gender;
	private String ssn;
	
	public void setCustomNum(int customNum) {// setter 저장하기
		this.customNum = customNum;
		// 맴버변수 전역변수
	}

	public int getCustomNum() {// getter 부르기
		return this.customNum;
	}

	public String getGender() {
		return this.gender;
	}
	
	public void setGender(String gender) {
		this.gender=gender;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age=age;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getSsn() {
		return this.ssn;
	}
}
