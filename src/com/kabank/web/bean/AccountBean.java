package com.kabank.web.bean;

import java.util.Random;

public class AccountBean {
	public int findAccountBean() {
		Random ran=new Random();
		boolean boo=true;
		int a=0;
		while(boo) {
			if(a>100000) {
				a=ran.nextInt(1000000);
				boo=false;
			}
		}
		return a;
	}
}
