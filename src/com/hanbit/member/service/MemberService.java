package com.hanbit.member.service;

import java.util.List;

import com.hanbit.member.domain.MemberBean;

public interface MemberService {
	public String addMember(MemberBean member);
	public List<MemberBean> getMembers();
	public int count();
	public MemberBean findById(String id);
	public List<MemberBean> findByName(String name);
	public String modify(MemberBean member);
	public String remove(String id);
}
