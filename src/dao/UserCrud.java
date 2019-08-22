package dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
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
	
	public static int deleteBath(String [] userIds) throws Exception {
		int count = 0;
		for (String id : userIds) {
			String sql = "delete from t_user where id = ?";
			int update = qr.update(sql,Integer.valueOf(id));
			count++;
		}
		return count;
	}
	public static List<User> selectAllUser() throws Exception {
		String sql = "select * from t_user";
		return qr.query(sql, new BeanListHandler<User>(User.class));
	}

}
