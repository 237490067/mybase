package com.java.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.entity.Area;
import com.java.entity.City;
import com.java.tools.JDBCpool;

public class AreaDao {
	public List<Area> getAllAreas(Integer c_id){
		Connection conn=null;
		List<Area> l=new ArrayList<Area>();
		conn=JDBCpool.getconnection();	
		try {
			conn=JDBCpool.getconnection();
			PreparedStatement pre = conn.prepareStatement("select*from area where c_id=?");
			pre.setInt(1, c_id);
			ResultSet rs=pre.executeQuery();
			while(rs.next()){
				int a_id=rs.getInt("a_id");
				String a_name=rs.getString("a_name");
				Area a=new Area(c_id,a_id,a_name);
				l.add(a);
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
