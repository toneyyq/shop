package com.yq.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yq.po.MemberAddressBook;

/**
 * 
 * 会员地址dao层
 */
@Repository(value = "memberAddressBookDao")
public interface MemberAddressBookDao {
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
