package com.yq.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yq.po.User;
/**
 * �û�dao��
 *
 */
@Repository(value = "userDao")
public interface UserDao {
	/**
	 * ͨ���û��������ѯ�û�����½
	 * @param userName
	 * @param password
	 * @return
	 */
	User login(@Param("username") String userName,@Param("password")String password)throws Exception;
	
}
