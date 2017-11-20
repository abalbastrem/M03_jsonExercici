package json;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class Principal {
	
	public static void main(String[] args) throws Exception {
		
		// Reader
		//TODO
		
		// Parser
		// TODO
		JsonParser jParser = new JsonParser();
		JsonElement personasArray = jParser.parse(json);
		System.out.println("::::: PERSONAS ARRAY"+personasArray);
		if (personasArray.isJsonArray()) {
			for (int i = 0; i < personasArray.getAsJsonArray().size(); i++) {
				System.out.println("\n::::: PERSONA ELEMENT: "+personasArray.getAsJsonArray().get(i));
				JsonElement telefonosArray = jParser.parse(((JsonObject) personasArray.getAsJsonArray().get(i)).get("telefonos").toString());
				System.out.println("::::: TELEFONOS ARRAY: "+telefonosArray);
				if (telefonosArray.isJsonArray()) {
					for (int j = 0; j < telefonosArray.getAsJsonArray().size(); j++) {
						System.out.println("::::: TELEFONO ELEMENT: "+telefonosArray.getAsJsonArray().get(j));
					}
				} else {
					System.out.println("telefonsElement is not a JsonArray");
				}
			}
		} else {
			System.out.println("personasElement is not a JsonArray");
		}
		
	}

}
