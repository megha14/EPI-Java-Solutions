/**  
* AdvancingArray --- Given an array, where A[i] denotes the maximum you can advance from index i, find whether it is
* possible to advance to the last index starting from the beginning of the array
* @author Megha Rastogi
*/

import java.util.*;
public class AdvancingArray{

	/**
    * whether it is possible to advance to the last index starting from the beginning of the array
    * @param array indices
    * @return true or false
    */ 
	public static boolean findAdvancePossible(int[] indices){
		int nextForward = 0;
		for(int i = 0; i <= nextForward && nextForward <= indices.length-1; i++){
			nextForward = Math.max(nextForward, i + indices[i]);
		}
		return nextForward >= indices.length-1;
	}

	
	/**
    * Main Method
    * @param arg A string array containing 
    * the command line arguments.
    * @return No return value.
    */ 
	public static void main(String args[]){

		int[] indices = {3, 3, 1, 0, 2, 0, 1};
		int[] indices1 = {3, 2, 1, 0, 2, 0, 1};
		System.out.println(findAdvancePossible(indices));
	}
}
