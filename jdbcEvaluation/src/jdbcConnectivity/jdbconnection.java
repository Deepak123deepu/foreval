package jdbcConnectivity;

import java.sql.*;
import java.util.*;

public class jdbconnection {
	static final String URL = "jdbc:mysql://localhost/tourpackage";
	static final String UNAME = "root";
	static final String PASSCODE = "deepakdeepu";
	static final String QUERY = "select * from packageinfo;";
	
	public void getConnection() {
		try(Connection conn = DriverManager.getConnection(URL, UNAME, PASSCODE);
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(QUERY);) {
		         // Extract data from result set
				 System.out.println("here is the locations available");
				 System.out.println("--------------------------------");
		         while (rs.next()) {
		            // Retrieve by column name
		            System.out.print(rs.getInt("package_id") + " ");
		            System.out.print(rs.getString("source_place")+ " ");
		            System.out.print(rs.getString("destination_place")+ " ");
		            System.out.println(rs.getInt("basic_fare"));
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
	}
	
	public void insertData(tabelPros data) {
		try(Connection conn = DriverManager.getConnection(URL, UNAME, PASSCODE);
		         Statement stmt = conn.createStatement();
		      ) {		      
		         // Execute a query
		         System.out.println("Inserting records into the table...");          
		         String qurey = "INSERT INTO tourpackage.packageinfo VALUES ("+data.package_id+","+"'"+data.source_place+"'"+","+"'"+data.destination_place+"'"+","+data.basic_fare+")";
		         stmt.executeUpdate(qurey);
		         System.out.println("Inserted records into the table...");   	  
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } 
	}
	
	public void getPackageCost(String source, String destination, int numberOfDays) {
		String qurey = "select basic_fare from tourpackage.packageinfo where source_place =" + "'"+ source +"'"+ " and " + "destination_place" +"="+"'"+destination+"'"+";";
		try(Connection conn = DriverManager.getConnection(URL, UNAME, PASSCODE);
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(qurey);) {
		         // Extract data from result set
				 
				 rs.next();
				 int basicPrice = rs.getInt("basic_fare"); 
				 
				 System.out.println("The basic price of the trip is :"+ basicPrice);
				 System.out.println("--------------------------------");
				 int discountPercent = 0;
				 if (numberOfDays <=5) {
					 discountPercent = 0; 
				 }else if (numberOfDays > 5 & numberOfDays <= 8) {
					 discountPercent = 3; 
				 }else if (numberOfDays > 8 & numberOfDays <=10) {
					 discountPercent = 5; 
				 }else {
					 discountPercent = 10;
				 }
				 
				// Package Cost = ((Basic fare x number of days)-discount)+GST
				 Double initTotal = (double) (basicPrice*numberOfDays); 
				 Double discount = (initTotal * discountPercent/100); // (45000.0*(7/100)) 
				 Double gst = ((initTotal - discount)* 12/100);  
				 Double packageCost = (initTotal - discount)+gst;  
				 
				 System.out.println("The initial total cost :" + initTotal + "/-");
				 System.out.println("The discount Percent   :" + discountPercent + " %");
				 System.out.println("The discount amount    :" + discount + "/-");
				 System.out.println("The GST cost           :" + gst + "/-");
				 System.out.println("The basic price of the trip is :"+ packageCost+"/-");
		         
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
	}
	
}






