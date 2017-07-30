/**  
* RemoveKeyArray --- Remove all occurences of key from an array
* @author Megha Rastogi
*/

import java.util.*;
public class RemoveKeyArray{

	/**
    * Remove all occurences of key from an array
    * @param array input
    * @param key to be removed
    * @return number of remaining element
    */ 
	public static int removeKey(ArrayList<Integer> input, int key){
		int i = 0;
		while(i <  input.size()-1){
			if(input.get(i) == key)
				input.remove(i);
			else
				i++;
		}
		return input.size();
	}
	
	/**
    * Remove all occurences of key from an array. [Book Method]
    * @param array input
    * @return remaining elements after deletion
    */ 
	public static int removeKey1(ArrayList<Integer> input, int key){
		int writeIndex = 1;
		for(int i = 1; i < input.size(); ++i){
			if(input.get(i) != key)
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
		System.out.println("Elements remaining after deleting 2 : "+removeKey(new ArrayList<Integer>(Arrays.asList(input)), 2));

		//Book Method
		System.out.println("Elements remaining after deleting 2 : "+removeKey1(new ArrayList<Integer>(Arrays.asList(input)), 2));
		
	}
}
