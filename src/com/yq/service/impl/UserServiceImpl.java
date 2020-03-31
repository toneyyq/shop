package com.yq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yq.dao.UserDao;
import com.yq.po.User;
import com.yq.service.UserService;
/**
 * 
 * 用户service层实现
 *
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User login(String userName, String password) {
		// TODO Auto-generated method stub
		try {
			return userDao.login(userName, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public int register(User user) {
		// TODO Auto-generated method stub
		try {
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		try {
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
