package tdd.mailtemplate;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestTemplate {

	private Template template;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void oneVariable() throws MissingValueException {
		template = new Template("Hello, ${name}");
		template.set("name","Reader");
		assertEquals("Hello, Reader", template.evaluate());
	}
	@Test
	public void differentValue() throws MissingValueException {
		 template = new Template("Hello, ${name}");
		template.set("name","someone else");
		assertEquals("Hello, someone else", template.evaluate());
	}
	@Test
	public void multiValue() throws MissingValueException {
		Template template = new Template("${one}, ${two}, ${three}");
		template.set("one","1");
		template.set("two","2");
		template.set("three","3");
		assertEquals("1, 2, 3", template.evaluate());
	}
	@Test 
	public void ifMissingvalue_thenThrowsException()  {
					try {
						new Template("${foo}").evaluate();						
						fail();
					} catch (MissingValueException e) {
						System.out.println(e.getMessage());
						assertEquals("No Value for ${foo}", e.getMessage());
					}		
		
	
	}

}
