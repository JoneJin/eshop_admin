package service;

import java.util.List;

import entity.GoodType;

public interface GoodTypeService {
	//��ʾ������Ʒ
	List<GoodType> selectGoodType() throws Exception;
	//��������Ʒ
	int add(String typeName) throws Exception;
	//�޸���Ʒ
	int update(int id,String typeName) throws Exception;
	//ɾ����Ʒ
	int delete(int id) throws Exception;
}
