package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.GoodInfoService;
import service.impl.GoodInfoServiceImpl;
@WebServlet("/updateGood")
public class UpdateGoodServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String goodName = req.getParameter("goodName");
		double goodPrice =Double.valueOf(req.getParameter("goodPrice"));
		int goodsStock = Integer.valueOf(req.getParameter("goodsStock")) ;
		double goodsdiscount =Double.valueOf(req.getParameter("goodsdiscount"));
		String goodDesc = req.getParameter("goodDesc");
		int parentId = Integer.valueOf(req.getParameter("parentId"));
		HttpSession session = req.getSession();
		int id =Integer.valueOf(session.getAttribute("id").toString());
		
		GoodInfoService goodInfoService = new GoodInfoServiceImpl();
		try {
			int updateCount = goodInfoService.updateGood(goodName, parentId, goodPrice, goodDesc, goodsStock, goodsdiscount, id);
			if(updateCount>0) {
				req.getRequestDispatcher("/selectGood").forward(req, resp);
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
