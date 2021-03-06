package com.yq.service;

import com.yq.po.OrderInvoice;

public interface OrderInvoiceService {
	/**
	 * 添加发票
	 * 
	 * @param orderInvoice
	 * @return
	 */
	int addOrderInvoice(OrderInvoice orderInvoice);

	/**
	 * 修改发票
	 * 
	 * @param orderInvoice
	 * @return
	 */
	int updateOrderInvoice(OrderInvoice orderInvoice);

	/**
	 * 删除发票
	 * 
	 * @param invoiceID
	 * @return
	 */
	int delOrderInvoice(int invoiceID);

	/**
	 * 通过invoiceID查询发票
	 * 
	 * @param invoiceID
	 * @return
	 */
	OrderInvoice queryOrderInvoiceByInvoiceID(int invoiceID);
}
