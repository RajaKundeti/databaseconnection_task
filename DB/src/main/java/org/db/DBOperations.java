package org.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public interface DBOperations {
		public static Connection getConnection(DBObject obj) {
			Connection con = null;
			try {
				con = DriverManager.getConnection(obj.getUrl(),obj.getUsername(),obj.getPassword());
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return con;
		}
		public ResultSet getData(Connection c, String q);
		public int insertData(Connection c, String q);
		public int updateData(Connection c, String q);
		public int deleteData(Connection c, String q);
		
}
