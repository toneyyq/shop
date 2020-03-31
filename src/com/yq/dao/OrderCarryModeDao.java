package com.yq.dao;

import org.springframework.stereotype.Repository;

import com.yq.po.OrderCarryMode;
/**
 * 
 *�ͻ���ʽdao��
 */
@Repository(value = "orderCarryModeDao")
public interface OrderCarryModeDao {
	/**
	 * ����ͻ���ʽ
	 * 
	 * @param orderCarryMode
	 * @return
	 */
	int addOrderCarryMode(OrderCarryMode orderCarryMode);

	/**
	 * �޸��ͻ���ʽ
	 * 
	 * @param orderCarryMode
	 * @return
	 */
	int updateOrderCarryMode(OrderCarryMode orderCarryMode);

	/**
	 * ɾ���ͻ���ʽ
	 * 
	 * @param carryID
	 * @return
	 */
	int delOrderCarryMode(int carryID);

	/**
	 * ͨ��carryID��ѯ�ͻ���ʽ
	 * 
	 * @param carryID
	 * @return
	 */
	OrderCarryMode queryOrderCarryModeBycarryID(int carryID);

}
