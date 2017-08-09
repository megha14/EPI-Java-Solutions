/**  
* PermuteElements --- Given an array A of n elements and a permutation P, apply P to A
*/

import java.util.*;
public class PermuteElements{

	/**
    * Given an array A of n elements and a permutation P, apply P to A
    * @param array input
    * @param array permutation
    * @return array result
    */ 
	public static char[] applyPermutation(char[] input, int[] permutation){
		
		char[] result = new char[input.length];
		for(int i = 0; i < input.length; i++)
			result[permutation[i]] = input[i];
		return result;
	}

	/**
    * Given an array A of n elements and a permutation P, apply P to A
    * @param array input
    * @param array permutation
    * @return array result
    */ 
	public static char[] applyPermutation_first(char[] input, int[] permutation){
		
		for(int i = 0; i < input.length; i++){
			int next = i;
			while(permutation[next] >= 0){
				swap(input, i, permutation[next]);
				int temp = permutation[next];
				permutation[next] = permutation[next] - permutation.length;
				next = temp;
			}
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
	public static void swap(char[] input, int i, int j){
		char temp = input[i];
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

		char[] input = {'a', 'b', 'c', 'd'};
		int[] permutation = {1, 0, 3, 2};
		char[] result = applyPermutation_first(input, permutation);
		for(char i: result)
			System.out.print(i + " ");
		System.out.println();
	}
}
