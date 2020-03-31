package com.yq.service;

import java.util.List;

import com.yq.po.CartGoods;

/**
 * ���ﳵ��Ʒdao��
 * 
 * @author Administrator
 *
 */
public interface CartGoodsService {

	/**
	 * ��ӹ��ﳵ��Ʒ
	 * 
	 * @param cartGoods
	 * @return
	 */
	int addCartGoods(CartGoods cartGoods);

	/**
	 * �޸Ĺ��ﳵ��Ʒ
	 * 
	 * @param cartGoods
	 * @return
	 */
	int updateCartGoods(CartGoods cartGoods);

	/**
	 * ɾ�����ﳵ��Ʒ
	 * 
	 * @param cartID
	 * @return
	 */
	int deleteCartGoods(int cartID);

	/**
	 * ͨ����Աid����Ʒidɾ�����ﳵ��Ʒ
	 * 
	 * @param memberID
	 * @param goodsID
	 * @return
	 */
	int deleteCartGoodsBymemberIDAndGoodsID(int memberID, int goodsID);

	/**
	 * ͨ����Աid����Ʒid��ѯ���ﳵ��Ʒ
	 * 
	 * @param memberID
	 * @param goodsID
	 * @return
	 */
	CartGoods queryBymemberIDAndgoodsID(int memberID, int goodsID);

	/**
	 * ͨ����Աid��ѯ���ﳵ��Ʒ
	 * 
	 * @param memberID
	 * @return
	 */
	List<CartGoods> queryCartGoodsByMemberId(int memberID);

	/**
	 * ��ù��ﳵ����Ʒ����
	 * 
	 * @param mid
	 * @return
	 */
	int getCount(int mid);
}
