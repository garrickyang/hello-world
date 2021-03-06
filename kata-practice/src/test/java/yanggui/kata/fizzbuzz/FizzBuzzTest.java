package yanggui.kata.fizzbuzz;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import yanggui.kata.fizzbuzz.FizzBuzzTransfer;

public class FizzBuzzTest {



	@Test
	public void testFizzBuzzTest() {
		assertEquals("Fizz", FizzBuzzTransfer.fizzBuzzTransfer(3));
		assertEquals("Buzz", FizzBuzzTransfer.fizzBuzzTransfer(5));
		assertEquals("FizzBuzz", FizzBuzzTransfer.fizzBuzzTransfer(15));
		assertEquals("Fizz", FizzBuzzTransfer.fizzBuzzTransfer(9));
		assertEquals("Buzz", FizzBuzzTransfer.fizzBuzzTransfer(20));
		assertEquals("FizzBuzz", FizzBuzzTransfer.fizzBuzzTransfer(30));
		assertEquals("22", FizzBuzzTransfer.fizzBuzzTransfer(22));
	}



}
