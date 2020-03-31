package com.yq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yq.po.Member;


/**
 * 
 *��Աdao��
 */
@Repository(value = "memberDao")
public interface MemberDao {
	/**
	 * ͨ����Ա�������룬��ȡ��Ӧ��Ա����
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	Member queryMemberByMemberNameAndMemberPassword(@Param("name") String name,@Param("password") String password);
	/**
	 * ͨ����Ա����ѯ��Ա
	 * @param name	
	 * @return
	 */
	Member queryByMemberName(String name);

	/**
	 * ��ӻ�Ա
	 * 
	 * @param member
	 * @return
	 */
	int addMember(Member member);

	/**
	 * �޸Ļ�Ա��Ϣ
	 * 
	 * @param member
	 * @return
	 */
	int updateMember(Member member);
	

	/**
	 * ��ȡ���л�Ա��Ϣ
	 * 
	 * @return
	 */
	List<Member> queryAllMember();
	/**
	 * ͨ�����ֲ�ѯmember    ģ����ѯ
	 * @param name
	 * @return
	 */
	List<Member> queryByName(@Param("name") String name);
}
