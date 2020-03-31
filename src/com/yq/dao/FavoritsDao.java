package com.yq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yq.po.Favorits;

/**
 * 收藏dao层
 *
 */
@Repository(value = "favoritsDao")
public interface FavoritsDao {
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
	 * 通过会员id和商品id删除收藏
	 * 
	 * @param memberID
	 * @param goodsID
	 * @return
	 */
	int delFavoritsBygoodsID(@Param("memberID") int memberID, @Param("goodsID") int goodsID);

	/**
	 * 通过会员id和商品id查询我的收藏
	 * 
	 * @param memberID
	 * @param goodsID
	 * @return
	 */
	Favorits queryByMemberIDAndGoodsID(@Param("memberID") int memberID, @Param("goodsID") int goodsID);

	/**
	 * 通过会员id获取对应收藏集合
	 * 
	 * @param memberID
	 * @return
	 */
	List<Favorits> queryFavoritsByMemberID(int memberID);

}
