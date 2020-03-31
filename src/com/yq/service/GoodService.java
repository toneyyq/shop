package com.yq.service;

import java.util.List;

import com.yq.po.Goods;

public interface GoodService {
	/**
	 * 添加商品
	 * 
	 * @param goods
	 * @return
	 */
	int addGoods(Goods goods);

	/**
	 * 修改商品信息
	 * 
	 * @param goods
	 * @return
	 */
	int updateGoods(Goods goods);

	/**
	 * 修改商品状态
	 * 
	 * @param goodsID
	 * @param isValid
	 * @return
	 */
	int updateGoodsValid(int goodsID, String isValid);

	/**
	 * 删除商品
	 * 
	 * @param goodID
	 * @return
	 */
	int delGoods(int goodID);

	/**
	 * 通过id查询商品
	 * 
	 * @param goodID
	 * @return
	 */
	Goods queryGoodsByGoodsID(int goodID);

	/**
	 * 查询所有商品
	 * 
	 * @return
	 */
	List<Goods> queryAllGoods();

	/**
	 * 查询最新商品
	 * 
	 * @param count 最新商品的数量
	 * @return
	 */
	List<Goods> queryNewGoods(Integer count);

	/**
	 * 通过typeCode查询对应商品集合
	 * 
	 * @param typeCode
	 * @return
	 */
	List<Goods> queryGoodsByTypeCode(String typeCode);

	/**
	 * 通过typeCode和goodsName查询对应商品集合
	 * 
	 * @param typeCode
	 * @param goodsName
	 * @return
	 */
	List<Goods> queryGoodsByTypeCodeAndGoodsName(String typeCode, String goodsName);

}