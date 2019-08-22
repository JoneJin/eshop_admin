package dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import entity.GoodType;
import util.DBManager;

public class GoodTypeCrud {
	static QueryRunner qr = new QueryRunner(DBManager.getDataSourse());
	
	public static List<GoodType> selectGoodType() throws Exception {
		String sql = "select * from t_good_type";
		return qr.query(sql, new BeanListHandler<GoodType>(GoodType.class));
	}
	
	public static int add(String typeName) throws Exception {
		String sql = "insert into t_good_type values(null,?)";
		return qr.update(sql,typeName);
	}
	
	public static int update(int id,String typeName) throws Exception{
		String sql = "update t_good_type set gyte_name = ? where id = ? ";
		return qr.update(sql, typeName,id);
	}
	
	public static int delete(int id) throws Exception {
		String sql = "delete from t_good_type where id = ?";
		return qr.update(sql, id);
	}
}
