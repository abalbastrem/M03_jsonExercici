package json;

import java.util.List;

public class Bicing {
	
	private long id;
	private String type;
	private double latitude;
	private double longitude;
	private String streetName;
	private int streetNumber;
	private int altitude;
	private int slots;
	private int bikes;
	private List<Integer> nearbyStations;
	private String status;
	public Bicing(long id, String type, double latitude, double longitude, String streetName, int streetNumber,
			int altitude, int slots, int bikes, List<Integer> nearbyStations, String status) {
		this.id = id;
		this.type = type;
		this.latitude = latitude;
		this.longitude = longitude;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.altitude = altitude;
		this.slots = slots;
		this.bikes = bikes;
		this.nearbyStations = nearbyStations;
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public int getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}
	public int getAltitude() {
		return altitude;
	}
	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}
	public int getSlots() {
		return slots;
	}
	public void setSlots(int slots) {
		this.slots = slots;
	}
	public int getBikes() {
		return bikes;
	}
	public void setBikes(int bikes) {
		this.bikes = bikes;
	}
	public List<Integer> getNearbyStations() {
		return nearbyStations;
	}
	public void setNearbyStations(List<Integer> nearbyStations) {
		this.nearbyStations = nearbyStations;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Bicing [id=" + id + ", type=" + type + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", streetName=" + streetName + ", streetNumber=" + streetNumber + ", altitude=" + altitude
				+ ", slots=" + slots + ", bikes=" + bikes + ", nearbyStations=" + nearbyStations + ", status=" + status
				+ "]";
	}
	
	
}
