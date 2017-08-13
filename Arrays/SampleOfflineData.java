/**  
* SampleOfflineData --- Given an array A and size, return a subset of given size of array elements. All subsets should be equally likely.
* Return the result in input array itself.
*/

import java.util.*;
public class SampleOfflineData{

	/**
    * Given an array A and size, return a subset of given size of array elements
    * @param array input
    * @param subset size
    * @return array result
    */ 
	public static int[] getSubset(int[] input, int size){
		
		Random rand = new Random();
		for(int i = 0; i < size; i++){
			swap(input, i, rand.nextInt(input.length - i));
		}
		return input;
	}

	/**
    * Swap element at ith position with the element at jth position in an array
    * @param array 
    * @param index i
    * @param index j
    * @return No return value.
    */ 
	public static void swap(int[] input, int i, int j){
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

	/**
    * Main Method
    * @param arg A string array containing 
    * the command line arguments.
    * @return No return value.
    */ 
	public static void main(String args[]){

		int[] input = {4, 7, 9, 11, 90, 34};
		int[] result = getSubset(input, 4);
		for(int i: result)
			System.out.print(i + " ");
		System.out.println();
	}
}
