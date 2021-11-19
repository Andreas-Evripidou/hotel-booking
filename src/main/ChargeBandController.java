package main;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChargeBandController {

	public void getDate() {
	String query = "SELECT * FROM team023.Charge Band WHERE propertyID=1;";
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
		
	public List<ChargeBand> getChargeBandsByPropertyID(String propertyID){
		String query = "SELECT * FROM team023.`Charge Band` WHERE propertyID='" + String.valueOf(propertyID) + "'";
		DatabaseCommunication db = new DatabaseCommunication();
		
		Date startDate;
		Date endDate;
		float pricePerNight;
		float seviceCharge;
		float cleaningCharge;
		
		List<ChargeBand> allChargeBands = new ArrayList<ChargeBand>();
		
		try {
			ResultSet results = db.queryExecute(query);
			while (results.next()) {
				results.getString(1);
				startDate = results.getDate(2);
				endDate = results.getDate(3);
				pricePerNight = results.getFloat(4);
				seviceCharge = results.getFloat(5);
				cleaningCharge = results.getFloat(6);
				
				
				ChargeBand chargeBand = new ChargeBand(startDate.toString(), endDate.toString(), pricePerNight, seviceCharge, cleaningCharge);
				allChargeBands.add(chargeBand);
			}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeAll(db.getResultSet(), db.getStatement(), db.getPreparedStatement(), db.getConnection());
			}
		return allChargeBands;	
	}
	
}
