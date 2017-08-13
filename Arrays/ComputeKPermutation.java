/**  
* ComputeKPermutation --- Given an array A, find the kth permutation under dictionary ordering
*/

import java.util.*;
public class ComputeKPermutation{

	/**
    * Given an array A, find the previous Permutation P of A under dictionary ordering
    * @param array input
    * @return array result
    */ 
	public static List<Integer> kPermutation(List<Integer> input, int k){

		for(int j = 1; j <= k; j++){
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

		Integer[] input = {1, 2, 3, 4};
		System.out.println(kPermutation(Arrays.asList(input), 10).toString());
		System.out.println();
	}
}
