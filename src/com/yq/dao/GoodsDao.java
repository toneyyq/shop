package com.yq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yq.po.Goods;

/**
 * 
 * ��Ʒdao��
 */
@Repository(value = "goodsDao")
public interface GoodsDao {
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
	int updateGoodsValid(@Param("goodsID") int goodsID, @Param("isValid") String isValid);

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
	 * @param goodsName ģ����ѯ
	 * @return
	 */
	List<Goods> queryGoodsByTypeCodeAndGoodsName(@Param("type") String typeCode, @Param("name") String goodsName);

}
