package com.yq.service;

import com.yq.po.OrderCarryMode;

public interface OrderCarryModeService {
	/**
	 * 添加送货方式
	 * 
	 * @param orderCarryMode
	 * @return
	 */
	int addOrderCarryMode(OrderCarryMode orderCarryMode);

	/**
	 * 修改送货方式
	 * 
	 * @param orderCarryMode
	 * @return
	 */
	int updateOrderCarryMode(OrderCarryMode orderCarryMode);

	/**
	 * 删除送货方式
	 * 
	 * @param carryID
	 * @return
	 */
	int delOrderCarryMode(int carryID);

	/**
	 * 通过carryID查询送货方式
	 * 
	 * @param carryID
	 * @return
	 */
	OrderCarryMode queryOrderCarryModeBycarryID(int carryID);
}
