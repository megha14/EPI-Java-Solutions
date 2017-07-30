/**  
* AdvancingArrayMinSteps --- Given an array, where A[i] denotes the maximum you can advance from index i, find minimum number
* of steps required to advance to the last index starting from the beginning of the array
* @author Megha Rastogi
*/

import java.util.*;
public class AdvancingArrayMinSteps{

	/**
    * minimum number of steps required to advance to the last index starting from the beginning of the array
    * @param array indices
    * @return integer steps
    */ 
	public static int findAdvancePossible(int[] indices){
		int nextForward = 0, steps = 0;
		for(int i = 0; i <= nextForward && nextForward <= indices.length-1; i++){
			if(nextForward < i+indices[i] && nextForward < indices.length-1){
				nextForward = Math.max(nextForward, i + indices[i]);
				steps++;
			}
		}
		return (nextForward == indices.length-1 ? steps : -1);
	}

	
	/**
    * Main Method
    * @param arg A string array containing 
    * the command line arguments.
    * @return No return value.
    */ 
	public static void main(String args[]){

		int[] indices = {4, 3, 1, 0, 2, 0, 1};
		int[] indices1 = {3, 2, 1, 0, 2, 0, 1};
		System.out.println(findAdvancePossible(indices));
	}
}
