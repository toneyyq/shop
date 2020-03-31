package com.yq.service;

import java.util.List;


import com.yq.po.OrderInfo;

public interface OrderInfoService {
	/**
	 * ��Ӷ���
	 * 
	 * @param orderInfo
	 * @return
	 */
	int addOrderInfo(OrderInfo orderInfo);

	/**
	 * �޸Ķ���
	 * 
	 * @param orderInfo
	 * @return
	 */
	int updateOrderInfo(OrderInfo orderInfo);

	/**
	 * ɾ������
	 * 
	 * @param orderID
	 * @return
	 */
	int delOrderInfo(int orderID);

	/**
	 * ͨ������id��ѯ����
	 * 
	 * @param orderID
	 * @return
	 */
	OrderInfo queryOrderInfoByOrderID(int orderID);

	/**
	 * ͨ����Աid��ѯ����
	 * 
	 * @param orderID
	 * @return
	 */
	List<OrderInfo> queryOrderInfoByMemberID(int memberID);

	/**
	 * ��ѯ���ж���
	 * 
	 * @return
	 */
	List<OrderInfo> queryAllOrderInfo();
	
	/**
	 * ͨ��orderid ��status״̬��ѯ������ϸ
	 * 
	 * @return
	 */
	List<OrderInfo> queryOrderInfoByIdAndStatus( int orderID, String orderStatus);

	/**
	 * ��ȡ������ӵĶ�����
	 * 
	 * @return
	 */
	int getNewDataId(int mid);
}
