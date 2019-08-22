package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodInfoService;
import service.impl.GoodInfoServiceImpl;
@WebServlet("/addgood")
public class AddGoodInfoServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡ���ύ����
		String goodName = req.getParameter("goodName");
		int parentId = Integer.valueOf(req.getParameter("parentId"));
		double goodPrice = Double.valueOf(req.getParameter("goodPrice"));
		String goodDesc = req.getParameter("goodDesc");
		int goodsStock = Integer.valueOf(req.getParameter("goodsStock"));
		
		GoodInfoService goodInfoService = new GoodInfoServiceImpl();
		try {
			int addCount = goodInfoService.addGood(goodName, parentId, goodPrice, goodDesc, goodsStock);
			if(addCount>0) {
				req.getRequestDispatcher("/selectGood").forward(req, resp);
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
