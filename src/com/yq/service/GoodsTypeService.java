package com.yq.service;

import java.util.List;

import com.yq.po.GoodsType;

public interface GoodsTypeService {
	/**
	 * �����Ʒ���
	 * 
	 * @param goodsType
	 * @return
	 */
	int addGoodsType(GoodsType goodsType);

	/**
	 * �޸���Ʒ�����Ϣ
	 * 
	 * @param goodsType
	 * @return
	 */
	int updateGoodsType(GoodsType goodsType);

	/**
	 * ɾ����Ʒ���
	 * 
	 * @param typeID
	 * @return
	 */
	int delGoodsType(int typeID);
	
	/**
	 * ͨ��isleaf ��ѯ��Ʒ���
	 * @param isLeaf
	 * @return
	 */
	List<GoodsType> queryGoodsTypeByIsLeaf(String isLeaf);

	/**
	 * ͨ����Ʒ���id��ѯ��Ʒ�����Ϣ
	 * 
	 * @param goodsTypeID
	 * @return
	 */
	GoodsType queryGoodsTypeBygoodsTypeID(int goodsTypeID);

	

	/**
	 * ͨ��parentID��ѯ���
	 * 
	 * @param typeLevel
	 * @return
	 */
	List<GoodsType> queryGoodsTypeByParentID(int parentID);

}
