package interface_testcase;

import interface_test.Common;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class SentenceTests {
	
	public void setUp() throws Exception {
	}
	
	
//"sentence"	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testSentence() throws Exception {

		Common sen = new Common();
		String url = "http://active.uqee.com:8081/query";
		String param = "20";
		System.out.println("\n" + "====O(∩_∩)O==== " + "语音输入：" + param + " ====O(∩_∩)O==== ");
		Map test_convert = (Map) sen.ConvertFromJson(url, param, "");
		Map result =  (Map) test_convert.get("result");
		String sentence = (String)result.get("sentence");
		assertEquals("查询工资20的员工的名字,年龄,生日,工资,技能", sentence);
		return;
	}
	
//"sentence_type"	
	@Test
	public void testSentence_type() throws Exception {
		Common sen = new Common();
		String url = "http://active.uqee.com:8081/query";
		String param = "员工";
		System.out.println("\n" + "====O(∩_∩)O==== " + "语音输入：" + param + " ====O(∩_∩)O==== ");
		Map test_code = (Map) sen.ConvertFromJson(url, param, "");
		Map result = (Map) test_code.get("result");
		String sen_type = (String) result.get("sentence_type");
		assertEquals("SHOW", sen_type);
		return;
	}
//"fields"	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testFields() throws Exception {
		Common sen = new Common();
		String url = "http://active.uqee.com:8081/query";
		String param = "20";
		System.out.println("\n" + "====O(∩_∩)O==== " + "语音输入：" + param + " ====O(∩_∩)O==== ");
		Map test_convert = (Map) sen.ConvertFromJson(url, param, "");
		Map result =  (Map)test_convert.get("result");
		List<String> fields = (List<String>)result.get("fields");
		assertEquals("名字", fields.get(0));
		assertEquals("年龄", fields.get(1));
		assertEquals("生日", fields.get(2));
		assertEquals("工资", fields.get(3));
		assertEquals("技能", fields.get(4));
		
		return;
	}
//"rows"	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testRows() throws Exception {
		Common sen = new Common();
		String url = "http://active.uqee.com:8081/query";
		String param = "18";
		System.out.println("\n" + "====O(∩_∩)O==== " + "语音输入：" + param + " ====O(∩_∩)O==== ");
		Map test_convert = (Map) sen.ConvertFromJson(url, param, "");
		Map result =  (Map)test_convert.get("result");
		List<List<String>> rows = (List<List<String>>)result.get("rows");
		assertEquals("18", rows.get(0).get(1));
		return;
	}

//"result"	
		@Test
		public void testResult() throws Exception {
			Common sen = new Common();
			String url = "http://active.uqee.com:8081/query";
			String param = "20";
			System.out.println("\n" + "====O(∩_∩)O==== " + "语音输入：" + param + " ====O(∩_∩)O==== ");
			Map test_result = (Map) sen.ConvertFromJson(url, param, "");
			Map result = (Map)test_result.get("result");
			equals(result != null);
			return;
		}
	
//"code"	
	@SuppressWarnings("rawtypes")
	@Test
	public void testCode() throws Exception {
		Common sen = new Common();
		String url = "http://active.uqee.com:8081/query";
		String param = "20";
		System.out.println("\n" + "====O(∩_∩)O==== " + "语音输入：" + param + " ====O(∩_∩)O==== ");
		Map test_code = (Map) sen.ConvertFromJson(url, param, "");
		String code = (String) test_code.get("code");
		assertEquals("10000", code);
		return;
	}
	
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	@Test
	public void testRows_() throws Exception {
		Common sen = new Common();
		String url = "http://active.uqee.com:8081/query";
		String param = "李刚的生日";
		System.out.println("\n" + "====O(∩_∩)O==== " + "语音输入：" + param + " ====O(∩_∩)O==== ");
		Map test_code = (Map) sen.ConvertFromJson(url, param, "");
		List<List<String>> code = (List<List<String>>) test_code.get("choices");
//		List<List<String>> rows = (List<List<String>>) code.get("rows");
		assertEquals("1988-11-12", code);
		return;
	}
}
