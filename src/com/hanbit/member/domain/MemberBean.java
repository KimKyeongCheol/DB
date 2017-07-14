package com.hanbit.member.domain;

public class MemberBean {
	String id,pw,ssn,name,regdate;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String toString(){
		
		return String.format("ID : %s, PW : %s, NAME : %s, SSN: %s, 일자: %s \n", id,pw,name,ssn,regdate);
	}
}
