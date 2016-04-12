package com.zzia.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zzia.dao.IGoodDAO;
import com.zzia.daoimp.GoodDAOImp;
import com.zzia.model.Good;
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public UpdateServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String updataName = request.getParameter("updataName");
		String name = request.getParameter("name");
		int count = Integer.parseInt(request.getParameter("count"));
		Double price = Double.parseDouble(request.getParameter("price"));
		IGoodDAO goods = new GoodDAOImp();
		goods.updateGood(name, count, price, updataName);
		
		IGoodDAO good = new GoodDAOImp();
		List<Good> list = good.getAllGood();
		request.setAttribute("good", list);
		//response.sendRedirect("lib/index.jsp");
		request.getRequestDispatcher("lib/index.jsp").forward(request, response);
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
