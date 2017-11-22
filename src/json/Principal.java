package json;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class Principal {
	
	public static void main(String[] args) throws Exception {
		
		JsonParser jParser = new JsonParser();
		JsonElement bicingElement = jParser.parse(new FileReader("stations"));		
		
		JsonArray stationsArray = bicingElement.getAsJsonObject().get("stations").getAsJsonArray();
		
		List<Bicing> bicingStationsList = new ArrayList<Bicing>();
		
		if (stationsArray.isJsonArray()) {
			for (int i = 0; i < stationsArray.size(); i++) {				
//				JsonElement stationElement = stationsArray.get(i).getAsJsonObject(); // Per què no funciona???
				Bicing bicing = new Bicing();
				bicing.setId( stationsArray.get(i).getAsJsonObject().get("id").getAsLong() ); // Per què m'obliga a castejar si uso stationElement?
				bicing.setType( stationsArray.get(i).getAsJsonObject().get("type").getAsString() );
				bicing.setLatitude( stationsArray.get(i).getAsJsonObject().get("latitude").getAsDouble() );
				bicing.setLongitude( stationsArray.get(i).getAsJsonObject().get("longitude").getAsDouble() );
				bicing.setStreetName( stationsArray.get(i).getAsJsonObject().get("streetName").getAsString() );
				bicing.setStreetNumber( stationsArray.get(i).getAsJsonObject().get("streetNumber").getAsString() );				
				bicing.setAltitude( stationsArray.get(i).getAsJsonObject().get("altitude").getAsInt() );
				bicing.setSlots( stationsArray.get(i).getAsJsonObject().get("slots").getAsInt() );
				bicing.setBikes( stationsArray.get(i).getAsJsonObject().get("bikes").getAsInt() );
				String nearbyStationsStr = stationsArray.get(i).getAsJsonObject().get("nearbyStations").getAsString();
				String[] nearbyStations = nearbyStationsStr.split(",");
				bicing.setNearbyStations(nearbyStations);
				bicing.setStatus( stationsArray.get(i).getAsJsonObject().get("status").getAsString() );
				
				bicingStationsList.add(bicing);
			}
		}
		
		System.out.println("OBJ:  "+bicingStationsList);
		
	}

}
