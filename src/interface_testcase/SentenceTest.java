package interface_testcase;

import java.util.Map;

import interface_test.Common;

class Sentence {
	Sentence() {}
	String url() {
		return "http://115.239.196.189:8081/query";
	}
	String param() {
		return "20";
	}
	void getForm() {
		new Common();
	}
	void assertsResult() {
		getForm();
		Map<String, Object> convert = Common.ConvertFromJson(url(), param(), "");
		Object result = convert.get("result");
		assertEquals("result:", result);
	}
	void assertsSentenceType() {
		getForm();
		Map<String, Object> convert = Common.ConvertFromJson(url(), param(), "");
		Object result = convert.get("result");
		assertEquals(param(), getForm());
	}
	public void prt(String s) {
		System.out.println("\n" + "============" + "语音输入：" + param());
	}
}
public class SentenceTest {
	public void sentenceTest() throws Exception {
		Sentence sen = new Sentence();
		sen.assertsResult();
		sen.assertsSentenceType();
	}
}
