package com.kabank.web.service;

import java.util.Vector;

import com.kabank.web.bean.MemberBean;

public interface MemberService {
	public int createCustomNum();
	public String findGender(String ssn);
	public int findAge(String ssn);
	public void addMem(MemberBean memberBean);
	public Vector<MemberBean> list();
	public int getCount();
	public void reSetMember();
	public void delete(MemberBean memberBean);
	public MemberBean login(MemberBean memberBean);
}
