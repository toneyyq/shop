package com.yq.service;

import java.util.List;

import com.yq.po.Member;

public interface MemberService {
	/**
	 * 会员登录
	 * 
	 * @param memberName
	 * @param memberPassword
	 * @return
	 */
	Member login(String memberName, String memberPassword);

	/**
	 * 是否存在用户
	 * 
	 * @param name
	 * @return
	 */
	boolean queryByMemberName(String name);

	/**
	 * 添加会员
	 * 
	 * @param member
	 * @return
	 */
	int addMember(Member member);

	/**
	 * 会员信息修改
	 * 
	 * @param member
	 * @return
	 */
	int update(Member member);

	/**
	 * 获取所有会员信息
	 * 
	 * @return
	 */
	List<Member> queryAllMember();

	/**
	 * 通过名字查询member 模糊查询
	 * 
	 * @param name
	 * @return
	 */
	List<Member> queryByName(String name);

}
