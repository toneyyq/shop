package com.yq.service;

import java.util.List;

import com.yq.po.GoodsType;

public interface GoodsTypeService {
	/**
	 * 添加商品类别
	 * 
	 * @param goodsType
	 * @return
	 */
	int addGoodsType(GoodsType goodsType);

	/**
	 * 修改商品类别信息
	 * 
	 * @param goodsType
	 * @return
	 */
	int updateGoodsType(GoodsType goodsType);

	/**
	 * 删除商品类别
	 * 
	 * @param typeID
	 * @return
	 */
	int delGoodsType(int typeID);
	
	/**
	 * 通过isleaf 查询商品类别
	 * @param isLeaf
	 * @return
	 */
	List<GoodsType> queryGoodsTypeByIsLeaf(String isLeaf);

	/**
	 * 通过商品类别id查询商品类别信息
	 * 
	 * @param goodsTypeID
	 * @return
	 */
	GoodsType queryGoodsTypeBygoodsTypeID(int goodsTypeID);

	

	/**
	 * 通过parentID查询类别
	 * 
	 * @param typeLevel
	 * @return
	 */
	List<GoodsType> queryGoodsTypeByParentID(int parentID);

}
