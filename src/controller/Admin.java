package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RequestDAO;
import DAO.SlangDAO;
import model.Request;
import model.Slang;

@WebServlet("/Admin")
@MultipartConfig
public class Admin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDAO reqdao=new RequestDAO();
		List<Request> reqlist=reqdao.findAll();
		SlangDAO dao=new SlangDAO();
		List<Slang> list=dao.getListBySearchType("0");
		request.setAttribute("reqlist", reqlist);
		request.setAttribute("list", list);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/admin/main.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title=request.getParameter("title");
		String body=request.getParameter("body");
		int type=Integer.parseInt(request.getParameter("type"));
		SlangDAO dao=new SlangDAO();
		dao.insertOne(new Slang(title,body,type));
		request.setAttribute("msg", "1件登録しました");
		doGet(request,response);
	}

}