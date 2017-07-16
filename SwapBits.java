/**  
* SwapBits --- Given a 64 digit number, swap bit at ith position with jth position
* @author Megha Rastogi
*/

public class SwapBits{

	/**
    * swap bits at ith position and jth position 
    * @param number
    * @param ith position
    * @param jth position
    * @return changed number
    */ 
	public static long swapBits(long number, int i, int j){
		if(((number >>> i) & 1) != ((number >>> j) & 1)){
			long BIT_MASK = (1L << i) | (1L << j);
			number ^= BIT_MASK;
		}
		return number;
	}
	
	/**
    * Main Method
    * @param arg A string array containing 
    * the command line arguments.
    * @return No return value.
    */ 
	public static void main(String args[]){

		System.out.println(swapBits(73, 1, 6));
	}
}
