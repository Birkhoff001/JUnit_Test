package interface_test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/*import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;*/


public class HttpRequest {
	/*
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */

	public static String sendGet(String url, String param) {
		String in = param;
		//BufferedReader in = new BufferedReader(new FileReader("foo.in"));
		try {
			String urlNameString = url + "?sentence=" + param;
			URL getUrl = new URL(urlNameString);
			//open url connection
			HttpURLConnection conn = (HttpURLConnection)getUrl.openConnection();

			//setting common params of request			
//			connection.setRequestProperty("accept", "*/*");
//			connection.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("ContentType","text/xml;charset=UTF-8");
			conn.setRequestProperty("user-agent", 
					"securityd (unknown version) CFNetwork/758.4.3 Darwin/15.5.0");
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(10000);
			int responseCode = conn.getResponseCode();
			if (responseCode != 200) {
				conn.disconnect();
				System.err.print(responseCode);
				return in;
			}
			//ObjectMapper mapper = new ObjectMapper();

			//get characters all of the data return for server
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			System.out.println("======Contents of get request======");
			String lines;
			while ((lines = reader.readLine()) != null) {
				System.out.println(lines);
			}
			reader.close();
			
			//close connection
			conn.disconnect();
			System.out.println("======Contents of get request ends======");
		}
		catch (Exception e) {
			System.out.println("send GET request err------------!" + e);
			e.printStackTrace();
		}
		return param;



	}
	public String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			URL realUrl = new URL(url);
			//open url connection
			URLConnection connection = realUrl.openConnection();
			
			//setting common params of request
//			connection.setRequestProperty("accept", "*/*");
//			connection.setRequestProperty("connection", "Keep-Alive");
//			connection.setRequestProperty("user-agent", 
//					"securityd (unknown version) CFNetwork/758.4.3 Darwin/15.5.0");
//			connection.setRequestProperty("user-agent", 	
//					"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/600.8.9 (KHTML, like Gecko) Version/8.0.8 Safari/600.8.9");
			//send POST request have to set flow two lines
			connection.setDoOutput(true);
			connection.setDoInput(true);
			//get URLConnection object's OutputStream
			out = new PrintWriter(connection.getOutputStream());
			//send request param
			out.print(param);
			//flush buffer of OutputStream
			out.flush();
			//defined BufferedReader InputStream to readline url response.
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		}
		catch (Exception e) {
			System.out.println("send POST request err------------!" + e);
			e.printStackTrace();
		}
		finally {
			try {
				if (out != null) {
					out.close();
				}			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}


