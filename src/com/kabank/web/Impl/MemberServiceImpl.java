package com.kabank.web.Impl;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.kabank.web.bean.MemberBean;
import com.kabank.web.service.MemberService;

public class MemberServiceImpl implements MemberService {
	private MemberBean[] memberBeans;
	private int count;
	
	public MemberServiceImpl() {
		this.count = 0;
		memberBeans = null;
	}

	public int getCount() {
		return this.count;
	}

	@Override
	public MemberBean[] list() {
		return memberBeans;
	}

	public int createCustomNum() {
		int foo = 0;
		// algorithm
		return foo;
	}

	@Override
	public void addMem(MemberBean memberBean) {
		MemberBean[] newMB = new MemberBean[count];
		if (memberBeans != null) {
			newMB=memberBeans;
		}
		this.memberBeans = new MemberBean[count + 1];
		this.memberBeans[count] = memberBean;
		System.arraycopy(newMB, 0, memberBeans, 0, count);
		count++;
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
				System.out.println(" 1다음 " + foo);
			} else {
				foo = snyear;
				System.out.println(" 2다음 " + foo);
			}
			break;
		case '1':
		case '2':
		case '5':
		case '6':
			if (nowmonth >= snmonth && nowday >= snday) {
				foo = (100 - snyear) + (nowyear % 100);
				System.out.println(" 3다음 " + foo);
			} else {
				foo = (100 - snyear) + (nowyear % 100);
			}
			break;
		}
		return foo;
	}

}
