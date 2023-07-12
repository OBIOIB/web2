package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Entry;
import model.EntryProcess;

@WebServlet("/Process")
public class Process extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ServletContext application = this.getServletContext();	
	List<Entry> list =(List<Entry>)application.getAttribute("list");
	if(list == null) {
		list = new ArrayList<>();
		application.setAttribute("list", list);
	}
	RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/index.jsp");
	rd.forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String msg;	
		if((name != null && name.length()>0) && (price != null && price.length() >0)) {
			msg = "1件登録しました";
			Entry e = new Entry();
			e.setName(name);
			e.setPrice(price);
			ServletContext application =this.getServletContext();
			List<Entry> list =(List<Entry>) application.getAttribute("list");
			EntryProcess ep = new EntryProcess();
			ep.execute(e,list);
			application.setAttribute("list",list);
		}else {
			msg = "未記入の項目があります!";
		}
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/index.jsp");
		rd.forward(request,response);

		}
		
	}