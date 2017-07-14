package com.hanbit.member.daoImpl;

import java.util.ArrayList;
import java.util.List;

import com.hanbit.member.constants.DB;
import com.hanbit.member.dao.MemberDAO;
import com.hanbit.member.domain.MemberBean;
import java.sql.*;
/*
 * 	객체(인스턴스) 생성방식
 	1. Type instance = new Constructor();
 	2. Shallow copy => getter 에 의한 객체 복제
 */
public class MemberDAOImpl implements MemberDAO{
	public MemberDAOImpl(){
		try {
			Class.forName(DB.DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("DRIVER LOAD FAIL..");
			e.printStackTrace();
		}
	}

	@Override
	public int insert(MemberBean member) {
		int rs=0;
		try {
			rs=DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeUpdate(
					String.format("INSERT INTO %s(%s,%s,%s,%s,%s) VALUES ('%s','%s','%s','%s',SYSDATE)",
							DB.TABLE_MEMBER,DB.MEMBER_ID,DB.MEMBER_PW,DB.MEMBER_NAME,DB.MEMBER_SSN,DB.MEMBER_REGDATE,
							member.getId(),member.getPw(),member.getName(),member.getSsn()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		

	}
	
	@Override
	public List<MemberBean> selectAll() {
		List<MemberBean> list=new ArrayList<>();
		MemberBean member=null;
		try {
			ResultSet rs=DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(String.format("SELECT * FROM %s",DB.TABLE_MEMBER));
			
			while(rs.next()){
				member=new MemberBean();
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setPw(rs.getString(DB.MEMBER_PW));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				member.setRegdate(rs.getString(DB.MEMBER_REGDATE));
				list.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list ;
}

	@Override
	public List<MemberBean> selectByName(String name) {
		List<MemberBean> list=new ArrayList<>();
		MemberBean member=null;
		try {
			ResultSet rs=DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(
					String.format("SELECT * FROM %s WHERE %s='"+name+"'",DB.TABLE_MEMBER,DB.MEMBER_NAME));
			while(rs.next()){
				member=new MemberBean();
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setPw(rs.getString(DB.MEMBER_PW));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				member.setRegdate(rs.getString(DB.MEMBER_REGDATE));
				list.add(member);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
}

	@Override
	public MemberBean selectById(String id) {
		MemberBean member=new MemberBean();
		try {
			Connection conn=DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD);
			Statement stmt=conn.createStatement();
			String sql="SELECT * FROM Member WHERE id='"+id+"'";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()){
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setPw(rs.getString(DB.MEMBER_PW));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				member.setRegdate(rs.getString(DB.MEMBER_REGDATE));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return member;
	}

	@Override
	public int count() {
		int t=0;
		try {
			ResultSet rs=DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeQuery(String.format("SELECT count(*) AS %s FROM %s","count",DB.TABLE_MEMBER));
			if(rs.next()){
				t=Integer.parseInt(rs.getString("count"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}

	@Override
	public int updata(MemberBean member) {
		int rs=0;
		try {
			rs=DriverManager.getConnection(DB.URL,DB.USERID,DB.PASSWORD).createStatement().executeUpdate(String.format("%s", ""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delete(String id) {
		
		return 0;
		// TODO Auto-generated method stub
		
	}

}
