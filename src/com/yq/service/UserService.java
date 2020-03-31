package com.yq.service;

import com.yq.po.User;
/**
 * ÓÃ»§service²ã
 * @author Administrator
 *
 */
public interface UserService {
	/**
	 * µÇÂ¼
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	User login(String userName, String password);

	/**
	 * ×¢²á
	 * 
	 * @param user
	 * @return
	 */
	int register(User user);

	/**
	 * ÐÞ¸Ä
	 * 
	 * @param user
	 * @return
	 */
	int update(User user);

}
