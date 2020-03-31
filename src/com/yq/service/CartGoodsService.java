package com.yq.service;

import java.util.List;

import com.yq.po.CartGoods;

/**
 * 购物车商品dao层
 * 
 * @author Administrator
 *
 */
public interface CartGoodsService {

	/**
	 * 添加购物车商品
	 * 
	 * @param cartGoods
	 * @return
	 */
	int addCartGoods(CartGoods cartGoods);

	/**
	 * 修改购物车商品
	 * 
	 * @param cartGoods
	 * @return
	 */
	int updateCartGoods(CartGoods cartGoods);

	/**
	 * 删除购物车商品
	 * 
	 * @param cartID
	 * @return
	 */
	int deleteCartGoods(int cartID);

	/**
	 * 通过会员id和商品id删除购物车商品
	 * 
	 * @param memberID
	 * @param goodsID
	 * @return
	 */
	int deleteCartGoodsBymemberIDAndGoodsID(int memberID, int goodsID);

	/**
	 * 通过会员id和商品id查询购物车商品
	 * 
	 * @param memberID
	 * @param goodsID
	 * @return
	 */
	CartGoods queryBymemberIDAndgoodsID(int memberID, int goodsID);

	/**
	 * 通过会员id查询购物车商品
	 * 
	 * @param memberID
	 * @return
	 */
	List<CartGoods> queryCartGoodsByMemberId(int memberID);

	/**
	 * 获得购物车内商品数量
	 * 
	 * @param mid
	 * @return
	 */
	int getCount(int mid);
}
