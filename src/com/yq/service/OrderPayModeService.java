package com.yq.service;

import java.util.List;

import com.yq.po.OrderPayMode;

public interface OrderPayModeService {
	/**
	 * 添加付款方式
	 * 
	 * @param orderPayMode
	 * @return
	 */
	int addOrderPayMode(OrderPayMode orderPayMode);

	/**
	 * 修改付款方式
	 * 
	 * @param orderPayMode
	 * @return
	 */
	int updateOrderPayMode(OrderPayMode orderPayMode);

	/**
	 * 删除付款方式
	 * 
	 * @param payID
	 * @return
	 */
	int delOrderPayMode(int payID);

	/**
	 * 通过payID查询付款方式
	 * 
	 * @param payID
	 * @return
	 */
	OrderPayMode queryOrderPayModeByPayID(int payID);

	/**
	 * 查询所有付款方式
	 * 
	 * @return
	 */
	List<OrderPayMode> queryAllOrderPayMode();

}
