/**  
* LongestEqualSubArray --- Given an array of integers, find the length of a longest subarray, all of whose entries are equal.
* @author Megha Rastogi
*/

import java.util.*;
public class LongestEqualSubArray{

	/**
    * return the length of a longest subarray, all of whose entries are equal
    * @param array input
    * @return max length
    */ 
	public static int maxLength(int[] input){
		int maxLengthSoFar = 0, length = 0;
		for(int i = 0; i < input.length-1; i++){
			if(input[i] == input[i+1])
				length++;
			else{
				maxLengthSoFar = Math.max(maxLengthSoFar, length+1);
				length = 0;
			}
		}
		return maxLengthSoFar;
	}

	/**
    * Main Method
    * @param arg A string array containing 
    * the command line arguments.
    * @return No return value.
    */ 
	public static void main(String args[]){

		int[] input = {1, 2, 2, 2, 3, 3, 4, 4, 4, 4, 5, 6, 7, 7, 7, 8};
		int[] input1 = {1, 2, 2, 2, 3, 4, 4, 3, 4, 4, 5, 6, 7, 7, 7, 8};
		System.out.println("Maximum length with all entries equal : "+maxLength(input));
		
	}
}
