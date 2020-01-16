package com.java.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.entity.Sheng;
import com.java.tools.JDBCpool;

public class ShengDao {
	public List<Sheng> getAllShengs(){
		Connection conn=null;
		List<Sheng> l=new ArrayList<Sheng>();
		conn=JDBCpool.getconnection();	
		try {
			conn=JDBCpool.getconnection();
			PreparedStatement pre = conn.prepareStatement("select*from sheng");
			ResultSet rs=pre.executeQuery();
			while(rs.next()){
				int s_id=rs.getInt("s_id");
				String s_name=rs.getString("s_name");
				Sheng s=new Sheng(s_id,s_name);
				l.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCpool.removeconnection(conn);
		}
        return l;

	}
}
