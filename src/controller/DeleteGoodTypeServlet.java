package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GoodCrud;
import service.GoodTypeService;
import service.impl.GoodTypeServiceImpl;
@WebServlet("/deleteGoodType")
public class DeleteGoodTypeServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id"); //��ȡɾ��id
		GoodTypeService goodTypeService = new GoodTypeServiceImpl();
		try {
			int delCount = goodTypeService.delete(Integer.valueOf(id));
			if(delCount>0) {
				req.getRequestDispatcher("/selectGoodType").forward(req, resp);
			}else {
				resp.getWriter().write("ɾ��ʧ��");
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
