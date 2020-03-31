package com.yq.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yq.po.OrderPayMode;
/**
 * 
 *���ʽdao��
 */
@Repository(value = "orderPayModeDao")
public interface OrderPayModeDao {
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
