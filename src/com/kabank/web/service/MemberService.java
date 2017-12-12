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
	public String login(MemberBean memberBean);
	public void delete(boolean bool);
	public MemberBean findById(String showInputDialog);
	public Vector<MemberBean> findByName(String showInputDialog);
	public String upDatePass(String showInputDialog);
}
