package com.yq.service;

import java.util.List;

import com.yq.po.MemberAddressBook;

public interface MemberAddressBookService {
	/**
	 * 添加会员地址
	 * 
	 * @param memberAddressBook
	 * @return
	 */
	int addMemberAddressBook(MemberAddressBook memberAddressBook);

	/**
	 * 修改会员地址
	 * 
	 * @param memberAddressBook
	 * @return
	 */
	int updateMemberAddressBook(MemberAddressBook memberAddressBook);

	/**
	 * 删除会员地址
	 * 
	 * @param id
	 * @return
	 */
	int delMemberAddressBook(int id);

	/**
	 * 通过id 查询会员地址
	 * 
	 * @param id
	 * @return
	 */
	MemberAddressBook queryMemberAddressBookByID(int id);

	/**
	 * 通过memberID(会员id)获得对应地址
	 * 
	 * @param memberID
	 * @return
	 */
	List<MemberAddressBook> queryMemberAddressBooksByMemberID(int memberID);

	/**
	 * 清除数据库之前该会员的默认地址
	 * 
	 * @param mid 会员id
	 * @return
	 */
	int delAddressDefault(int mid);

	/**
	 * 将id 的地址设置为默认地址
	 * 
	 * @param id
	 * @return
	 */
	int updateAddressDefault(int id);

}
