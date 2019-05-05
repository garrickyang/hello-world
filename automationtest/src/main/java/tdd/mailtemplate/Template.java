package tdd.mailtemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import gherkin.formatter.model.Result;


public class Template {
	private Map<String, String> variableValue;
    private String templateText;
    
	public Template(String tempalteText) {
		this.templateText = tempalteText;
		variableValue = new HashMap<>();
	}

	public void set(String variable, String value) {
		
		variableValue.put(variable, value);
	}

	public String evaluate() throws MissingValueException {
		TemplateParse templateParse = new TemplateParse();
		List<String> segments = templateParse.parse(templateText);
		return concatenate(segments);
	}

	private String concatenate(List<String> segments) throws MissingValueException {
		StringBuilder result = new StringBuilder();
		for(String segment:segments){
			append(result, segment);
		}
		return result.toString();
	}

	private void append(StringBuilder result, String segment) throws MissingValueException {
		if(isVariable(segment)){
			evaluateVariable(result, segment);
		}else{
			result.append(segment);
		}
	}

	private void evaluateVariable(StringBuilder result, String segment) throws MissingValueException {
		String var = segment.substring(2, segment.length()-1);
		if(!variableValue.containsKey(var)){
			throw new MissingValueException("No Value for "+segment);
		}
		result.append(variableValue.get(var));
	}

	public static boolean isVariable(String segment) {
		return segment.startsWith("${") && segment.endsWith("}");
	}

	private String replaceVariables() {
		for(Entry<String, String> entry:variableValue.entrySet()){
			String regex;
			regex = "\\$\\{"+entry.getKey()+"\\}";
			templateText=templateText.replaceAll(regex, entry.getValue());
		}
		return templateText;
	}

	private void checkForMissingValue() throws MissingValueException {
		if(templateText.matches(".*\\$\\{.+\\}.*")){
			throw new MissingValueException("No Value for "+templateText);
		}
	}

}
