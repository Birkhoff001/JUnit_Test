package interface_test;

import java.io.BufferedReader;
import org.json.JSONException;
import org.json.JSONObject;

public class Common {
	public static String getJsonValue(String JsonString, String sentence) {
		String JsonValue = "";
		if (JsonString == null || JsonString.trim().length() < 1) {
			return null;
		}
		try {
			JSONObject obj = new JSONObject(JsonString);
			JsonValue = (String) obj.getString(sentence);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return JsonValue;
	}
}
