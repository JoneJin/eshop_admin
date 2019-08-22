package dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import entity.User;
import util.DBManager;

public class UserCrud {
	static QueryRunner qr = new QueryRunner(DBManager.getDataSourse());
	public static int add(String nickName, String name, String pwd, String sex, String phone, String isAdmin)
			throws Exception {
		String sql = "insert into t_user values(null,?,?,?,?,?,?)";
		return qr.update(sql, nickName, name, pwd, sex, phone, isAdmin);
	}

	public static int delete(int id) throws Exception {
		String sql = "delete from t_user where id = ?";
		return qr.update(sql, id);
	}

	public static List<User> selectAllUser() throws Exception {
		String sql = "select * from t_user";
		return qr.query(sql, new BeanListHandler<User>(User.class));
	}
	
	public User checkUser(String uname, String upwd) throws Exception {
		String sql = "select * from t_user where nickname = ? and password = ?";
		User user = qr.query(sql, new BeanHandler<User>(User.class), uname, upwd);
		return user;
	}

}
