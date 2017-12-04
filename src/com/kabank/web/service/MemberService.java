package com.kabank.web.service;

import com.kabank.web.bean.MemberBean;

public interface MemberService {
	public int createCustomNum();
	public String findGender(String ssn);
	public int findAge(String ssn);
	public void addMem(MemberBean memberBean);
	public MemberBean[] list();
	public int getCount();
}
