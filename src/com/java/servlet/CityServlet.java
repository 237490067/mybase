package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.java.daos.CityDao;
import com.java.entity.City;

/**
 * Servlet implementation class CityServlet
 */
@WebServlet("/citys.do")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	         String s_id=request.getParameter("s_id");
	         CityDao c=new CityDao();
	         List<City> l=c.getAllCitys(Integer.parseInt(s_id));
	         JSONArray array=new JSONArray(l);
	         response.setContentType("text/html;charset=utf-8");
	         PrintWriter out=response.getWriter();
	         out.print(array);
	         out.flush();
	         out.close();
	         
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
