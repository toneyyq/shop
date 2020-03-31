package com.yq.service;

import java.util.List;

import com.yq.po.Favorits;

public interface FavoritsService {
	/**
	 * 添加收藏
	 * 
	 * @param favorits
	 * @return
	 */
	int addFavorits(Favorits favorits);

	/**
	 * 删除收藏
	 * 
	 * @param favorits
	 * @return
	 */
	int delFavorits(int id);

	/**
	 * 通过会员id和商品id查询我的收藏
	 * 
	 * @param memberID
	 * @param goodsID
	 * @return
	 */
	Favorits queryByMemberIDAndGoodsID(int memberID, int goodsID);

	/**
	 * 通过会员id获取对应收藏集合
	 * 
	 * @param memberID
	 * @return
	 */
	List<Favorits> queryFavoritsByMemberID(int memberID);

	/**
	 * 通过会员id和商品id删除收藏
	 * 
	 @param memberID
	 * @param goodsID
	 * @return
	 */
	int delFavoritsBygoodsID(int memberID, int goodsID);
}
