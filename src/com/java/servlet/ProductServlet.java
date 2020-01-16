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
import org.json.JSONException;
import org.json.JSONObject;

import com.java.daos.Productdom;
import com.java.entity.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet({"/product.do","/productdel.do","/productadd.do","/productui.do","/productsave.do"})
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
             response.setContentType("text/html;charset=utf-8");
             PrintWriter out=response.getWriter();
             String path=request.getServletPath();
             Productdom productdom=new Productdom();
             if(path.equals("/product.do")){
            	 List<Product> list=productdom.getAllProduct();
            	 JSONArray j=new JSONArray(list);
            	 System.out.print(j);
            	 out.print(j);
            	 out.flush();
            	 out.close();
            	 
             }
             if(path.equals("/productdel.do")){
            	 String pid=request.getParameter("pid");
            	 System.out.print(pid);
            	 productdom.delete(Integer.parseInt(pid));
            	 response.sendRedirect("product.html");
             }
             if(path.equals("/productadd.do")){
            	 String pnum=request.getParameter("productCode");
            	 String pname=request.getParameter("productName");
            	 Product product=new Product(0,Integer.parseInt(pnum),pname);
            	 productdom.add(product);
            	 response.sendRedirect("product.html");
             }
             if(path.equals("/productui.do")){
            	 String pid=request.getParameter("pid");
            	 Product product=productdom.getProduct(Integer.parseInt(pid));
               
					JSONObject json=new JSONObject(product);
					out.print(json);
					out.flush();
					out.close();
             }		
				           
             
             if(path.equals("/productsave.do")){
            	 String pid=request.getParameter("pid");
            	 String pnum=request.getParameter("pnum");
            	 String pname=request.getParameter("pname");
            	 Product product=new Product(Integer.parseInt(pid),Integer.parseInt(pnum),pname);
            	 productdom.update(product);
            	 response.sendRedirect("product.html");
             }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
