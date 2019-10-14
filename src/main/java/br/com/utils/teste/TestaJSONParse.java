package br.com.utils.teste;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TestaJSONParse {
	
	private static Logger logger = Logger.getLogger(TestaJSONParse.class);
	
	public static void testJsonObjectToText(){
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("name", "Fulano de Tal");
			jsonObject.put("idade", new Integer(30));
			String[] hobbies = {"games","musica","televisao"};
			jsonObject.put("hobbies", hobbies);
			jsonObject.put("balance", new Double(1000.55));
			jsonObject.put("is_vip", new Boolean(true));
			
			logger.info("TEXT: " + jsonObject.toString());
			logger.info("TEXT SIZE: " + jsonObject.toString().getBytes().length);
		} catch (JSONException e) {
			logger.error("JSONException",e);
		}
	}
	
	private static String arrayToString(JSONArray jsonArray){
		try {
			String resultado = "";
			int numItens = 0;
			for (int i=0 ; i< jsonArray.length() ; i++) {
				resultado += jsonArray.getString(i);
				numItens++;
				if (numItens<jsonArray.length()) {
					resultado += ", ";
				}
			}
			return resultado;
		} catch (JSONException e) {
			return "";
		}
	}
	
	public static void testTextToJsonObject(){
		try {
			String jsonText = "{\"balance\":1000.55,\"is_vip\":true,\"idade\":30,\"name\":\"Fulano de Tal\",\"hobbies\":[\"games\",\"musica\",\"televisao\"]}";
			JSONObject jsonObject = new JSONObject(jsonText);
			logger.info("OBJECT CONTENT: {Nome:" + jsonObject.get("name") + " | " +
					"Idade: " + jsonObject.get("idade") + " | " + 
					"Hobbies: " + arrayToString(jsonObject.getJSONArray("hobbies")) + " | " +
					"Balance: " + jsonObject.get("balance") + " | " +
					"Is VIP: " + jsonObject.get("is_vip")+"}");
		} catch (JSONException e) {
			logger.error("JSONException",e);
		}
		
	}
	
	public static void main(String[] args) {
		testJsonObjectToText();
		testTextToJsonObject();
	}
}
