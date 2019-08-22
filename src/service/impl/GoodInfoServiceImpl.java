package service.impl;

import java.util.List;

import dao.GoodCrud;
import entity.GoodInfo;
import service.GoodInfoService;

public class GoodInfoServiceImpl implements GoodInfoService{
	//��ʾ������Ʒ��Ϣ
	@Override
	public List<GoodInfo> selectAllGoodInfo() throws Exception {
		List<GoodInfo> selectAllGoodInfo = GoodCrud.selectAllGoodInfo();
		return selectAllGoodInfo;
	}
	//�����Ʒ��Ϣ
	@Override
	public int addGood(String goodsName, int parentId, double goodsPrice, String goodsDescription,int goodsStock) throws Exception {
		int addCount = GoodCrud.add(goodsName, parentId, goodsPrice, goodsDescription, goodsStock);
		return addCount;
	}
	//�޸���Ʒ��Ϣ
	@Override
	public int updateGood(String goodName, int parentId, double goodPrice, String goodsDescription, int goodsStock,
			double goodsDiscount,int id) throws Exception {
		int updCount = GoodCrud.update(goodName, parentId, goodPrice, goodsDescription, goodsStock, goodsDiscount,id);
		return updCount;
	}
	
}
