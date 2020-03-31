package com.yq.service;

import java.util.List;

import com.yq.po.Favorits;

public interface FavoritsService {
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
	 * ͨ����Աid����Ʒid��ѯ�ҵ��ղ�
	 * 
	 * @param memberID
	 * @param goodsID
	 * @return
	 */
	Favorits queryByMemberIDAndGoodsID(int memberID, int goodsID);

	/**
	 * ͨ����Աid��ȡ��Ӧ�ղؼ���
	 * 
	 * @param memberID
	 * @return
	 */
	List<Favorits> queryFavoritsByMemberID(int memberID);

	/**
	 * ͨ����Աid����Ʒidɾ���ղ�
	 * 
	 @param memberID
	 * @param goodsID
	 * @return
	 */
	int delFavoritsBygoodsID(int memberID, int goodsID);
}
