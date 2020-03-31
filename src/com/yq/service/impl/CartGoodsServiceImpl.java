package com.yq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yq.dao.CartGoodsDao;
import com.yq.po.CartGoods;
import com.yq.service.CartGoodsService;

@Service(value = "cartGoodsService")
public class CartGoodsServiceImpl implements CartGoodsService {
	private CartGoodsDao cartGoodsDao;

	@Autowired
	public void setCartGoodsDao(CartGoodsDao cartGoodsDao) {
		this.cartGoodsDao = cartGoodsDao;
	}

	@Override
	public List<CartGoods> queryCartGoodsByMemberId(int memberID) {
		// TODO Auto-generated method stub
		try {
			return cartGoodsDao.queryCartGoodsByMemberId(memberID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addCartGoods(CartGoods cartGoods) {
		// TODO Auto-generated method stub
		try {
			return cartGoodsDao.addCartGoods(cartGoods);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateCartGoods(CartGoods cartGoods) {
		// TODO Auto-generated method stub
		try {
			return cartGoodsDao.updateCartGoods(cartGoods);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteCartGoods(int cartID) {
		// TODO Auto-generated method stub
		try {
			return cartGoodsDao.deleteCartGoodsByCartID(cartID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public CartGoods queryBymemberIDAndgoodsID(int memberID, int goodsID) {
		// TODO Auto-generated method stub
		try {
			return cartGoodsDao.queryBymemberIDAndgoodsID(memberID, goodsID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteCartGoodsBymemberIDAndGoodsID(int memberID, int goodsID) {
		// TODO Auto-generated method stub
		try {
			return cartGoodsDao.deleteCartGoodsBymemberIDAndGoodsID(memberID, goodsID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int getCount(int mid) {
		// TODO Auto-generated method stub
		try {
			return cartGoodsDao.getCount(mid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
