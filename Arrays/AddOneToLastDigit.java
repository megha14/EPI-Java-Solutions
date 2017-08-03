/**  
* AddOneToLastDigit --- Given an array of digits encoding a decimal integer D, update the array to represent D+1
*/

import java.util.*;
public class AddOneToLastDigit{

	/**
    * update the array to represent D+1
    * @param array input
    * @return array new D+1
    */ 
	public static List<Integer> addOne(ArrayList<Integer> input){
		int len = input.size() - 1;
		input.set(len, input.get(len)+1);
		for(int i = len; i > 0 && input.get(i) == 10; i--){
			input.set(i, 0);
			input.set(i-1,  input.get(i - 1) + 1);
		}
		if(input.get(0) == 10){
			input.set(0, 0);
			input.set(0, 1);
		}
		return input;
	}

	/**
    * Main Method
    * @param arg A string array containing 
    * the command line arguments.
    * @return No return value.
    */ 
	public static void main(String args[]){

		Integer[] input = {1, 2, 2};
		Integer[] input1 = {1, 9, 9};
		List<Integer> output = addOne(new ArrayList<Integer>(Arrays.asList(input1)));
		System.out.println("After adding 1 : "+output.toString());
		
	}
}
