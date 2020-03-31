package com.yq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yq.dao.OrderInfoDao;
import com.yq.po.OrderInfo;
import com.yq.service.OrderInfoService;
@Service("orderInfoService")
public class OrderInfoServiceImpl implements OrderInfoService {
	private OrderInfoDao orderInfoDao;
	@Autowired
	public void setOrderInfoDao(OrderInfoDao orderInfoDao) {
		this.orderInfoDao = orderInfoDao;
	}

	@Override
	public int addOrderInfo(OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		try {
			return orderInfoDao.addOrderInfo(orderInfo);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int updateOrderInfo(OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		try {
			return orderInfoDao.updateOrderInfo(orderInfo);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int delOrderInfo(int orderID) {
		// TODO Auto-generated method stub
		try {
			return orderInfoDao.delOrderInfo(orderID);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public OrderInfo queryOrderInfoByOrderID(int orderID) {
		// TODO Auto-generated method stub
		try {
			return orderInfoDao.queryOrderInfoByOrderID(orderID);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<OrderInfo> queryOrderInfoByMemberID(int memberID) {
		// TODO Auto-generated method stub
		try {
			return orderInfoDao.queryOrderInfoByMemberID(memberID);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<OrderInfo> queryAllOrderInfo() {
		// TODO Auto-generated method stub
		try {
			return orderInfoDao.queryAllOrderInfo();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<OrderInfo> queryOrderInfoByIdAndStatus(int orderID, String orderStatus) {
		// TODO Auto-generated method stub
		try {
			return orderInfoDao.queryOrderInfoByIdAndStatus(orderID, orderStatus);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public int getNewDataId( int mid) {
		// TODO Auto-generated method stub
		try {
			return orderInfoDao.getNewDataId(mid);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

}
