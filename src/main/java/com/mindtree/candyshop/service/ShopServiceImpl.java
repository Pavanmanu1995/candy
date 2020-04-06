package com.mindtree.candyshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.candyshop.entity.Shop;
import com.mindtree.candyshop.exception.ServiceException;
import com.mindtree.candyshop.repository.CandyRepository;
import com.mindtree.candyshop.repository.ShopRepository;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopRepository shopRepository;
	
	

	@Override
	public List<Shop> getShopDetails() throws ServiceException {
		List<Shop> shop=new ArrayList<Shop>();
		try {
			shop=this.shopRepository.findAll();
		} catch (Exception e) {
			throw new ServiceException(e);
		}

		return shop;
	}

	@Override
	public Shop addDataToShop(Shop shop) throws ServiceException {
		Shop shop1=null;
		try {
			shop=shopRepository.save(shop);
			
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
		return shop;
	}

}
