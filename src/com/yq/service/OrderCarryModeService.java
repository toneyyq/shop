package com.yq.service;

import com.yq.po.OrderCarryMode;

public interface OrderCarryModeService {
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
