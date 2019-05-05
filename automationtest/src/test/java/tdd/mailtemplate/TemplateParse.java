package tdd.mailtemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateParse {

	public List<String> parse(String parseSource) {
		List<String> result = new ArrayList<>();
		int index = collectSegments(parseSource, result);
		addTail(parseSource, result, index);
		addEmpty(parseSource, result);
		return result;
	}

	private void addEmpty(String parseSource, List<String> result) {
		if (parseSource.isEmpty()) {
			result.add("");
		}
	}

	private void addTail(String parseSource, List<String> result, int index) {
		if (index < parseSource.length()) {
			result.add(parseSource.substring(index));
		}
	}

	private int collectSegments(String parseSource, List<String> result) {

		Pattern pattern = Pattern.compile("\\$\\{[^}]*\\}");
		Matcher matcher = pattern.matcher(parseSource);
		int index = 0;
		while (matcher.find()) {
			addPrecedingPlainText(parseSource, result, matcher, index);
			addVariable(parseSource, result, matcher);
			index = matcher.end();
		}
		return index;
	}

	private void addVariable(String parseSource, List<String> result, Matcher matcher) {
		result.add(parseSource.substring(matcher.start(), matcher.end()));
	}

	private void addPrecedingPlainText(String parseSource, List<String> result, Matcher matcher, int index) {
		if (index != matcher.start()) {
			result.add(parseSource.substring(index, matcher.start()));
		}
	}
	
	public List<Segment> parseSegments(String template) {
		List<Segment> segments = new ArrayList<>();
		List<String> strings = parse(template);
		for(String s:strings){
			if(Template.isVariable(s)){
				String name = s.substring(2,s.length()-1);
				segments.add(new Variable(name));
			}else{
				segments.add(new PlainText(s));
			}
		}
		return segments;
	}

}
