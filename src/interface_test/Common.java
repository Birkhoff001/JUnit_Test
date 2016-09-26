package interface_test;

import java.io.IOException;
//import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

//import interface_test.Staff;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;

public class Common {
	
	public static void main(String[] args) throws Exception {
		Common obj = new Common();
		obj.ConvertFromJson("", "", "");
	}
	
	
	
	public void ConvertFromJson(String url, String param, String lines) throws Exception {
		System.out.println("I'm coming?????????????");
		String JsonValue = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println("coming???????????");
			JsonValue = HttpRequest.sendGet(url, param);
			if (JsonValue == null || JsonValue.trim().length() < 1) {
				return ;
			}
			System.out.println("what??i'm not here??");
			
			traverse(JsonValue);
			System.out.println("what??i'm not here traverse??");
			System.out.println(JsonValue);			
//			Staff staff = mapper.readValue(JsonValue, Staff.class);
//			System.out.println(staff);
//pretty print
//			String prettyStaff = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);
//			System.out.println(prettyStaff);
			
		} catch (Exception e) {
			System.out.println("getJsonObject error!-----" + e);
			e.getMessage();
		
		return;
	}
	}
	
	public static void traverse(Object param) {
		System.out.println("OOOOOOOOOO");
		ObjectMapper mapper = new ObjectMapper();
		try {
			Map<Object, Map<String, Object>> maps = (Map)mapper.readValue("", Map.class);
			System.out.println(maps);
			System.out.println(maps.size());
//			System.out.println("print keyset--------");	
			Set<Object> key = maps.keySet();
			System.out.println("this is key!!------" + key);
			Iterator<Object> iter = key.iterator();
			while (iter.hasNext()) {
				Object field = iter.next();
				System.out.println(field + ":" + maps.get(key));
			}
			if (param instanceof Map) {
				System.out.println("8888888888");
				Map<String, Map<String, Object>> map = (Map)param;
				for (Object key1 : map.keySet()) {
					System.out.println(key1);
					traverse(map.get(key1));
				}
			}
			else if (param instanceof List) {
				System.out.println("77777777777");
				for (Object object : (List)param) {
					traverse(object);
				}
			}
			else {
				System.out.println(param);
			}
		} catch (JsonParseException e) {
	        	e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
