package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.GoodInfo;
import service.GoodInfoService;
import service.impl.GoodInfoServiceImpl;
@WebServlet("/selectGood")
public class SelectAllGoodInfo extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GoodInfoService goodInfoService = new GoodInfoServiceImpl();
		HttpSession session = req.getSession();
		try {
			List<GoodInfo> goods = goodInfoService.selectAllGoodInfo();
			if(goods != null) {
				session.setAttribute("goods", goods);
				req.getRequestDispatcher("/goodInfo.jsp").forward(req, resp);
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
