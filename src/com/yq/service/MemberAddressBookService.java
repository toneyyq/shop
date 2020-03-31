package com.yq.service;

import java.util.List;

import com.yq.po.MemberAddressBook;

public interface MemberAddressBookService {
	/**
	 * ��ӻ�Ա��ַ
	 * 
	 * @param memberAddressBook
	 * @return
	 */
	int addMemberAddressBook(MemberAddressBook memberAddressBook);

	/**
	 * �޸Ļ�Ա��ַ
	 * 
	 * @param memberAddressBook
	 * @return
	 */
	int updateMemberAddressBook(MemberAddressBook memberAddressBook);

	/**
	 * ɾ����Ա��ַ
	 * 
	 * @param id
	 * @return
	 */
	int delMemberAddressBook(int id);

	/**
	 * ͨ��id ��ѯ��Ա��ַ
	 * 
	 * @param id
	 * @return
	 */
	MemberAddressBook queryMemberAddressBookByID(int id);

	/**
	 * ͨ��memberID(��Աid)��ö�Ӧ��ַ
	 * 
	 * @param memberID
	 * @return
	 */
	List<MemberAddressBook> queryMemberAddressBooksByMemberID(int memberID);

	/**
	 * ������ݿ�֮ǰ�û�Ա��Ĭ�ϵ�ַ
	 * 
	 * @param mid ��Աid
	 * @return
	 */
	int delAddressDefault(int mid);

	/**
	 * ��id �ĵ�ַ����ΪĬ�ϵ�ַ
	 * 
	 * @param id
	 * @return
	 */
	int updateAddressDefault(int id);

}
