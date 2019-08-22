package entity;

public class GoodType {
	private int id; //商品类别id
	private String gyte_name; //商品类别名
	
	public GoodType() {
		
	}

	public GoodType(int id, String gyte_name) {
		super();
		this.id = id;
		this.gyte_name = gyte_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGyte_name() {
		return gyte_name;
	}

	public void setGyte_name(String gyte_name) {
		this.gyte_name = gyte_name;
	}
	
}
