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
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SlangDAO dao=new SlangDAO();
		List<Slang> list=dao.getListBySearchType("0");
		request.setAttribute("list",list);
		request.setAttribute("value", "0");
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/main.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String serchType=request.getParameter("type");
		SlangDAO dao=new SlangDAO();
		List<Slang> list=dao.getListBySearchType(serchType);
		request.setAttribute("list", list);
		request.setAttribute("value", serchType);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/main.jsp");
		rd.forward(request, response);
	}

}
