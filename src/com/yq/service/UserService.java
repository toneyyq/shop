package com.yq.service;

import com.yq.po.User;
/**
 * �û�service��
 * @author Administrator
 *
 */
public interface UserService {
	/**
	 * ��¼
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	User login(String userName, String password);

	/**
	 * ע��
	 * 
	 * @param user
	 * @return
	 */
	int register(User user);

	/**
	 * �޸�
	 * 
	 * @param user
	 * @return
	 */
	int update(User user);

}
