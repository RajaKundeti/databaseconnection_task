package org.db.test;
import java.io.FileWriter;
import java.sql.ResultSet;
import org.db.DBImpl;
import org.db.DBObject;
import org.db.DBOperations;

public class TestDB {

	public static void main(String[] args) {
		
		//	DATABASE CONNECTION THROUGH MYSQL			
		//	GETTING DATABASE CONNECTION	
		DBObject db = new DBObject("jdbc:mysql://localhost:3306/shirts_db","root","N@rsik47"); 
		DBImpl dbi = new DBImpl(db);
		db.setConnection(DBOperations.getConnection(db));
		
		//	GETTING DATA FROM DATABASE WRITE DATA INTO A FILE
		db.setQuery("SELECT * FROM SHIRTS;");
		ResultSet resultSet = dbi.getData(db.getConnection(),db.getQuery());
		if(resultSet != null) {
			writeData(resultSet);
		}
		
		 //	INSERTING DATA INTO DATABASE
		db.setQuery("insert into shirts values(9,'Half Sleeve','White','L',20);");
		int isInserted  = dbi.insertData(db.getConnection(), db.getQuery());
		if(isInserted==1) {
			System.out.println("Data inserted Successfully!");
		}
		else {
			System.out.println("Data Not inserted!");
		}
		
		
		//	UPDATING DATA OF DATABASE
		db.setQuery("update shirts set last_worn=5 where shirt_id = 2;");
		int isUpdated  = dbi.insertData(db.getConnection(), db.getQuery());
		if(isUpdated==1) {
			System.out.println("Data updated Successfully!");
		}
		else {
			System.out.println("Data Not Updated!");
		}
		
		
		//	DELETING DATA OF DATABASE
		db.setQuery("delete from shirts where shirt_id = 9;");
		int isDeleted  = dbi.insertData(db.getConnection(), db.getQuery());
		if(isDeleted==1) {
			System.out.println("Data deleted Successfully!");
		}
		else {
			System.out.println("Data Not Deleted!");
		}
	}

	private static void writeData(ResultSet resultSet) {
		int columnCount;
		try {
			FileWriter fw = new FileWriter("C:\\Users\\RajaNarasimhanKundet\\OneDrive - Atyeti Inc\\Desktop\\Self\\dbData.txt");
			columnCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    fw.append(resultSet.getString(i));
                    if (i < columnCount) fw.append(",");
                }
                fw.append("\n");
            }
            fw.close();

        } catch (Exception e) {
			e.printStackTrace();
		}
	}

}
