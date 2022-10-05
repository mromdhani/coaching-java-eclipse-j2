package lu.cronos._03_private_methods_in_interfaces;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;


interface CustomCalculator 
{
	private int add(IntPredicate predicate, int... nums) { 
        return IntStream.of(nums)
                .filter(predicate)
                .sum();
    }
	
	default int addEvenNumbers(int... nums) {
        return add(n -> n % 2 == 0, nums);
    }
 
    default int addOddNumbers(int... nums) {
        return add(n -> n % 2 != 0, nums);
    }
 
    
}
public class PrivateMethodsInTerfaces {

	public static void main(String[] args) {
		CustomCalculator calculator = new CustomCalculator() {};

		int sum = calculator.addOddNumbers(1,2,3,4,5);
        System.out.println(sum);		
	}

}
