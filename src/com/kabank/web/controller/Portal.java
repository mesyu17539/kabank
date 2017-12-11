package com.kabank.web.controller;

import java.util.Vector;

import javax.swing.JOptionPane;

import com.kabank.web.Impl.AccountServiceImpl;
import com.kabank.web.Impl.MemberServiceImpl;
import com.kabank.web.bean.MemberBean;
import com.kabank.web.service.MemberService;

public class Portal {
	public static void main(String[] args) {
		MemberService memberService = new MemberServiceImpl();
		while (true) {
			switch (JOptionPane.showInputDialog("[MENU] [0] 종료 [1] 회원가입 [2] 계좌계설 [3] 총회원수 [4] 회원목록\n"
					+ "[5] 로그인 [6] 삭제 [9] 회원전체 삭제")) {
			case "0":
				JOptionPane.showMessageDialog(null, "종료");
				return;
			case "1":
				MemberBean memberBean = new MemberBean();
				String[] arr=JOptionPane.showInputDialog("이름/주민번호/id/pass").split("/");
				memberBean.setName(arr[0]);
				memberBean.setSsn(arr[1]);
				memberBean.setId(arr[2]);
				memberBean.setPass(arr[3]);
				memberBean.setCustomNum(memberService.createCustomNum());
				memberBean.setGender(memberService.findGender(arr[1]));
				memberBean.setAge(memberService.findAge(arr[1]));
				JOptionPane.showMessageDialog(null, String.format(
						"[고객번호] %d [이름] %s [성별] %s [나이] %d [id] %s [pass] %s \n"
						,memberBean.getCustomNum() 
						,memberBean.getName()
						,memberBean.getGender()
						,memberBean.getAge()
						,memberBean.getId()
						,memberBean.getPass()));
				memberService.addMem(memberBean);
				break;
			case "2":
				AccountServiceImpl accountService = new AccountServiceImpl();
				accountService.setAccountNum();
				JOptionPane.showMessageDialog(null, accountService.getAccountNum());
				break;
			case "3":
				JOptionPane.showMessageDialog(null, "총원 : "+memberService.getCount());
				break;
			case "4":
				JOptionPane.showMessageDialog(null, memberService.list());
				break;
			case "5":
				String[] bar=(JOptionPane.showInputDialog("ID/ PASS 입력")).split("/");
				memberBean = new MemberBean();
				memberBean.setId(bar[0]);
				memberBean.setPass(bar[1]);
				memberBean=memberService.login(memberBean);
				String str=(memberBean!=null)?memberBean.getName()+"님 환영합니다":"로그인 실패";
				JOptionPane.showMessageDialog(null, str);
				break;
			case "6":
				bar=(JOptionPane.showInputDialog("삭제하려는 ID/ PASS 입력")).split("/");
				memberBean = new MemberBean();
				memberBean.setId(bar[0]);
				memberBean.setPass(bar[1]);
				memberService.delete(memberBean);
				break;
			case "9":
				memberService.reSetMember();
				break;
			}
		}
	}
}
