package com.skplanet.project2.model;

import org.springframework.stereotype.Repository;

@Repository
public class UserDTO {
	
	private String uId;
	private String uPw;
	private String uNickname;
	private int count;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuPw() {
		return uPw;
	}
	public void setuPw(String uPw) {
		this.uPw = uPw;
	}
	public String getuNickname() {
		return uNickname;
	}
	public void setuNickname(String uNickname) {
		this.uNickname = uNickname;
	}
}
