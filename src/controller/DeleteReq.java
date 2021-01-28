package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RequestDAO;
import model.Request;

@WebServlet("/DeleteReq")
public class DeleteReq extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String req=request.getParameter("req");
		if(req!=null) {
			RequestDAO dao=new RequestDAO();
			dao.deleteOne(new Request(req));
			request.setAttribute("msg","リクエストを1件削除しました");
		}
		RequestDispatcher rd=request.getRequestDispatcher("/Admin");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
