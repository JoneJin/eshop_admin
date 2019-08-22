package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.GoodInfoService;
import service.GoodTypeService;
import service.impl.GoodInfoServiceImpl;
import service.impl.GoodTypeServiceImpl;
@WebServlet("/updateGoodType")
public class UpdateGoodTypeServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String goodTypeName = req.getParameter("goodTypeName");
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		int ids = Integer.valueOf(id);
		GoodTypeService goodTypeService = new GoodTypeServiceImpl();
		try {
			int updateCount = goodTypeService.update(ids, goodTypeName);
			if(updateCount>0) {
				req.getRequestDispatcher("/selectGoodType").forward(req, resp);
			}else {
				resp.getWriter().write("�޸�ʧ��");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
