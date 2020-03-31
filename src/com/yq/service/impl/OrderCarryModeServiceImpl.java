package com.yq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yq.dao.OrderCarryModeDao;
import com.yq.po.OrderCarryMode;
import com.yq.service.OrderCarryModeService;
@Service("orderCarryModeService")
public class OrderCarryModeServiceImpl implements OrderCarryModeService {
	private OrderCarryModeDao orderCarryModeDao;
	@Autowired
	public void setOrderCarryModeDao(OrderCarryModeDao orderCarryModeDao) {
		this.orderCarryModeDao = orderCarryModeDao;
	}

	@Override
	public int addOrderCarryMode(OrderCarryMode orderCarryMode) {
		// TODO Auto-generated method stub
		try {
			return orderCarryModeDao.addOrderCarryMode(orderCarryMode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int updateOrderCarryMode(OrderCarryMode orderCarryMode) {
		// TODO Auto-generated method stub
		try {
			return orderCarryModeDao.updateOrderCarryMode(orderCarryMode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int delOrderCarryMode(int carryID) {
		// TODO Auto-generated method stub
		try {
			return orderCarryModeDao.delOrderCarryMode(carryID);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public OrderCarryMode queryOrderCarryModeBycarryID(int carryID) {
		// TODO Auto-generated method stub
		try {
			return orderCarryModeDao.queryOrderCarryModeBycarryID(carryID);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
