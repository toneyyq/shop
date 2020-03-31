package com.yq.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yq.po.GoodsType;

/**
 * 
 * ��Ʒ���dao��
 */
@Repository(value = "goodsTypeDao")
public interface GoodsTypeDao {
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
	List<GoodsType> queryGoodsTypeByParentID( int parentID);

}
