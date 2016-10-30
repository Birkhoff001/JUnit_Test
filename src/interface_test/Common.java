package interface_test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;

public class Common {
	
	public static void main(String[] args) throws Exception {
		Common obj = new Common();
		obj.ConvertFromJson("", "", "");
	}
	
	public Object ConvertFromJson(String url, String param, String lines) throws Exception {
//		System.out.println("I'm coming?????????????");
		String JsonValue = "";
		try {
//			System.out.println("coming???????????");
			JsonValue = HttpRequest.sendGet(url, param);
			if (JsonValue == null || JsonValue.trim().length() < 1) {
				return JsonValue ;
			}
//			System.out.println("what??i'm not here??");
			ObjectMapper mapper = new ObjectMapper(); 
			Map<String, Object> map = mapper.readValue(JsonValue, 
					new TypeReference<Map<String, Object>>(){});
			System.out.println("********JsonParser Starting********");
			traverse(map);
//			System.out.println("what??i'm not here traverse??");
//			System.out.println(JsonValue);			
//			Staff staff = mapper.readValue(JsonValue, Staff.class);
//			System.out.println(staff);
//pretty print
//			System.out.println(prettyStaff);

			return map;
		} catch (Exception e) {
			System.out.println("getJsonObject error!-----" + e);
			e.getMessage();
	}
		return null;
	}
	@JsonProperty("result")
	@SuppressWarnings({ "rawtypes" })
	public static void traverse(Object json) throws Exception {	
		try {
			if (json instanceof Map) {
//				System.out.println("8888888888");
				Map map = (Map)json;
				System.out.println("Length: " + ((HashMap) map).size());
				for (Object key : ((HashMap) map).keySet()) {
					System.out.println("key : " + key);
					traverse(((HashMap) map).get(key));

				}
			}
	
			else if (json instanceof List) {
//				System.out.println("77777777777");
				for (Object object : (List)json) {
					traverse(object);
				}
			}
			else {
				System.out.println(json);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	/*
	private static String file = "./data.json";
	
	private static void saveFile(Map map) throws IOException {
		FileWriter file_w = null;
		try {
			file_w = new FileWriter(file);
			file_w.write(map);;
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			file_w.flush();
			file_w.close();
		} 
	}
	
	public void readFile(String fileName) {
		File f = new File(fileName);
		BufferedReader reader = null;
		try {
			System.out.println("reading file content for line: ");
			reader = new BufferedReader(new FileReader(f));
			String tempString = null;
			int line = 1;
			while ((tempString = reader.readLine()) != null) {
				System.out.println("line " + line + ": " + tempString);
				fileName=tempString;
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
					
				}
			}
		}
	}
	*/
}









