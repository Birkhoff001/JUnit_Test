package interface_test;

import java.awt.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Map;

public class getSentence {
	
	private String url="";
	
	public String geturl() {
		return url;
	}
	public String getHttpResponse(String param) {
		String line = "";
		String httpResults = "";
		url ="http://active.uqee.com:8081/query?sentence=" + param;
		try {
			HttpURLConnection conn = URLConnection.getConnection(url);
			BufferedReader in = null;
			Map<String, java.util.List<String>> map = conn.getHeaderFields();
			for (String key : map.keySet()) {
				System.out.println(key + "---->" + map.get(key));
				}
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = in.readLine()) != null) {
				httpResults += line;
			}
			in.close();
			conn.disconnect();
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return httpResults;
	}
}
