package dao;

import java.util.List;

import entity.User;

public interface IUserCrud {
	
	int add(String nickName, String name, String pwd, String sex, String phone, String isAdmin)
			throws Exception;
	
	int add(User user)throws Exception;
	
	int delete(int id) throws Exception;
	
	int deleteBath(String [] userIds) throws Exception;
	
	List<User> selectAllUser() throws Exception;
	
}
