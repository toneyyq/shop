package com.yq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yq.dao.OrderInvoiceDao;
import com.yq.po.OrderInvoice;
import com.yq.service.OrderInvoiceService;
@Service("orderInvoiceService")
public class OrderInvoiceServiceImpl implements OrderInvoiceService {
	private OrderInvoiceDao orderInvoiceDao;
	@Autowired
	public void setOrderInvoiceDao(OrderInvoiceDao orderInvoiceDao) {
		this.orderInvoiceDao = orderInvoiceDao;
	}

	@Override
	public int addOrderInvoice(OrderInvoice orderInvoice) {
		// TODO Auto-generated method stub
		try {
			return orderInvoiceDao.addOrderInvoice(orderInvoice);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int updateOrderInvoice(OrderInvoice orderInvoice) {
		// TODO Auto-generated method stub
		try {
			return orderInvoiceDao.updateOrderInvoice(orderInvoice);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int delOrderInvoice(int invoiceID) {
		// TODO Auto-generated method stub
		try {
			return orderInvoiceDao.delOrderInvoice(invoiceID);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public OrderInvoice queryOrderInvoiceByInvoiceID(int invoiceID) {
		// TODO Auto-generated method stub
		try {
			return orderInvoiceDao.queryOrderInvoiceByInvoiceID(invoiceID);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
