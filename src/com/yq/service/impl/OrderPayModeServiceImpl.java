package com.yq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yq.dao.OrderPayModeDao;
import com.yq.po.OrderPayMode;
import com.yq.service.OrderPayModeService;
@Service("orderPayModeService")
public class OrderPayModeServiceImpl implements OrderPayModeService {
	private OrderPayModeDao orderPayModeDao;
	@Autowired
	public void setOrderPayModeDao(OrderPayModeDao orderPayModeDao) {
		this.orderPayModeDao = orderPayModeDao;
	}

	@Override
	public int addOrderPayMode(OrderPayMode orderPayMode) {
		// TODO Auto-generated method stub
		try {
			return orderPayModeDao.addOrderPayMode(orderPayMode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int updateOrderPayMode(OrderPayMode orderPayMode) {
		// TODO Auto-generated method stub
		try {
			return orderPayModeDao.updateOrderPayMode(orderPayMode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int delOrderPayMode(int payID) {
		// TODO Auto-generated method stub
		try {
			return orderPayModeDao.delOrderPayMode(payID);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public OrderPayMode queryOrderPayModeByPayID(int payID) {
		// TODO Auto-generated method stub
		try {
			return orderPayModeDao.queryOrderPayModeByPayID(payID);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<OrderPayMode> queryAllOrderPayMode() {
		// TODO Auto-generated method stub
		try {
			return orderPayModeDao.queryAllOrderPayMode();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
