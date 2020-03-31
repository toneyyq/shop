package com.yq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yq.dao.MemberAddressBookDao;
import com.yq.po.MemberAddressBook;
import com.yq.service.MemberAddressBookService;
@Service("memberAddressBookService")
public class MemberAddressBookServiceImpl implements MemberAddressBookService {
	private MemberAddressBookDao memberAddressBookDao;
	@Autowired
	public void setMemberAddressBookDao(MemberAddressBookDao memberAddressBookDao) {
		this.memberAddressBookDao = memberAddressBookDao;
	}

	@Override
	public int addMemberAddressBook(MemberAddressBook memberAddressBook) {
		// TODO Auto-generated method stub
		try {
			return memberAddressBookDao.addMemberAddressBook(memberAddressBook);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int updateMemberAddressBook(MemberAddressBook memberAddressBook) {
		// TODO Auto-generated method stub
		try {
			return memberAddressBookDao.updateMemberAddressBook(memberAddressBook);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int delMemberAddressBook(int id) {
		// TODO Auto-generated method stub
		try {
			return memberAddressBookDao.delMemberAddressBook(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public MemberAddressBook queryMemberAddressBookByID(int id) {
		// TODO Auto-generated method stub
		try {
			return memberAddressBookDao.queryMemberAddressBookByID(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<MemberAddressBook> queryMemberAddressBooksByMemberID(int memberID) {
		// TODO Auto-generated method stub
		try {
			return memberAddressBookDao.queryMemberAddressBooksByMemberID(memberID);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public int delAddressDefault(int mid) {
		// TODO Auto-generated method stub
		try {
			return memberAddressBookDao.delAddressDefault(mid);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int updateAddressDefault(int id) {
		// TODO Auto-generated method stub
		try {
			return memberAddressBookDao.updateAddressDefault(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

}
