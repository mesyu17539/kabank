package com.kabank.web.bean;

public class MemberBean {
	private int customNum, age;
	private String name, id, gender, pass, ssn;
	public int getCustomNum() {
		return customNum;
	}
	public void setCustomNum(int customNum) {
		this.customNum = customNum;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	@Override
	public String toString() {
		return "회원정보 [고객번호=" + customNum + ", 나이=" + age + ", 이름=" + name + ", id=" + id + ", 성별="
				+ gender + ", pass=" + pass + ", 주민번호=" + ssn + "]\n";
	}

}
