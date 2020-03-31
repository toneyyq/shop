package com.yq.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yq.po.Placard;

/**
 * 公告dao层
 */
@Repository(value = "placardDao")
public interface PlacardDao {

	/**
	 * 添加公告
	 * 
	 * @param placard
	 * @return
	 */
	int addPlacard(Placard placard);

	/**
	 * 修改公告
	 * 
	 * @param placard
	 * @return
	 */
	int updatePlacard(Placard placard);

	/**
	 * 删除公告
	 * 
	 * @param id
	 * @return
	 */
	int deletePlacard(int id);

	/**
	 * 通过公告id查询公告
	 * 
	 * @param id
	 * @return
	 */
	Placard queryPlacardById(int id);

	/**
	 * 获取所有公告
	 * 
	 * @return
	 */
	List<Placard> queryAllPlacard();

}
