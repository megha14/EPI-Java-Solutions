/**  
* NextIntegerSameWeight --- Find the closest unsigned 64 bit integer with same weight(same number of set bits)
*/

import java.io.*;
public class NextIntegerSameWeight{

	/**
    * find the next integer with same weight 
    * @param number
    * @return changed number
    */ 
	public static long intSameWeight(long number){
		int NUMBER_BITS = 63;
		for(int i=0; i< NUMBER_BITS-1;i++){
			if(((number >>> i) & 1) != ((number >>> (i+1)) & 1)){
				long BIT_MASK = (1L << i) | (1L << (i+1));
				number ^= BIT_MASK;
				return number;
			}
		}
		throw new IllegalArgumentException("All bits are either 0 or 1");
	}
	
	/**
    * Main Method
    * @param arg A string array containing 
    * the command line arguments.
    * @return No return value.
    */ 
	public static void main(String args[]){

		System.out.println(intSameWeight(92));
	}
}
