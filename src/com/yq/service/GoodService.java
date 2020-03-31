package com.yq.service;

import java.util.List;

import com.yq.po.Goods;

public interface GoodService {
	/**
	 * �����Ʒ
	 * 
	 * @param goods
	 * @return
	 */
	int addGoods(Goods goods);

	/**
	 * �޸���Ʒ��Ϣ
	 * 
	 * @param goods
	 * @return
	 */
	int updateGoods(Goods goods);

	/**
	 * �޸���Ʒ״̬
	 * 
	 * @param goodsID
	 * @param isValid
	 * @return
	 */
	int updateGoodsValid(int goodsID, String isValid);

	/**
	 * ɾ����Ʒ
	 * 
	 * @param goodID
	 * @return
	 */
	int delGoods(int goodID);

	/**
	 * ͨ��id��ѯ��Ʒ
	 * 
	 * @param goodID
	 * @return
	 */
	Goods queryGoodsByGoodsID(int goodID);

	/**
	 * ��ѯ������Ʒ
	 * 
	 * @return
	 */
	List<Goods> queryAllGoods();

	/**
	 * ��ѯ������Ʒ
	 * 
	 * @param count ������Ʒ������
	 * @return
	 */
	List<Goods> queryNewGoods(Integer count);

	/**
	 * ͨ��typeCode��ѯ��Ӧ��Ʒ����
	 * 
	 * @param typeCode
	 * @return
	 */
	List<Goods> queryGoodsByTypeCode(String typeCode);

	/**
	 * ͨ��typeCode��goodsName��ѯ��Ӧ��Ʒ����
	 * 
	 * @param typeCode
	 * @param goodsName
	 * @return
	 */
	List<Goods> queryGoodsByTypeCodeAndGoodsName(String typeCode, String goodsName);

}