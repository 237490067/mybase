package com.java.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.java.daos.Inventorydom;
import com.java.entity.Inventory;

/**
 * Servlet implementation class Inventory
 */
@WebServlet({"/inventory.do","/inventoryadd.do","/inventorydel.do","/inventoryui.do","/inventorysave.do"})
public class InventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InventoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
                String path=request.getServletPath();
                response.setContentType("text/html;charset=utf-8");
                PrintWriter out=response.getWriter();
                Inventorydom inventorydom=new Inventorydom();
                if(path.equals("/inventory.do")){
                	List list=inventorydom.selectAll();
                	JSONArray jsonArray=new JSONArray(list);
                	System.out.print(jsonArray);

                	out.print(jsonArray);
                	out.flush();
                	out.close();
                }
                if(path.equals("/inventoryadd.do")){
                	String cid=request.getParameter("cid");
                	String icod=request.getParameter("icod");
                	String inum=request.getParameter("inum");
                	String idata=request.getParameter("idata");
                	String iis=request.getParameter("iis");
                	String uid=request.getParameter("uid");
                	String mark=request.getParameter("imark");
                	SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd");
                	try {
						java.sql.Date date=new java.sql.Date(simpleDateFormat.parse(idata).getTime());
					Inventory inventory=new Inventory(0,Integer.parseInt(cid),Integer.parseInt(icod),Integer.parseInt(inum),date,iis,Integer.parseInt(uid),mark);
					inventorydom.add(inventory);
					response.sendRedirect("inventory.html");
                	} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	
                }
                if(path.equals("/inventorydel.do")){
                	String iid=request.getParameter("iid");
                	inventorydom.delete(Integer.parseInt(iid));
                	response.sendRedirect("inventory.html");
                	
                }
                if(path.equals("/inventoryui.do")){
                	String iid=request.getParameter("iid");
                	Inventory inventory=inventorydom.getInventory(Integer.parseInt(iid));
                	JSONObject jsonObject=new JSONObject(inventory);
                	out.print(jsonObject);
                	out.flush();
                	out.close();
                }
                if(path.equals("/inventorysave.do")){
                	String cid=request.getParameter("cid");
                	String icod=request.getParameter("icod");
                	String inum=request.getParameter("inum");
                	String idata=request.getParameter("idata");
                	String iis=request.getParameter("iis");
                	String uid=request.getParameter("uid");
                	String mark=request.getParameter("imark");
                	SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd");
                
						
						try {
							java.sql.Date date= new java.sql.Date(simpleDateFormat.parse(idata).getTime());
							Inventory inventory=new Inventory(0,Integer.parseInt(cid),Integer.parseInt(icod),Integer.parseInt(inum),date,iis,Integer.parseInt(uid),mark);
							inventorydom.updatainventory(inventory);
							response.sendRedirect("inventory.html");
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
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
