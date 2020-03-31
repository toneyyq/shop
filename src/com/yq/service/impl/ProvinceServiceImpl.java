package com.yq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yq.dao.ProvinceDao;
import com.yq.po.Province;
import com.yq.service.ProvinceService;

@Service("provinceService")
public class ProvinceServiceImpl implements ProvinceService {
	private ProvinceDao provinceDao;
	@Autowired
	public void setProvinceDao(ProvinceDao provinceDao) {
		this.provinceDao = provinceDao;
	}
	@Override
	public List<Province> queryAllProvince() {
		// TODO Auto-generated method stub
		try {
			return provinceDao.queryAllProvince();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	@Override
	public Province queryProvinceByProvinceCode(String provinceCode) {
		// TODO Auto-generated method stub
		try {
			return provinceDao.queryProvinceByProvinceCode(provinceCode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}



}
