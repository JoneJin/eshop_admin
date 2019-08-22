package dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import entity.GoodInfo;
import util.DBManager;

public class GoodCrud {
	static 	QueryRunner qr = new QueryRunner(DBManager.getDataSourse());
	public static int add(String goodsName,int parentId,double goodsPrice,String goodsDescription,int goodsStock) throws Exception {
		String sql = "insert into t_good_info values(null,?,?,?,?,null,?)";
		return qr.update(sql,goodsName,goodsDescription,goodsPrice,goodsStock,parentId);
	}
	
	public static List<GoodInfo> selectAllGoodInfo() throws Exception {
		String sql = "select * from t_good_info";
		return qr.query(sql, new BeanListHandler<GoodInfo>(GoodInfo.class));
	}
	
	public static int update(String goodsName,int parentId,double goodsPrice,String goodsDescription,int goodsStock,double goodsDiscount,int id) throws Exception {
		String sql = "update t_good_info set goods_name = ?,goods_description = ? , goods_price = ? , goods_stock = ?,goods_discount = ?,goods_parentid = ? where id = ?";
		return qr.update(sql,goodsName,goodsDescription,goodsPrice,goodsStock,goodsDiscount,parentId,id);
	}
	
	public static int delete(int id) throws Exception {
		String sql = "delete from t_good_info where id = ?";
		return qr.update(sql, id);
	}
}
