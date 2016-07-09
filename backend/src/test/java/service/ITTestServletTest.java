package service;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import business.Utility;

public class ITTestServletTest {

	@Test
	public void testDoBusiness() throws IOException {
		TestServlet servlet = new TestServlet();

//			try {
//				int result = servlet.doBusiness("abc", "testname").hashCode();
//			System.out.println(result);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
				//result = -537077320

		assertEquals("test doBusiness", -537077320, servlet.doBusiness("abc", "testname").hashCode());
		
	}

}
