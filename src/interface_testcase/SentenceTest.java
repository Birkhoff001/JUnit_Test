package interface_testcase;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import interface_test.Common;
import interface_test.HttpRequest;
import interface_test.getSentence;
import interface_test.URLConnection;

public class SentenceTest {

	@Before
	public void setUp() throws Exception {
	}
		
	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testSentence() throws IOException {
		String url = "http://active.uqee.com:8081/query";
		String param = "20";
		String s = HttpRequest.sendGet(url, param);
		System.out.println(s);		
	
//		choice = "查询年龄18的员工的名字,年龄,生日,工资,技能","查询工资18的员工的名字,年龄,生日,工资,技能"
	}

}