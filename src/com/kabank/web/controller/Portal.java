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
					+ "[5] 로그인 [6] ID검색 [7] 이름검색 [8] 비번수정 [9] 탈퇴 [10] 회원전체 삭제")) {
			case "0":
				JOptionPane.showMessageDialog(null, "종료");
				return;
			case "1":
				MemberBean memberBean;
//				String[] arr=JOptionPane.showInputDialog("이름/주민번호/id/pass").split("/");
				String[] dum= {
						"김유신/911111-1111111/hong/1",
						"김유신/123123-231111/kim/2",
						"c/823122-3123/3/1",
						"d/723123-44883/4/1",
				};
				for(int i=0;i<dum.length;i++) {
					memberBean = new MemberBean();
					String[] arr=dum[i].split("/");
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
				}
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
				String[] bar=(JOptionPane.showInputDialog("ENTER ID/ PASS 입력")).split("/");
				memberBean = new MemberBean();
				memberBean.setId(bar[0]);
				memberBean.setPass(bar[1]);
				JOptionPane.showMessageDialog(null, memberService.login(memberBean));
				break;
			case "6":
				JOptionPane.showMessageDialog(null, memberService.findById(
						JOptionPane.showInputDialog("Enter SEARCH ID")).toString());
				break;
			case "7":
				JOptionPane.showMessageDialog(null, memberService.findByName(
						JOptionPane.showInputDialog("Enter SEARCH NAME")));
				break;
			case "8":
				JOptionPane.showMessageDialog(null, memberService.upDatePass(
						JOptionPane.showInputDialog("Enter SEARCH 수정할 비밀번호")));
				break; //aasjdkfjlaksdjf
			case "9":
				memberService.delete(JOptionPane.showInputDialog("탈퇴? y or n").equalsIgnoreCase("y"));
				break;
			case "10":
				memberService.reSetMember();
				break;
			}
		}
	}
}
