package com.yq.dao;

import org.springframework.stereotype.Repository;

import com.yq.po.OrderInvoice;
/**
 * ��Ʊdao��
 *
 */
@Repository(value = "orderInvoiceDao")
public interface OrderInvoiceDao {
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
