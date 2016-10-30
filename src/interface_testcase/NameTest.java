package interface_testcase;

import andycpp.Main;
import interface_test.Common;

public class NameTest {
	private Common map;
	
	public void SetUp() throws Exception {
		map = new Common();
	}
	public void checkName() {
		try {
			map.ConvertFromJson(null, null, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
