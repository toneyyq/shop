package com.yq.service;

import java.util.List;

import com.yq.po.Member;

public interface MemberService {
	/**
	 * ��Ա��¼
	 * 
	 * @param memberName
	 * @param memberPassword
	 * @return
	 */
	Member login(String memberName, String memberPassword);

	/**
	 * �Ƿ�����û�
	 * 
	 * @param name
	 * @return
	 */
	boolean queryByMemberName(String name);

	/**
	 * ��ӻ�Ա
	 * 
	 * @param member
	 * @return
	 */
	int addMember(Member member);

	/**
	 * ��Ա��Ϣ�޸�
	 * 
	 * @param member
	 * @return
	 */
	int update(Member member);

	/**
	 * ��ȡ���л�Ա��Ϣ
	 * 
	 * @return
	 */
	List<Member> queryAllMember();

	/**
	 * ͨ�����ֲ�ѯmember ģ����ѯ
	 * 
	 * @param name
	 * @return
	 */
	List<Member> queryByName(String name);

}
