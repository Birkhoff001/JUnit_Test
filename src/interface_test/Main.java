package interface_test;
import interface_test.HttpRequest;
import interface_test.Common;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;

public class Main {
	public static void main(String[] args) throws Exception {
		String url = "http://active.uqee.com:8081/query";
		String param = "20";
		System.out.println("!--------start---------!" + "\n");
		HttpRequest request = new HttpRequest();
		Common com = new Common();
		com.ConvertFromJson(url, param, "");
	}
}
