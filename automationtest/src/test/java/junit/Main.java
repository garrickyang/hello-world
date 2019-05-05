package junit;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import cucumber.examples.java.calculator.ShoppingStepdefs;

public class Main {

	public static void main(String[] args) {
		 Result result = JUnitCore.runClasses(ShoppingStepdefs.class);  
	        System.out.println(result.getRunCount()); 
	        List<Failure> s=result.getFailures();
	        System.out.println(result.getFailureCount()+0);
	        for(Failure f:s){
	        	
	        	System.out.println(f.getException().getMessage()+1);
	        }

	}

}
