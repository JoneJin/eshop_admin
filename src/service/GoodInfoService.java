package service;

import java.util.List;

import entity.GoodInfo;

public interface GoodInfoService {
	//显示所有商品
	List<GoodInfo> selectAllGoodInfo() throws Exception;
	//添加商品
	int addGood(String goodName,int parentId,double goodPrice,String goodsDescription,int goodsStock) throws Exception;
	//修改商品
	int updateGood(String goodName,int parentId,double goodPrice,String goodsDescription,int goodsStock,double goodsDiscount,int id) throws Exception;
}
