package com.yq.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yq.po.User;
/**
 * 用户dao层
 *
 */
@Repository(value = "userDao")
public interface UserDao {
	/**
	 * 通过用户名密码查询用户，登陆
	 * @param userName
	 * @param password
	 * @return
	 */
	User login(@Param("username") String userName,@Param("password")String password)throws Exception;
	
}
