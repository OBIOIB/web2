

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Num;
import model.NumLogic;
/**
 * Servlet implementation class NumMain
 */
@WebServlet("/NumMain")
public class NumMain extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/form.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String org = request.getParameter("org");	
	
	Num num=new Num(org);
	
	NumLogic logic = new NumLogic();
	
	logic.execute(num);
	
	request.setAttribute("num", num);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/result.jsp");
	dispatcher.forward(request, response);
	}

}
