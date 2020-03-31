package com.yq.service;

import java.util.List;

import com.yq.po.OrderPayMode;

public interface OrderPayModeService {
	/**
	 * ��Ӹ��ʽ
	 * 
	 * @param orderPayMode
	 * @return
	 */
	int addOrderPayMode(OrderPayMode orderPayMode);

	/**
	 * �޸ĸ��ʽ
	 * 
	 * @param orderPayMode
	 * @return
	 */
	int updateOrderPayMode(OrderPayMode orderPayMode);

	/**
	 * ɾ�����ʽ
	 * 
	 * @param payID
	 * @return
	 */
	int delOrderPayMode(int payID);

	/**
	 * ͨ��payID��ѯ���ʽ
	 * 
	 * @param payID
	 * @return
	 */
	OrderPayMode queryOrderPayModeByPayID(int payID);

	/**
	 * ��ѯ���и��ʽ
	 * 
	 * @return
	 */
	List<OrderPayMode> queryAllOrderPayMode();

}
