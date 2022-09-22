package jdbcConnectivity;

public class tabelPros {
	int package_id;
	String source_place;
	String destination_place;
	int basic_fare;
	
	
	public tabelPros(int package_idid, String source_place, String destination_place, int basic_fare) {
		super();
		this.package_id = package_idid;
		this.source_place = source_place;
		this.destination_place = destination_place;
		this.basic_fare = basic_fare;
	}


	public int getPackage_idid() {
		return package_id;
	}


	public void setPackage_idid(int package_idid) {
		this.package_id = package_idid;
	}


	public String getSource_place() {
		return source_place;
	}


	public void setSource_place(String source_place) {
		this.source_place = source_place;
	}


	public String getDestination_place() {
		return destination_place;
	}


	public void setDestination_place(String destination_place) {
		this.destination_place = destination_place;
	}


	public int getBasic_fare() {
		return basic_fare;
	}


	public void setBasic_fare(int basic_fare) {
		this.basic_fare = basic_fare;
	}
	
}
