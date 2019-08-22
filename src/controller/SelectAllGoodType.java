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
import entity.GoodType;
import service.GoodInfoService;
import service.GoodTypeService;
import service.impl.GoodInfoServiceImpl;
import service.impl.GoodTypeServiceImpl;
@WebServlet("/selectGoodType")
public class SelectAllGoodType extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GoodTypeService goodTypeService = new GoodTypeServiceImpl();
		HttpSession session = req.getSession();
		try {
			List<GoodType> goodTypes = goodTypeService.selectGoodType();
			if(goodTypes != null) {
				session.setAttribute("goodTypes", goodTypes);
				req.getRequestDispatcher("/goodTypeInfo.jsp").forward(req, resp);
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
