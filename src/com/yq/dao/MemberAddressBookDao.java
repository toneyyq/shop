package com.yq.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yq.po.MemberAddressBook;

/**
 * 
 * ��Ա��ַdao��
 */
@Repository(value = "memberAddressBookDao")
public interface MemberAddressBookDao {
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
