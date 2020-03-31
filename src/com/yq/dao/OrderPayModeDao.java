package com.yq.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yq.po.OrderPayMode;
/**
 * 
 *付款方式dao层
 */
@Repository(value = "orderPayModeDao")
public interface OrderPayModeDao {
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
