package service.impl;

import java.util.List;

import dao.GoodTypeCrud;
import entity.GoodType;
import service.GoodTypeService;

public class GoodTypeServiceImpl implements GoodTypeService{

	@Override
	public List<GoodType> selectGoodType() throws Exception {
		return GoodTypeCrud.selectGoodType();
	}

	@Override
	public int add(String typeName) throws Exception {
		return GoodTypeCrud.add(typeName);
	}

	@Override
	public int update(int id, String typeName) throws Exception {
		return GoodTypeCrud.update(id, typeName);
	}

	@Override
	public int delete(int id) throws Exception {
		return GoodTypeCrud.delete(id);
	}
}
