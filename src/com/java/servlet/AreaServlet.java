package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.java.daos.AreaDao;
import com.java.entity.Area;

/**
 * Servlet implementation class AreaServlet
 */
@WebServlet("/area.do")
public class AreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   /**
     * @see HttpServlet#HttpServlet()
     */
    public AreaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
          String c_id=request.getParameter("c_id");
          AreaDao a=new AreaDao();
          
          List<Area> l=a.getAllAreas(Integer.parseInt(c_id));
      
          response.setContentType("text/html;charset=utf-8");
          JSONArray j=new JSONArray(l);
          PrintWriter out=response.getWriter();
          out.print(j);
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
