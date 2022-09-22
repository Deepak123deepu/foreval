package jdbcConnectivity;

import java.util.Scanner;

public class jdbcTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("hey there ...! choose what u need");
		System.out.println("1. Inserting values to the table");
		System.out.println("2. Get package cost");
		int choose = sc.nextInt();
		
		jdbconnection jdbc1 = new jdbconnection();
		
		if (choose == 1) {
			// INSERTING THE VALUES 

			System.out.println("Inserting values to the table ... ");
			System.out.println("Enter  package_id: ");
			int package_id = sc.nextInt();
			
			System.out.println("Enter  source_place: ");
			String source_place = sc.next();
			
			System.out.println("Enter  destination_place: ");
			String destination_place = sc.next();
			
			System.out.println("Enter  basic_fare: ");
			int basic_fare = sc.nextInt();
			
			tabelPros data1 = new tabelPros(package_id,source_place,destination_place,basic_fare); 
			
			jdbc1.insertData(data1);
		}else if (choose == 2){
			// GETTING THE TABLE INFO AND MAKING GETING PACKAGE COST
			jdbc1.getConnection();
			System.out.println();
			System.out.println("Give us your source and destination please.. ");
			System.out.println("Enter the source: ");
			String source = sc.next();
			System.out.println("Enter the destination: ");
			String destination = sc.next();
			System.out.println("Enter number of days of ");
			int numberOfDays = sc.nextInt();
			
			jdbc1.getPackageCost(source,destination,numberOfDays);
			
		} else {
//			String qurey = "select basic_fare from tourpackage.packageinfo where source_place =" + "'"+ "ban" +"'"+ " and " + "destination_place" +"="+"'"+"ban"+"'"+";";
			System.out.println("something wrong ...!");
		}
		
		
	}
}
