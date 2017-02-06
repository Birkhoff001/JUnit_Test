package interface_test;
import interface_test.HttpRequest;
import interface_testcase.SentenceTest;
import interface_test.Common;

public class Main {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
//		String url = "http://active.uqee.com:8081/query";
		SentenceTest sen = new SentenceTest();
//		String url = "http://115.239.196.189:8081/query";
//		String param = "员工";
		System.out.println("!--------start---------!" + "\n");
		HttpRequest request = new HttpRequest();
		Common com = new Common();
		com.ConvertFromJson("", "", "");
	}
}
