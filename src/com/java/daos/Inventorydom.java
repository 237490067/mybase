package com.java.daos;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.entity.Inventory;
import com.java.entity.Product;
import com.java.tools.JDBCpool;

import javafx.scene.chart.PieChart.Data;

public class Inventorydom {
	public List<Inventory> selectAll(){
		Connection conn=null;
		List<Inventory>l=new ArrayList();

		try {
			conn=JDBCpool.getconnection();
			PreparedStatement pre=conn.prepareStatement("select*from inventory");
			ResultSet res=pre.executeQuery();
			while(res.next()){
				int iid=res.getInt("iid");
				int cid=res.getInt("cid");
				int icod=res.getInt("icod");
				int inum=res.getInt("inum");
				Date idate=res.getDate("idate");
				String iis=res.getString("iis");
				int uid=res.getInt("uid");
				String mark=res.getString("imark");
				Inventory in=new Inventory(iid,cid,icod,inum,idate,iis,uid,mark);
				l.add(in);
			}
			
			return l;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	public void add(Inventory p) {
		Connection conn=null;

		try {
			conn=JDBCpool.getconnection();

			PreparedStatement pre=conn.prepareStatement("insert into inventory values(?,?,?,?,?,?,?,?)");
			pre.setInt(1, p.getIid());
		    pre.setInt(2, p.getCid());
		    pre.setInt(3, p.getIcod());
		    pre.setInt(4, p.getInum());
		    pre.setDate(5, p.getIdate());
		    pre.setString(6, p.getIis());
		    pre.setInt(7, p.getUid());
		    pre.setString(8, p.getMark());
		    pre.executeUpdate();
		    
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		   JDBCpool.removeconnection(conn);
		}
		
	}
	public void delete(int iid) {
		// TODO Auto-generated method stub
		Connection conn=null;

		try {
			conn=JDBCpool.getconnection();
			PreparedStatement pre=conn.prepareStatement("delete from inventory where iid=?");
			pre.setInt(1, iid);
		    pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		   JDBCpool.removeconnection(conn);
		}

			
	
	

	
}
	public Inventory getInventory(int iid){
		Connection conn=null;
		Inventory p=null;
	  try {
		  conn=JDBCpool.getconnection();
		PreparedStatement pre=conn.prepareStatement("select*from inventory where iid=?");
		pre.setInt(1, iid);
		ResultSet res=pre.executeQuery();
		while(res.next()){
			int cid=res.getInt("cid");
			int icod=res.getInt("icod");
			int inum=res.getInt("inum");
			Date idata=res.getDate("idate");
			String iis=res.getString("iis");
			int uid=res.getInt("uid");
			String imark=res.getString("imark");
			
		p=new Inventory(iid,cid,icod,inum,idata,iis,uid,imark);
		}
		return p;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}finally{
		   JDBCpool.removeconnection(conn);
		}
	   
	}

	public void updatainventory(Inventory p) {
		// TODO Auto-generated method stub
		Connection conn=null;

		try {
			conn=JDBCpool.getconnection();

			PreparedStatement pre=conn.prepareStatement("update inventory set cid=?,icod=?,inum=?,idate=?,iis=?,uid=?,mark=? where iid=?");
			pre.setInt(8, p.getIid());
		    pre.setInt(1, p.getCid());
		    pre.setInt(2, p.getIcod());
		    pre.setInt(3, p.getInum());
		    pre.setDate(4, p.getIdate());
		    pre.setString(5, p.getIis());
		    pre.setInt(6, p.getUid());
		    pre.setString(7, p.getMark());
		    pre.executeUpdate();
		    
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		   JDBCpool.removeconnection(conn);
		}
	}

	
	

}
