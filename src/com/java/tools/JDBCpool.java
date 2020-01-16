package com.java.tools;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;

public class JDBCpool {
	private static DruidDataSource  dataSource;
	static{
		try {
			InputStream read=new FileInputStream(new File("D:"+File.separator+"jdbc.properties"));
			Properties prop=new Properties();
			prop.load(read);
			
			String driver=prop.getProperty("driver");
			String url=prop.getProperty("url");
			String user=prop.getProperty("user");
			String password=prop.getProperty("password");
			int maxActive=Integer.parseInt(prop.getProperty("maxActive"));
			int minIdle=Integer.parseInt(prop.getProperty("minIdle"));
			int maxWait=Integer.parseInt(prop.getProperty("maxWait"));
			//鍒涘缓閾炬帴姹�
			dataSource=new DruidDataSource();
			dataSource.setDriverClassName(driver);
			dataSource.setUrl(url);
			dataSource.setUsername(user);
			dataSource.setPassword(password);
			dataSource.setMaxActive(maxActive);
			//琛ユ晳鎺柦鏃堕棿杈惧埌涓婄嚎鍥炲幓閾炬帴
		    dataSource.setRemoveAbandonedTimeout(3);
		    dataSource.setRemoveAbandoned(true);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection getconnection(){
		try {
			Connection conn=dataSource.getConnection();
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
    public static void removeconnection(Connection conn){
    	try {
			if(conn!=null&&!conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


}