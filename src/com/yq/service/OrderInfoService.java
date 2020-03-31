package com.yq.service;

import java.util.List;


import com.yq.po.OrderInfo;

public interface OrderInfoService {
	/**
	 * 添加订单
	 * 
	 * @param orderInfo
	 * @return
	 */
	int addOrderInfo(OrderInfo orderInfo);

	/**
	 * 修改订单
	 * 
	 * @param orderInfo
	 * @return
	 */
	int updateOrderInfo(OrderInfo orderInfo);

	/**
	 * 删除订单
	 * 
	 * @param orderID
	 * @return
	 */
	int delOrderInfo(int orderID);

	/**
	 * 通过订单id查询订单
	 * 
	 * @param orderID
	 * @return
	 */
	OrderInfo queryOrderInfoByOrderID(int orderID);

	/**
	 * 通过会员id查询订单
	 * 
	 * @param orderID
	 * @return
	 */
	List<OrderInfo> queryOrderInfoByMemberID(int memberID);

	/**
	 * 查询所有订单
	 * 
	 * @return
	 */
	List<OrderInfo> queryAllOrderInfo();
	
	/**
	 * 通过orderid 和status状态查询订单明细
	 * 
	 * @return
	 */
	List<OrderInfo> queryOrderInfoByIdAndStatus( int orderID, String orderStatus);

	/**
	 * 获取最新添加的订单号
	 * 
	 * @return
	 */
	int getNewDataId(int mid);
}
