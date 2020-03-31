package com.yq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yq.dao.CityDao;
import com.yq.po.City;
import com.yq.service.CityService;
@Service("cityService")
public class CityServiceImpl implements CityService {
	private CityDao cityDao;
	@Autowired
	public void setCityDao(CityDao cityDao) {
		this.cityDao = cityDao;
	}


	@Override
	public List<City> queryAllCityByProvinceCode(String provinceCode) {
		try {
			// TODO Auto-generated method stub
			return cityDao.queryAllCityByProvinceCode(provinceCode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


	@Override
	public City queryCityByCityCode(String cityCode) {
		// TODO Auto-generated method stub
		try {
			// TODO Auto-generated method stub
			return cityDao.queryCityByCityCode(cityCode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
