package tdd.mailtemplate;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestTemplateParse {
	@Test
	public void emptyTemplateRendersAsEmptyString(){
		
		TemplateParse parse = new TemplateParse();
		List<String> segments = parse.parse("");
		assertEquals("Number of segments",1,segments.size());
		assertSegments(segments,"");
		
	}
	@Test
	public void TemplateWithOnlyPlainText(){
		
		TemplateParse parse = new TemplateParse();
		List<String> segments = parse.parse("plain text only");
		assertSegments(segments,"plain text only");
		
	}
	@Test
	public void parsingMultipleVariable(){
		
		TemplateParse parse = new TemplateParse();
		List<String> segments = parse.parse("${a}:${b}:${C}");
		assertSegments(segments,"${a}",":","${b}",":","${C}");
		
	}
	
	@Test
	public void parsingTemplateIntoSegmentObjects() throws Exception{
		
	}
	private void assertSegments(List<? extends Object> actual, Object... expected) {
		assertEquals("Number of segments",expected.length, actual.size());
		assertEquals(Arrays.asList(expected), actual);
	}

}
