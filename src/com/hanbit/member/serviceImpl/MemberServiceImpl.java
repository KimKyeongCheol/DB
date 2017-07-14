package com.hanbit.member.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.hanbit.member.dao.MemberDAO;
import com.hanbit.member.daoImpl.MemberDAOImpl;
import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.service.MemberService;

public class MemberServiceImpl implements MemberService{
	MemberBean member;
	List<MemberBean> members;
	List<MemberBean> memberByName;
	MemberDAO dao=new MemberDAOImpl();

	public MemberServiceImpl() {
		member=new MemberBean();
		members=new ArrayList<>();
		memberByName=new ArrayList<>();
	} 
	@Override
	public String addMember(MemberBean member) {
		String msg=null;
		MemberDAO dao=new MemberDAOImpl();
		int rs=dao.insert(member);
		msg=rs==1?"가입성공":"가입실패";
		return msg;
	}
	@Override
	public List<MemberBean> getMembers() {
		return dao.selectAll();
	}
	@Override
	public int count() {
		return new MemberDAOImpl().count();
	}
	
	
	@Override
	public MemberBean findById(String id) {
		MemberBean member=new MemberBean();
		MemberDAO dao=new MemberDAOImpl();
		member=dao.selectById(id);
		
		return member;

	}
	
	@Override
	public String modify(MemberBean member) {
		String msg=null;
		for(int i=0;i<members.size();i++){
			if(member.getId().equals(members.get(i).getId())){
				members.get(i).setPw(member.getPw());
				break;
			}
		}
		return msg;	
	}
	@Override
	public String remove(String id) {
		String msg=null;
		for(int i=0;i<members.size();i++){
			if(id.equals(members.get(i).getId())){
				members.remove(i);
				break;
			}
		}
		return msg;
	}
	@Override
	public List<MemberBean> findByName(String name) {
		
		return new MemberDAOImpl().selectByName(name);
	}
	
	
}
