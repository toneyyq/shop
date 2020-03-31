package com.yq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yq.po.Goods;

/**
 * 
 * 商品dao层
 */
@Repository(value = "goodsDao")
public interface GoodsDao {
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
	int updateGoodsValid(@Param("goodsID") int goodsID, @Param("isValid") String isValid);

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
	 * @param goodsName 模糊查询
	 * @return
	 */
	List<Goods> queryGoodsByTypeCodeAndGoodsName(@Param("type") String typeCode, @Param("name") String goodsName);

}
