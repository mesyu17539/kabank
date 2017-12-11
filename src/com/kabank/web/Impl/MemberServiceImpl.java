package com.kabank.web.Impl;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Vector;

import com.kabank.web.bean.MemberBean;
import com.kabank.web.service.MemberService;

public class MemberServiceImpl implements MemberService {
	private Vector<MemberBean> memberBeans;
	int number;
	public MemberServiceImpl() {
		memberBeans= new Vector<MemberBean>(10,10);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return memberBeans.size();
	}

	@Override
	public Vector<MemberBean> list() {
		return memberBeans;
	}

	public int createCustomNum() {
		return number++;
	}

	@Override
	public void addMem(MemberBean memberBean) {
		this.memberBeans.add(memberBean);
	}

	@Override
	public String findGender(String ssn) {
		String foo = "";
		switch (ssn.charAt(7)) {
		case '1':
		case '3':
			foo = "남자";
			break;
		case '2':
		case '4':
			foo = "여자";
			break;
		case '5':
		case '7':
			foo = "외국인 남";
			break;
		case '6':
		case '8':
			foo = "외국인 여자";
			break;
		default:
			foo = "잘못 입력했습니다";
			break;
		}
		return foo;
	}

	public int findAge(String ssn) {
		int foo = 0;
		Calendar calendar = new GregorianCalendar(Locale.KOREA);
		int nowyear = calendar.get(Calendar.YEAR);
		int nowmonth = calendar.get(Calendar.MONTH);
		int nowday = calendar.get(Calendar.DAY_OF_MONTH);
		int snyear = Integer.parseInt(ssn.charAt(0) + "" + ssn.charAt(1));
		int snmonth = Integer.parseInt(ssn.charAt(2) + "" + ssn.charAt(3));
		int snday = Integer.parseInt(ssn.charAt(4) + "" + ssn.charAt(5));
		char ch = ssn.charAt(7);

		switch (ch) {
		case '4':
		case '3':
		case '7':
		case '8':
			if (nowmonth >= snmonth && nowday >= snday) {
				foo = snyear + 1;
			} else {
				foo = snyear;
			}
			break;
		case '1':
		case '2':
		case '5':
		case '6':
			if (nowmonth >= snmonth && nowday >= snday) {
				foo = (100 - snyear) + (nowyear % 100);
			} else {
				foo = (100 - snyear) + (nowyear % 100);
			}
			break;
		}
		return foo;
	}

	@Override
	public void reSetMember() {
		// TODO Auto-generated method stub
		memberBeans.clear();
	}

	@Override
	public void delete(MemberBean bean) {
		for(int i=0;i<memberBeans.size();i++) {
			if(bean.getId().equals(memberBeans.get(i).getId())&&bean.getPass().equals(memberBeans.get(i).getPass())){
				memberBeans.remove(i);
			}
		}
	}

	@Override
	public MemberBean login(MemberBean bean) {
		for(int i=0;i<memberBeans.size();i++) {
			if(bean.getId().equals(memberBeans.get(i).getId())&&bean.getPass().equals(memberBeans.get(i).getPass())){
				return memberBeans.get(i);
			}
		}
		return null;
	}
}
