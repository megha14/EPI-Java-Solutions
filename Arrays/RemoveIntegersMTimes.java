/**  
* RemoveIntegersMTimes --- Given sorted array A and a positive integer m, update A so that if x appears m times in Array A
* it appears exactly min(2, m) times in A
* @author Megha Rastogi
*/

import java.util.*;
public class RemoveIntegersMTimes{

	/**
    * Remove all occurences of key from an array
    * @param array input
    * @param key to be removed
    * @return array of remaining element
    */ 
	public static List<Integer> updateArray(ArrayList<Integer> input, int key){
		int i = 0, count = 0;
		while(i <  input.size()-1){
			if(input.get(i) == input.get(i+1)){
				count++;
				if(count >= Math.min(2, key))
					input.remove(i);
				else
					i++;
			}
			else{
				count = 0;
				i++;
			}
		}
		return input;
	}
	
	/**
    * Remove all occurences of key from an array. [Book Method]
    * @param array input
    * @return remaining elements after deletion
    */ 
	public static int removeKey1(ArrayList<Integer> input, int key){
		int writeIndex = 1, count = 0;
		for(int i = 1; i < input.size(); ++i){
			count++;
			if(input.get(writeIndex-1) != input.get(i)){
				input.set(writeIndex++, input.get(i));
				count = 0;
			}
			else if(input.get(writeIndex-1) == input.get(i) && count < Math.min(2, key))
				input.set(writeIndex++, input.get(i));
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
		System.out.println("Elements remaining after deleting : "+updateArray(new ArrayList<Integer>(Arrays.asList(input)), 2).toString());

		//Book Method
		System.out.println("Elements remaining after deleting : "+removeKey1(new ArrayList<Integer>(Arrays.asList(input)), 2));
		
	}
}
