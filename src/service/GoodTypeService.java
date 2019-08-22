package service;

import java.util.List;

import entity.GoodType;

public interface GoodTypeService {
	//显示所有商品
	List<GoodType> selectGoodType() throws Exception;
	//添加类别商品
	int add(String typeName) throws Exception;
	//修改商品
	int update(int id,String typeName) throws Exception;
	//删除商品
	int delete(int id) throws Exception;
}
