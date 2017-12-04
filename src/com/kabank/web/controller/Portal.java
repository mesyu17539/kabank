package com.kabank.web.controller;

import java.util.Scanner;

import com.kabank.web.Impl.AccountServiceImpl;
import com.kabank.web.Impl.MemberServiceImpl;
import com.kabank.web.bean.MemberBean;
import com.kabank.web.service.MemberService;

public class Portal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MemberService memberService = new MemberServiceImpl();
		while (true) {
			System.out.println("[MENU] [0] 종료 [1] 회원가입 [2] 계좌계설 [3] 총회원수 [4] 회원목록");
			switch (scanner.nextInt()) {
			case 0:
				System.out.println("종료");
				return;
			case 1:
				MemberBean memberBean = new MemberBean();
				System.out.println("이름");
				memberBean.setName(scanner.next());
				System.out.println("주민번호");
				memberBean.setSsn(scanner.next());
				memberBean.setCustomNum(memberService.createCustomNum());
				memberBean.setGender(memberService.findGender(memberBean.getSsn()));
				memberBean.setAge(memberService.findAge(memberBean.getSsn()));
				System.out.printf(
						"[고객번호] %d [이름] %s [성별] %s [나이] %d \n"
						, memberBean.getCustomNum() 
						,memberBean.getName()
						,memberBean.getGender()
						,memberBean.getAge()
						);
				memberService.addMem(memberBean);
				break;
			case 2:
				AccountServiceImpl accountService = new AccountServiceImpl();
				accountService.setAccountNum();
				System.out.println(accountService.getAccountNum());
				break;
			case 3:
				break;
			case 4:
				MemberBean[] mem=memberService.list();
				for(int i=0;i<mem.length;i++) {
					System.out.println("배열 "+mem[i].getName());
				}
			}
		}
	}
}
