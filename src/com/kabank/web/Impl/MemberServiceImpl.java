package com.kabank.web.Impl;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Vector;

import com.kabank.web.bean.MemberBean;
import com.kabank.web.service.MemberService;

public class MemberServiceImpl implements MemberService {
	private Vector<MemberBean> memberBeans;
	private MemberBean mybean;
	int number;

	public MemberServiceImpl() {
		memberBeans = new Vector<MemberBean>(10, 10);
		mybean = new MemberBean();
		number=1000;
	}

	@Override
	public int getCount() {
		return memberBeans.size();
	}

	@Override
	public Vector<MemberBean> list() {
		return memberBeans;
	}

	@Override
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
		memberBeans.clear();
	}

	@Override
	public void delete(boolean bool) {
		if (bool) {
			mybean=null;
			for (int i = 0; i < memberBeans.size(); i++) {
				if (mybean.getId().equals(memberBeans.get(i).getId())
						&& mybean.getPass().equals(memberBeans.get(i).getPass())) {
					memberBeans.remove(i);
				}
			}
		}
	}

	@Override
	public String login(MemberBean bean) {
		String foo="아이디 없음";
		for (int i = 0; i < memberBeans.size(); i++) {
//			if(bean.getId().equals(memberBeans.get(i).getId())) {
//				foo=bean.getPass().equals(memberBeans.get(i).getPass())?memberBeans.get(i).getId() + " 님 환영합니다":"비밀번호 틀림";
//				return foo;
//			}
			if(bean.getId().equals(memberBeans.get(i).getId())) {
				if (bean.getPass().equals(memberBeans.get(i).getPass())) {
					mybean=memberBeans.get(i);
					return mybean.getId() + " 님 환영합니다";
				}else {
					return foo= "비밀번호 틀림";
				}
			}
		}
		return foo;
		
	}

	@Override
	public MemberBean findById(String sID) {
		MemberBean bean=new MemberBean();
		for(int i=0;i<memberBeans.size();i++) {
			if(sID.equals(memberBeans.get(i).getId())) {
				bean=memberBeans.get(i);
				break;
			}
		}
		return bean;
	}

	@Override
	public Vector<MemberBean> findByName(String sID) {
		int count=0;
		for(int i=0;i<memberBeans.size();i++) {
			if(sID.equals(memberBeans.get(i).getName())) {
				count++;
			}
		}
		Vector<MemberBean> meBeans=new Vector<MemberBean>(count);
		for(int i=0;i<memberBeans.size();i++) {
			if(sID.equals(memberBeans.get(i).getName())) {
				meBeans.add(memberBeans.get(i));
			}
		}
		
		return meBeans;
	}

	@Override
	public String upDatePass(String pass) {
		mybean.setPass(pass);;
		return "비밀번호확인 : "+mybean.getPass();
	}
}
