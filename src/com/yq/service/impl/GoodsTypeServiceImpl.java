package com.yq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yq.dao.GoodsTypeDao;
import com.yq.po.GoodsType;
import com.yq.service.GoodsTypeService;
@Service("goodsTypeService")
public class GoodsTypeServiceImpl implements GoodsTypeService {
	private GoodsTypeDao goodsTypeDao;
	@Autowired
	public void setGoodsTypeDao(GoodsTypeDao goodsTypeDao) {
		this.goodsTypeDao = goodsTypeDao;
	}

	@Override
	public int addGoodsType(GoodsType goodsType) {
		// TODO Auto-generated method stub
		try {
			return goodsTypeDao.addGoodsType(goodsType);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int updateGoodsType(GoodsType goodsType) {
		// TODO Auto-generated method stub
		try {
			return goodsTypeDao.updateGoodsType(goodsType);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int delGoodsType(int typeID) {
		// TODO Auto-generated method stub
		try {
			return goodsTypeDao.delGoodsType(typeID);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public GoodsType queryGoodsTypeBygoodsTypeID(int goodsTypeID) {
		// TODO Auto-generated method stub
		try {
			return goodsTypeDao.queryGoodsTypeBygoodsTypeID(goodsTypeID);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


	@Override
	public List<GoodsType> queryGoodsTypeByParentID(int parentID) {
		// TODO Auto-generated method stub
		try {
			return goodsTypeDao.queryGoodsTypeByParentID(parentID);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<GoodsType> queryGoodsTypeByIsLeaf(String isLeaf) {
		// TODO Auto-generated method stub
		try {
			return goodsTypeDao.queryGoodsTypeByIsLeaf(isLeaf);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
