package com.yq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yq.po.CartGoods;

/**
 * ���ﳵ��Ʒdao��
 * 
 * @author Administrator
 *
 */
@Repository(value = "cartGoodsDao")
public interface CartGoodsDao {
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
	int deleteCartGoodsByCartID(int cartID);

	/**
	 * ͨ����Աid����Ʒidɾ�����ﳵ��Ʒ
	 * 
	 * @param memberID
	 * @param goodsID
	 * @return
	 */
	int deleteCartGoodsBymemberIDAndGoodsID(@Param("memberID") int memberID, @Param("goodsID") int goodsID);

	/**
	 * ͨ����Աid����Ʒid��ѯ���ﳵ��Ʒ
	 * 
	 * @param memberID
	 * @param goodsID
	 * @return
	 */
	CartGoods queryBymemberIDAndgoodsID(@Param("memberID") int memberID, @Param("goodsID") int goodsID);

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
