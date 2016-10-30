package interface_test;
import interface_test.HttpRequest;
import interface_test.Common;

public class Main {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		String url = "http://active.uqee.com:8081/query";
//		String url = "http://10.0.1.36:8081/query";
		String param = "员工";
		System.out.println("!--------start---------!" + "\n");
		HttpRequest request = new HttpRequest();
		Common com = new Common();
		com.ConvertFromJson(url, param, "");
	}
}
