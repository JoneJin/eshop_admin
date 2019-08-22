package service.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import entity.User;
import service.UserService;
import util.DBManager;

public class UserServiceImpl implements UserService {

	@Override
	public User login(String uname, String upwd) throws Exception {
		QueryRunner qr = new QueryRunner(DBManager.getDataSourse());
		String sql = "select * from t_user where nickname = ? and password = ?";
		User user = qr.query(sql, new BeanHandler<User>(User.class), uname, upwd);
		return user;
	}

	@Override
	public void register(String nickname, String name, String phone, String sex, String pwd, String relpwd)
			throws Exception {
	}
	@Override
	public int update(String nickname, String name, String phone, String sex, String pwd, int id) throws Exception {
		QueryRunner qr = new QueryRunner(DBManager.getDataSourse());
		String sql = "update t_user set nickname = ?,name = ? , phone = ? , sex = ?,password = ? where id = ?";
		int updateCount = qr.update(sql, nickname, name, phone, sex, pwd, id);
		System.out.println(updateCount);
		return updateCount;
	}
}
