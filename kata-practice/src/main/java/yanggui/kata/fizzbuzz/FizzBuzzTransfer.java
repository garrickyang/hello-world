package yanggui.kata.fizzbuzz;

public class FizzBuzzTransfer {
	
	public static String fizzBuzzTransfer(int inputNumber) {
		String result = "";
		if(inputNumber==0){
			return result;
		}
		if (inputNumber % 3 == 0) {
			result += "Fizz";
		}
		if (inputNumber % 5 == 0) {
			result+= "Buzz";
		}
		return result.isEmpty()?result+inputNumber:result;
	}
	
//	public static void main(String[] arg){
//		for(int i=1;i<=100;i++){
//			System.out.println(fizzBuzzTransfer(i));
//		}
//	}
	
}
