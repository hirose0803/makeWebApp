package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SlangDAO;
import model.Slang;

@WebServlet("/Update")
public class Update extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		if(id == null) {
			response.sendRedirect("Admin");
			return;
		}
		SlangDAO dao=new SlangDAO();
		Slang slang=dao.findOne(Integer.parseInt(id));
		response.setContentType("text/html; charset=utf-8");
		request.setAttribute("slang", slang);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/admin/update.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		String title=request.getParameter("title");
		String body=request.getParameter("body");
		int type=Integer.parseInt(request.getParameter("type"));
		SlangDAO dao=new SlangDAO();
		dao.updateOne(new Slang(id,title,body,type));
		List<Slang> list=dao.getListBySearchType("0");
		request.setAttribute("list", list);
		request.setAttribute("msg","1件編集しました");
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/admin/main.jsp");
		rd.forward(request, response);
	}

}