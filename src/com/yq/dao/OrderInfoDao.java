package com.yq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yq.po.OrderInfo;

/**
 * 订单dao层
 *
 */
@Repository(value = "orderInfoDao")
public interface OrderInfoDao {
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
	List<OrderInfo> queryOrderInfoByIdAndStatus(@Param("orderID") int orderID, @Param("orderStatus") String orderStatus);

	/**
	 * 获取最新添加的订单号
	 * 
	 * @return
	 */
	int getNewDataId(int mid);
}
