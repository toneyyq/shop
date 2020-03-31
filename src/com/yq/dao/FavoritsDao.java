package com.yq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yq.po.Favorits;

/**
 * �ղ�dao��
 *
 */
@Repository(value = "favoritsDao")
public interface FavoritsDao {
	/**
	 * ����ղ�
	 * 
	 * @param favorits
	 * @return
	 */
	int addFavorits(Favorits favorits);

	/**
	 * ɾ���ղ�
	 * 
	 * @param favorits
	 * @return
	 */
	int delFavorits(int id);

	/**
	 * ͨ����Աid����Ʒidɾ���ղ�
	 * 
	 * @param memberID
	 * @param goodsID
	 * @return
	 */
	int delFavoritsBygoodsID(@Param("memberID") int memberID, @Param("goodsID") int goodsID);

	/**
	 * ͨ����Աid����Ʒid��ѯ�ҵ��ղ�
	 * 
	 * @param memberID
	 * @param goodsID
	 * @return
	 */
	Favorits queryByMemberIDAndGoodsID(@Param("memberID") int memberID, @Param("goodsID") int goodsID);

	/**
	 * ͨ����Աid��ȡ��Ӧ�ղؼ���
	 * 
	 * @param memberID
	 * @return
	 */
	List<Favorits> queryFavoritsByMemberID(int memberID);

}
