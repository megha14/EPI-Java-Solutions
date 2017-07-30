/**  
* MulArrayIntegers --- Given two arrays representing number, return an integer which is product of them
* @author Megha Rastogi
*/

import java.util.*;
public class MulArrayIntegers{

	/**
    * Find product of number1 and number2 
    * @param array number1 
    * @param array number2
    * @return integer array representing product.
    */ 
	public static List<Integer> multiply(List<Integer> number1, List<Integer> number2){
		
		//result initialized with zero and of size length(number1) + length(number2)
		List<Integer> result = new ArrayList<Integer>(Collections.nCopies(number1.size()+number2.size(),0));

		//To store the sign of the result
		int sign = (number1.get(0)>0 ^ number2.get(0)>0) ? -1 : 1;
		
		//setting sign of first digit to positive
		number1.set(0, Math.abs(number1.get(0)));
		number2.set(0, Math.abs(number2.get(0)));

		//Multiplying and Storing the result
		for(int i = number1.size()-1; i >= 0; i--){
			for(int j = number2.size()-1; j >= 0; j--){
				result.set(i+j+1, result.get(i+j+1) + (number1.get(i) * number2.get(j)));
				result.set(i+j, result.get(i+j) + (result.get(i+j+1)/10));
				result.set(i+j+1, result.get(i+j+1)%10);
			}
		}

		int zeroesLimit = 0;
		while(zeroesLimit < result.size() && result.get(zeroesLimit) == 0)
			zeroesLimit++;

		result = result.subList(zeroesLimit, result.size());
		if(result.isEmpty())
			return Arrays.asList(0);
		result.set(0, result.get(0)*sign);
		
		return result;
	}

	
	/**
    * Main Method
    * @param arg A string array containing 
    * the command line arguments.
    * @return No return value.
    */ 
	public static void main(String args[]){

		Integer [] number1 = {1, 0, 2, 5};
		Integer [] number2 = {2, 5};
		List<Integer> product = multiply(Arrays.asList(number1), Arrays.asList(number2));
		System.out.print("Product is ");
		for(int i: product)
			System.out.print(i);
		System.out.println();
	}
}
