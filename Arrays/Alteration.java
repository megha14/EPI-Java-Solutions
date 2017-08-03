/**  
* Alteration --- Given an array of n numbers, rearrange elements of A to get new Array B such that B[0] <= B[1] >= B[2] <= B[3] >= B[4]..
*/

import java.util.*;
public class Alteration{

	/**
    * rearrange elements of A according to the alteration property
    * @param array input
    * @return array new D+1
    */ 
	public static int[] alteration(int[] input){

		for(int i = 0; i < input.length-1; i++){
			if((i % 2 != 0 && input[i] < input[i+1])
				|| (i % 2 == 0 && input[i] > input[i+1]))
				swap(input, i, i+1);
		}
		return input;
	}

	/**
    * swap elements at position i and j
    * @param array input
    * @param i position
    * @param j position
    * @return array new D+1
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

		int[] input = {9, 10, 11, 13, 16, 14, 17, 2, 5};
		int[] output = alteration(input);
		System.out.println("After alteration 1 : ");
		for(int i: output)
			System.out.print(i+" ");
		
	}
}
