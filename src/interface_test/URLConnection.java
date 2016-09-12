package interface_test;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class URLConnection {
	public static HttpURLConnection getConnection(String url) {
		HttpURLConnection conn = null;
		try {
			URL getUrl = new URL(url);
			conn = (HttpURLConnection) getUrl.openConnection();
			conn.setRequestProperty("Accept-Charset", "utf-8");
			conn.setRequestProperty("Charset", "utf-8");
			conn.setRequestMethod("GET");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return conn;
	}
}
