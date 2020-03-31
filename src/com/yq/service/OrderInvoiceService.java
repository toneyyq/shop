package com.yq.service;

import com.yq.po.OrderInvoice;

public interface OrderInvoiceService {
	/**
	 * ��ӷ�Ʊ
	 * 
	 * @param orderInvoice
	 * @return
	 */
	int addOrderInvoice(OrderInvoice orderInvoice);

	/**
	 * �޸ķ�Ʊ
	 * 
	 * @param orderInvoice
	 * @return
	 */
	int updateOrderInvoice(OrderInvoice orderInvoice);

	/**
	 * ɾ����Ʊ
	 * 
	 * @param invoiceID
	 * @return
	 */
	int delOrderInvoice(int invoiceID);

	/**
	 * ͨ��invoiceID��ѯ��Ʊ
	 * 
	 * @param invoiceID
	 * @return
	 */
	OrderInvoice queryOrderInvoiceByInvoiceID(int invoiceID);
}
