package com.yq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yq.po.OrderInfo;

/**
 * ����dao��
 *
 */
@Repository(value = "orderInfoDao")
public interface OrderInfoDao {
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
	List<OrderInfo> queryOrderInfoByIdAndStatus(@Param("orderID") int orderID, @Param("orderStatus") String orderStatus);

	/**
	 * ��ȡ������ӵĶ�����
	 * 
	 * @return
	 */
	int getNewDataId(int mid);
}
