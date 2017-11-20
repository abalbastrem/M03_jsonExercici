package json;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class Principal {
	
	public static void main(String[] args) throws Exception {
		
		// bean to Json
		ArrayList<String> aList = new ArrayList<String>();
		aList.add("133556565");
		aList.add("134551552");
		Persona per1 = new Persona("Manolo","Garcia",61,aList);
		aList = new ArrayList<String>();
		aList.add("233556565");
		aList.add("234551552");
		Persona per2 = new Persona("Manoli","Gomez",62,aList);
		aList = new ArrayList<String>();
		aList.add("333556565");
		aList.add("334551552");
		Persona per3 = new Persona("Mario","Gamma",63,aList);
		
		ArrayList<Persona> aListPersonas = new ArrayList<Persona>();
		aListPersonas.add(per1);
		aListPersonas.add(per2);
		aListPersonas.add(per3);
		
		Gson gson = new Gson();
		String json = gson.toJson(aListPersonas);
		System.out.println(json);
		
//		// Json to bean
//		Persona copia = gson.fromJson(json, Persona.class);
//		System.out.println(copia.toString());
		
		// Json sin bean
//		JsonObject objeto = new JsonObject();
//		objeto.addProperty("nom", "algo");
//		objeto.addProperty("nom2", "algo2");
//		
//		json = objeto.toString();
//		System.out.println(json);
		
		// Parser
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
