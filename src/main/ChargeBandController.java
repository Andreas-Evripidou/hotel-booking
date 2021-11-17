package main;

import java.sql.Date;
import java.sql.ResultSet;

public class ChargeBandController {

	public void getDate() {
	String query = "SELECT * FROM team023.`Charge Band` WHERE propertyID=1;";
	DatabaseCommunication db = new DatabaseCommunication();
	
	try {
		ResultSet results = db.queryExecute(query);
		while (results.next()) {
			java.sql.Date dbSqlDate = results.getDate(2);
			System.out.println(dbSqlDate);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
	}	
}
	
	public static void main (String [] args) {
		ChargeBandController cbc = new ChargeBandController();
		
		cbc.getDate();
		Date date = new Date(2021-1900,0,31);
		System.out.println(date);
	}
	
}
