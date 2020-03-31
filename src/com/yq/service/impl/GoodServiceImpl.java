package com.yq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yq.dao.GoodsDao;
import com.yq.po.Goods;
import com.yq.service.GoodService;
@Service("goodService")
public class GoodServiceImpl implements GoodService {
	private GoodsDao goodsDao;
	@Autowired
	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	@Override
	public int addGoods(Goods goods) {
		// TODO Auto-generated method stub
		try {
			return goodsDao.addGoods(goods);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		try {
			return goodsDao.updateGoods(goods);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public int delGoods(int goodID) {
		// TODO Auto-generated method stub
		try {
			return goodsDao.delGoods(goodID);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public Goods queryGoodsByGoodsID(int goodID) {
		// TODO Auto-generated method stub
		try {
			return goodsDao.queryGoodsByGoodsID(goodID);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Goods> queryAllGoods() {
		// TODO Auto-generated method stub
		try {
			return goodsDao.queryAllGoods();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Goods> queryGoodsByTypeCode(String typeCode) {
		// TODO Auto-generated method stub
		try {
			return goodsDao.queryGoodsByTypeCode(typeCode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Goods> queryGoodsByTypeCodeAndGoodsName(String typeCode, String goodsName) {
		// TODO Auto-generated method stub
		try {
			return goodsDao.queryGoodsByTypeCodeAndGoodsName(typeCode, goodsName);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public int updateGoodsValid(int goodsID, String isValid) {
		// TODO Auto-generated method stub
		try {
			return goodsDao.updateGoodsValid(goodsID, isValid);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public List<Goods> queryNewGoods(Integer count) {
		// TODO Auto-generated method stub
		try {
			return goodsDao.queryNewGoods(count);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	

}
