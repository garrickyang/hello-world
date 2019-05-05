package yanggui.automationtest;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;

public class Stepdefs2 {
	@When("^I see the following cooked I should say:$")
	public void i_see_the_following_cooked_I_should_say(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		 List<Cuke> actualCukes = new ArrayList();
		    actualCukes.add(new Cuke("Bacon", "Yum!"));
		    actualCukes.add(new Cuke("Peas", "Really?")); 
		    arg1.diff(actualCukes);
	}

	class Cuke {
		public Cuke(String a, String b) {
			this.food = a;
			this.say = b;

		}

		String food;
		String say;

	}
}
