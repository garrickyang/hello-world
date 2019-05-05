package tdd.mailtemplate;

import com.sun.jna.platform.win32.ObjBase;

public interface Segment {
	

}
class PlainText implements Segment{
	private String text;
	public PlainText (String text) {
		this.text = text;
	}
	
	public boolean equals(Object other){
		return text.equals(((PlainText) other).text);
	}
}

class Variable implements Segment{
	private String name;
	public Variable(String name){
		this.name = name;
	}
	public boolean equals(Object other){
		return name.equals(((Variable) other).name);
	}
}