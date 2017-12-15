package json;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class Principal {
	
	public static int compareByStreetNameAndNumber(Bicing b1, Bicing b2) {
		if ( b1.getStreetName().equals(b2.getStreetName()) ) {
			return b1.getStreetNumber().compareTo(b2.getStreetNumber());
		} else {
			return b1.getStreetName().compareTo(b2.getStreetName());
		}
	}
	
	public static int compareByCloseness(Bicing b1, Bicing b2) {
		double homeLat = 41.382763;
		double homeLong = 2.1372623;
		if ( Math.pow(b1.getLatitude()-homeLat, 2)+Math.pow(b1.getLongitude()-homeLong, 2) == Math.pow(b2.getLatitude()-homeLat, 2)+Math.pow(b2.getLongitude()-homeLong, 2) ) {
			return 0;
		} else if ( Math.pow(b1.getLatitude()-homeLat, 2)+Math.pow(b1.getLongitude()-homeLong, 2) > Math.pow(b2.getLatitude()-homeLat, 2)+Math.pow(b2.getLongitude()-homeLong, 2) ) {
			return 1;
		} else {
			return -1;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		/// PARSEJA LES DADES ///
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
		
		System.out.println("0/ "+bicingStationsList);
		System.out.println();
		
		/// MÈTODES ///
		
		// 1. Les estacions que estan per damunt de la latitud 41.38º (0.5 punts)
		System.out.println("1. Les estacions que estan per damunt de la latitud 41.38º (0.5 punts)");
		
		bicingStationsList.stream()
			.filter(b -> b.getLatitude() > 41.38)
			.forEach(b -> System.out.print(b.getId()+"; "));

		System.out.println();
		System.out.println();
		
		// 2. Les estacions que tinguin un altitud major de 50m (0.5 punts)
		System.out.println("2. Les estacions que tinguin un altitud major de 50m (0.5 punts)");
		
		bicingStationsList.stream()
			.filter(b -> b.getAltitude() > 50)
			.forEach(b -> System.out.print(b.getId()+"; "));
			
		System.out.println();
		System.out.println();
		
		// 3. Les estacions que tinguin més d’una bici, amb la quantitat de bicis que tenen en aquest moment (1 punt)
		System.out.println("3. Les estacions que tinguin més d’una bici, amb la quantitat de bicis que tenen en aquest moment (1 punt)");
		
		bicingStationsList.stream()
			.filter(b -> b.getBikes() > 1)
			.forEach(b -> System.out.print(b.getId()+": "+b.getBikes()+" bicis; "));
		
		System.out.println();
		System.out.println();
		
		// 4. Les estacions que estiguin tancades, amb l’estat corresponent (1punt)
		System.out.println("4. Les estacions que estiguin tancades, amb l’estat corresponent (1punt)");
		
		bicingStationsList.stream()
			.filter(b -> b.getStatus().equals("CLS"))
			.forEach(b -> System.out.print(b.getId()+": status "+b.getStatus()+"; "));
		
		System.out.println();
		System.out.println();
		
		// 5. Mostra totes les estacions obertes, ordenades pel nom del carrer i el número (1.5punts)
		System.out.println("5. Mostra totes les estacions obertes, ordenades pel nom del carrer i el número (1.5punts)");
		
		bicingStationsList.stream()
			.filter(b -> b.getStatus().equals("OPN"))
			.sorted(Principal::compareByStreetNameAndNumber)
			.forEach(b -> System.out.println(b.getId()+": "+b.getStreetName()+", "+b.getStreetNumber()));
	
		System.out.println();
		System.out.println();
		
		// 6. Mostra les 3 estacions més properes a la teva casa que estiguin obertes i indica de què tipus són (1.5 punts)
		// Indica la teva direcció de Barcelona (si no vols indicar-la o vius fora de la ciutat, tria una parada de metro que tinguis a prop, o que coneguis):
		//	Indica les coordinades de la direcció (podeu averiguar-les amb el Google Maps):
		//	Latitud: 41.382763
		//	Longitud: 2.1372623
		System.out.println("6. Mostra les 3 estacions més properes a la teva casa que estiguin obertes i indica de què tipus són (1.5 punts)");
		
		bicingStationsList.stream()
			.filter(b -> b.getStatus().equals("OPN"))
			.sorted(Principal::compareByCloseness)
			.limit(3)
			.forEach(b -> System.out.println(b.getId()+": "+b.getStreetName()+", "+b.getStreetNumber()+" tipus: "+b.getType()));
		
		System.out.println();
		System.out.println();
		
		// 7. Mostra l’estació elèctrica més propera a la direcció que hagis indicat al punt anterior (1.5 punts) i el número de bicis disponibles
		System.out.println("7. Mostra l’estació elèctrica més propera a la direcció que hagis indicat al punt anterior (1.5 punts) i el número de bicis disponibles");
		
		bicingStationsList.stream()
			.filter(b -> b.getStatus().equals("OPN"))
			.sorted(Principal::compareByCloseness)
			.limit(1)
			.forEach(b -> System.out.println(b.getId()+": "+b.getStreetName()+", "+b.getStreetNumber()+" num bikes: "+b.getBikes()));
		
		System.out.println();
		System.out.println();
		
		// PARAL·LEL //
		bicingStationsList.stream()
			.parallel()
			.filter(b -> b.getStatus().equals("OPN"))
			.sorted(Principal::compareByStreetNameAndNumber)
			.forEach(b -> System.out.println(b.getId()+": "+b.getStreetName()+", "+b.getStreetNumber()+" tipus: "+b.getType()));
		
		// Cada vegada s'imprimeix en un ordre diferent
	}

}
