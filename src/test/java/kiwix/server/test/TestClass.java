package kiwix.server.test;

import org.testng.annotations.Test;

public class TestClass extends BaseServerSetUp {
	@Test
	public void simpleTest(){
		System.out.println("Hello World!!");
		System.out.println(System.getProperty("user.dir"));
		
	}

}
