/**  
* ComputeNextPermutation --- Given an array A, find the next Permutation P of A under dictionary ordering
*/

import java.util.*;
public class ComputeNextPermutation{

	/**
    * Given an array A, find the next Permutation P of A under dictionary ordering
    * @param array input
    * @return array result
    */ 
	public static List<Integer> nextPermutation(List<Integer> input){
		
		int changeIndex = input.size()-2;
		
		while(changeIndex >= 0 && input.get(changeIndex) >= input.get(changeIndex+1))
			changeIndex--;

		if(changeIndex == -1)
			return Collections.emptyList();

		for(int i = input.size() - 1; i > changeIndex; i--){
			if(input.get(i) > input.get(changeIndex)){
				Collections.swap(input, changeIndex, i);
				break;
			}
		}

		Collections.reverse(input.subList(changeIndex+1, input.size()));

		return input;
	}

	/**
    * Main Method
    * @param arg A string array containing 
    * the command line arguments.
    * @return No return value.
    */ 
	public static void main(String args[]){

		Integer[] input = {1, 2, 4, 3};
		System.out.println(nextPermutation(Arrays.asList(input)).toString());
		System.out.println();
	}
}
