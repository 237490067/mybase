package com.java.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.entity.City;
import com.java.entity.Sheng;
import com.java.tools.JDBCpool;

public class CityDao {
	public List<City> getAllCitys(Integer s_id){
		Connection conn=null;
		List<City> l=new ArrayList<City>();
		conn=JDBCpool.getconnection();	
		try {
			conn=JDBCpool.getconnection();
			PreparedStatement pre = conn.prepareStatement("select*from city where s_id=?");
			pre.setInt(1, s_id);
			ResultSet rs=pre.executeQuery();
			while(rs.next()){
				int c_id=rs.getInt("c_id");
				String c_name=rs.getString("c_name");
				City c=new City(s_id,c_id,c_name);
				l.add(c);
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
