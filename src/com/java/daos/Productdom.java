package com.java.daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.entity.Product;
import com.java.tools.JDBCpool;

public class Productdom {
	public List<Product> getAllProduct(){

	Connection conn=null;
	List<Product>l=new ArrayList();
	try {
		conn=JDBCpool.getconnection();
		PreparedStatement pre=conn.prepareStatement("select*from product");
		ResultSet rs=pre.executeQuery();
		while(rs.next()){
			int pid=rs.getInt("pid");
			int pnum=rs.getInt("pnum");
			String name=rs.getString("name");
			Product p=new Product(pid,pnum,name);
			l.add(p);
		}
		return l;		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	
	}

		// TODO Auto-generated method stub
		public void add(Product m){
			Connection conn=null;

			try {
				conn=JDBCpool.getconnection();

				PreparedStatement pre=conn.prepareStatement("insert into product(pid,pnum,name)values(?,?,?)");
				pre.setInt(1, m.getPid());
			    pre.setInt(2, m.getPnum());
			    pre.setString(3, m.getName());
			    pre.executeUpdate();
			    
			    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
			   JDBCpool.removeconnection(conn);
			}
			
		}

		public void delete(int pid) {
			// TODO Auto-generated method stub
			Connection conn=null;

			try {
				conn=JDBCpool.getconnection();
				PreparedStatement pre=conn.prepareStatement("delete from product where pid=?");
				pre.setInt(1, pid);
			    pre.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
			   JDBCpool.removeconnection(conn);
			}

				
		
		

		
	}
		public Product getProduct(int pid){
			Connection conn=null;
			Product p=null;
		  try {
			  conn=JDBCpool.getconnection();
			PreparedStatement pre=conn.prepareStatement("select*from product where pid=?");
			pre.setInt(1, pid);
			ResultSet res=pre.executeQuery();
			while(res.next()){
			int pnum=res.getInt("pnum"); 
			String name=res.getString("name");
			p=new Product(pid,pnum,name);
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

		public void update(Product p) {
			Connection conn=null;

			try {
				conn=JDBCpool.getconnection();

				PreparedStatement pre=conn.prepareStatement("update product set pnum=?,name=? where pid=?");
				pre.setInt(3, p.getPid());
			    pre.setInt(1, p.getPnum());
			    pre.setString(2, p.getName());
			    pre.executeUpdate();
			    
			    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
			   JDBCpool.removeconnection(conn);
			}
			
			
			
		}

		public List<Product> getAllProduct(String pnum, String name) {
			Connection conn=null;
			List<Product>l=new ArrayList();
			System.out.println("you");
			try {
				String sql="select*from product where 1=1 ";
				if(name!=null&&!name.equals("")){
					sql=sql+"and name like ?";
					System.out.println("11111");
				}
				if(pnum!=null&&!pnum.equals("")){
					sql=sql+"and pnum like ?";
					System.out.println("2222222");

				}
				System.out.println(sql);
				
				conn=JDBCpool.getconnection();
				PreparedStatement pre=conn.prepareStatement(sql);
				int count=0;
				if(name!=null&&!name.equals("")){
                  count++;
                  System.out.println(count);
                  pre.setString(count, "%"+name+"%");
				}
				if(pnum!=null&&!pnum.equals("")){
	                  count++;
	                  System.out.println(count);

	                  pre.setString(count, "%"+pnum+"%");
					}
				ResultSet res=pre.executeQuery();
				while(res.next()){
					int pid=res.getInt("pid");
					int pnum1=res.getInt("pnum");
					String name1=res.getString("name");
					Product p=new Product(pid,pnum1,name1);
					l.add(p);
				}
				return l;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}finally{
				   JDBCpool.removeconnection(conn);
				}
		}
		
	
		
}
