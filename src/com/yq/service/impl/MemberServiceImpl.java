package com.yq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yq.dao.MemberDao;
import com.yq.po.Member;
import com.yq.service.MemberService;
@Service("memberService")
public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao;
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public Member login(String name, String password) {
		// TODO Auto-generated method stub
		try {
			return memberDao.queryMemberByMemberNameAndMemberPassword(name, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addMember(Member member) {
		// TODO Auto-generated method stub

		try {
			return memberDao.addMember(member);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Member member) {
		// TODO Auto-generated method stub
		try {
			return memberDao.updateMember(member);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Member> queryAllMember() {
		// TODO Auto-generated method stub
		try {
			return memberDao.queryAllMember();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean queryByMemberName(String name) {
		// TODO Auto-generated method stub
		Member member=memberDao.queryByMemberName(name);
		return member==null?true:false;
		
		
	}

	@Override
	public List<Member> queryByName(String name) {
		// TODO Auto-generated method stub
		try {
			return memberDao.queryByName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
