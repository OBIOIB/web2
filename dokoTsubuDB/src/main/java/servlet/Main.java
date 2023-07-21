package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MutterDAO;
import model.Mutter;
import model.User;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MutterDAO dao = new MutterDAO();
		List<Mutter> list = dao.findAll();
		request.setAttribute("mutterList", list);
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			response.sendRedirect("index.jsp");
		}else {
			RequestDispatcher dispatcher= request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		if(text != null && text.length() != 0) {
			
			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");
			
			Mutter mutter = new Mutter(loginUser.getName(), text);
			MutterDAO dao = new MutterDAO();
			dao.insertOne(mutter);
			List<Mutter>list =dao.findAll();
			request.setAttribute("mutterList", list);
		}else {
			request.setAttribute("errorMsg","つぶやきが入力されていません");
		}
		RequestDispatcher dispatcher= request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
		dispatcher.forward(request,response);
	}
}
