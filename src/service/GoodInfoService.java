package service;

import java.util.List;

import entity.GoodInfo;

public interface GoodInfoService {
	//��ʾ������Ʒ
	List<GoodInfo> selectAllGoodInfo() throws Exception;
	//�����Ʒ
	int addGood(String goodName,int parentId,double goodPrice,String goodsDescription,int goodsStock) throws Exception;
	//�޸���Ʒ
	int updateGood(String goodName,int parentId,double goodPrice,String goodsDescription,int goodsStock,double goodsDiscount,int id) throws Exception;
}
