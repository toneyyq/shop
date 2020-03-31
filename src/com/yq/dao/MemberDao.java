package com.yq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yq.po.Member;


/**
 * 
 *会员dao层
 */
@Repository(value = "memberDao")
public interface MemberDao {
	/**
	 * 通过会员名和密码，获取对应会员对象
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	Member queryMemberByMemberNameAndMemberPassword(@Param("name") String name,@Param("password") String password);
	/**
	 * 通过会员名查询会员
	 * @param name	
	 * @return
	 */
	Member queryByMemberName(String name);

	/**
	 * 添加会员
	 * 
	 * @param member
	 * @return
	 */
	int addMember(Member member);

	/**
	 * 修改会员信息
	 * 
	 * @param member
	 * @return
	 */
	int updateMember(Member member);
	

	/**
	 * 获取所有会员信息
	 * 
	 * @return
	 */
	List<Member> queryAllMember();
	/**
	 * 通过名字查询member    模糊查询
	 * @param name
	 * @return
	 */
	List<Member> queryByName(@Param("name") String name);
}
