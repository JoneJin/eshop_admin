package controller;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserCrud;
import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet{
	private UserService userService = new UserServiceImpl();
	//用户登录
	protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String uname = req.getParameter("nickname");
		String upwd = req.getParameter("pwd");
		HttpSession session = req.getSession();
		User user = null;
		try {
			user = userService.login(uname, upwd);
			if (user != null && user.getIs_admin().equals("是")) {
				session.setAttribute("user", user);
				resp.sendRedirect(req.getContextPath()+"/navigation.jsp");
			} else {
				session.setAttribute("error", "用户名或密码错误");
				session.setAttribute("qx", "x");
				resp.sendRedirect(req.getContextPath() + "/adminLogin.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//查询所有用户信息
	protected void selectAllUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		List<User> userList = null;
		HttpSession session = req.getSession();
		try {
			userList = UserCrud.selectAllUser();
			if (userList != null) {
				session.setAttribute("userList", userList);
				req.getRequestDispatcher("/userInfo.jsp").forward(req, resp);
			} else {
				resp.getWriter().write("服务器内部错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//删除用户信息
	protected void deleteOneUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String id = req.getParameter("id"); //用户id
		String ids = req.getParameter("ids");
		//将字符串进行切割
		int delCount = 0;
		try {
			if(id != null) {
			   delCount = UserCrud.delete(Integer.valueOf(id));
			}
			int batchCount = 0;
			if(ids != null) {
				String[] userIds = ids.split("-");
				batchCount = UserCrud.deleteBath(userIds);
			}
			if(delCount>0 || batchCount>0) {
				req.getRequestDispatcher("/UserServlet?method=selectAllUsers").forward(req, resp);
			}else {
				resp.getWriter().write("删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//添加用户信息
	protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		try {
			Class clazz = User.class;
			User user  = (User)clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				String name = field.getName();
				field.setAccessible(true);
				Class typeName = field.getType();
				if(typeName.equals("int")) {
					field.setInt(user, Integer.valueOf(req.getParameter(name)));
				}else {
					field.set(user, req.getParameter(name));
				}
			}
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		}
		
		String nickName = req.getParameter("nickname");
		String name = req.getParameter("name");
		String upwd = req.getParameter("pwd");
		String phone = req.getParameter("phone");
		String usex = req.getParameter("sex");
		String isAdmin = req.getParameter("is_admin");
		
		try {
			int addCount = UserCrud.add(nickName, name, upwd, usex, phone, isAdmin);
			if(addCount>0) {
				req.getRequestDispatcher("/UserServlet?method=selectAllUsers").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//修改用户信息
	protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String nickname = req.getParameter("nickname");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String sex = req.getParameter("sex");
		String pwd = req.getParameter("pwd");
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		
		int ids = Integer.valueOf(id);
		UserService userService = new UserServiceImpl();
		try {
			int updateCount = userService.update(nickname, name, phone, sex, pwd, ids);
			if (updateCount > 0){
				req.getRequestDispatcher("/UserServlet?method=selectAllUsers").forward(req, resp);
			} else {
				resp.getWriter().write("更新失败");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.获取当前servelt的字节码文件对象
		Class<? extends UserServlet> clazz = this.getClass();
		String methodName = req.getParameter("method");
		try {
           Method method = clazz.getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
		   method.invoke(this, req,resp);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
