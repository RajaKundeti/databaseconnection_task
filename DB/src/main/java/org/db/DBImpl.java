package org.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBImpl implements DBOperations{

	private DBObject db;
	
	public DBImpl(DBObject db) {
		super();
		this.db = db;
	}

	public DBObject getDb() {
		return db;
	}


	public void setDb(DBObject db) {
		this.db = db;
	}
	
	@Override
	public ResultSet getData(Connection c, String q) {
		ResultSet rs = null;
		try {
			Statement s = c.createStatement();
			rs =  s.executeQuery(q);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}


	@Override
	public int insertData(Connection c, String q) {
		int isInserted = 0;
		try {
			Statement s = c.createStatement();
			isInserted = s.executeUpdate(q);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return isInserted;
	}
	
	@Override
	public int updateData(Connection c, String q) {
		int isUpdated = 0;
		try {
			Statement s = c.createStatement();
			isUpdated = s.executeUpdate(q);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	@Override
	public int deleteData(Connection c, String q) {
		int isDeleted = 0;
		try {
			Statement s = c.createStatement();
			isDeleted = s.executeUpdate(q);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	
	

}
