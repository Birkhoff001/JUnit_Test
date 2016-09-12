package interface_test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HttpRequestTest {
	private static HttpRequest conn = new HttpRequest();
	
	@Before
	public void setUp(String url, String param) throws Exception {
		conn.sendGet(url, param);
	}

	@After
	public void tearDown(String url, String param) throws Exception {
		conn.sendGet(url, param);
	}

	@Test
	public void testSendGet() {
		
	}

	@Test
	public void testSendPost() {

	}

}
