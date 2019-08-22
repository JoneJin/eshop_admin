package entity;

public class User {
	private int id; //用户id
	private String nickname; //用户名
	private String name; // 用户姓名
	private String password; // 用户密码
	private String sex; // 用户性别
	private String phone; // 用户手机号码
	private String is_admin; // 是否是管理员

	public User() {
	}

	public User(int id, String nickname, String name, String password, String sex, String phone, String is_admin) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.phone = phone;
		this.is_admin = is_admin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIs_admin() {
		return is_admin;
	}

	public void setIs_admin(String is_admin) {
		this.is_admin = is_admin;
	}

}
