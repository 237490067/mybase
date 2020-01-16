package com.java.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.entity.User;
import com.java.tools.JDBCpool;

public class Userdom {
	Connection conn=null;
	public List<User> adduser(){
	List<User>l=new ArrayList();
	conn=JDBCpool.getconnection();
      try {
    	  conn=JDBCpool.getconnection();
		PreparedStatement pre=conn.prepareStatement("select*from user");
		ResultSet re=pre.executeQuery();
		while(re.next()){
		int e=re.getInt("uid");
		String q=re.getString("uname");
		String w=re.getString("upassword");
		User u=new User(e,q,w);
		l.add(u);
		}
		return l;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	}
	public boolean isExit(User u) throws SQLException {
		boolean flag=false;
		  conn=JDBCpool.getconnection();
			PreparedStatement pre;
				pre = conn.prepareStatement("select*from user");
				ResultSet re=pre.executeQuery();
				while(re.next()){
				String q=re.getString("uname");
				String w=re.getString("upassword");
				if(q.equals(u.getUname())&&w.equals(u.getUpassword())){
					 flag=true;
				}else{
				}
			}
				return flag;
	}
		
				
		}

			
		
			
		
		  
		
	



