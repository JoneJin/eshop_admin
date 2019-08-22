package entity;

public class GoodInfo {
	private int id; //商品信息id
	private String goods_name; //商品名称
	private String goods_description; //商品描述
	private double goods_price; //商品的价格
	private int goods_stock; //商品的库存
	private double goods_discount; //商品折扣
	private int goods_parentid; //所属大类
	
	public GoodInfo() {
	
	}
	public GoodInfo(int id, String goods_name, String goods_description, double goods_price, int goods_stock,
			double goods_discount, int goods_parentid) {
		super();
		this.id = id;
		this.goods_name = goods_name;
		this.goods_description = goods_description;
		this.goods_price = goods_price;
		this.goods_stock = goods_stock;
		this.goods_discount = goods_discount;
		this.goods_parentid = goods_parentid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getGoods_description() {
		return goods_description;
	}
	public void setGoods_description(String goods_description) {
		this.goods_description = goods_description;
	}
	public double getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}
	public int getGoods_stock() {
		return goods_stock;
	}
	public void setGoods_stock(int goods_stock) {
		this.goods_stock = goods_stock;
	}
	public double getGoods_discount() {
		return goods_discount;
	}
	public void setGoods_discount(double goods_discount) {
		this.goods_discount = goods_discount;
	}
	public int getGoods_parentid() {
		return goods_parentid;
	}
	public void setGoods_parentid(int goods_parentid) {
		this.goods_parentid = goods_parentid;
	}
}
