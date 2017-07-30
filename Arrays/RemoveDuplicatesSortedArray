/**  
* RemoveDuplicatesSortedArray --- Remove duplicate elements from a sorted array 
* @author Megha Rastogi
*/

import java.util.*;
public class RemoveDuplicatesSortedArray{

	/**
    * Remove duplicate elements from a sorted array
    * @param array input
    * @return duplicates removed array
    */ 
	public static List<Integer> removeDuplicates(ArrayList<Integer> input){
		int i = 0;
		while(i <  input.size()-1){
			if(input.get(i) == input.get(i+1)){
				input.remove(i);
			}else
				i++;
		}
		return input;
	}

	/**
    * Remove duplicate elements from a sorted array. [Book Method]
    * @param array input
    * @return remaining elements after deletion
    */ 
	public static int removeDuplicates1(ArrayList<Integer> input){
		int writeIndex = 1;
		for(int i = 1; i < input.size(); ++i){
			if(!input.get(writeIndex-1).equals(input.get(i))){
				
				input.set(writeIndex++, input.get(i));
			}
		}
		return writeIndex;
	}
	
	/**
    * Main Method
    * @param arg A string array containing 
    * the command line arguments.
    * @return No return value.
    */ 
	public static void main(String args[]){

		Integer[] input = {1, 2, 2, 2, 2, 5, 5, 6, 6, 6, 7, 8, 9, 9};
		System.out.println("Array before removing duplicates : ");
		for(int i: input)
			System.out.print(i + " ");
		System.out.println();
		
		List<Integer> output = removeDuplicates(new ArrayList<Integer>(Arrays.asList(input)));
		System.out.println("Array after removing duplicates : ");
		for(int i: output)
			System.out.print(i + " ");
		System.out.println();

		//Only printing number of unique elements
		System.out.println(removeDuplicates1(new ArrayList<Integer>(Arrays.asList(input))));
	}
}
