package service;

import entity.User;

public interface UserService {
	//登录
	User login(String uname,String upwd) throws Exception;
	//注册
	void register(String nickname,String name,String phone,String sex,String pwd,String relpwd)throws Exception;
	//更新
	int update(String nickname, String name, String phone, String sex, String pwd, int id) throws Exception;
}
