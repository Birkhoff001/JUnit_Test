package interface_testcase;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import interface_test.HttpRequest;

public class ConnectionTest {
	private HttpRequest m_request;
	
	@Before
	public void setUp() throws Exception {
		m_request = new HttpRequest();
	}
	
	@Test
	public void testUrlFormat() {
		HttpRequest noformat = new HttpRequest();
		String code = m_request.sendGet("http://active.uqee.com:8081/query", "liuliu");
	}
	
}
