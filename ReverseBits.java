/**  
* ReverseBits --- Given a 64 digit number, reverse the bits and return the new numberr
* @author Megha Rastogi
*/

public class ReverseBits{

	public static long[] precomputedReverse = new long[(1 << 16)];

	/**
    * reverse the bits and return changed number
    * @param number x
    * @param number length n
    * @return changed number
    */ 
	private static long reverseBits(long x, int n) {
	    for (int i = 0, j = n; i < j; ++i, --j) {
	      x = swapBits(x, i, j);
	    }
	    return x;
  	}

	/**
    * create the cache table
    * @return  No return value.
    */ 
	private static void createPrecomputedTable() {
	    for (int i = 0; i < (1 << 16); ++i) {
	      precomputedReverse[i] = reverseBits(i, 15);
	    }
	}

	/**
    * reverse the bits and return changed number
    * @param number
    * @return changed number
    */ 
    public static long reverseNumber(long x){
    	createPrecomputedTable();
    	int MASK = 0xFFFF;
    	int MASK_SIZE = 16;
    	return (precomputedReverse[(int)(x & MASK)] << (3 * MASK_SIZE) |
    			precomputedReverse[(int)(x >>> MASK_SIZE) & MASK] << (2 * MASK_SIZE) | 
    			precomputedReverse[(int)(x >>> (2 * MASK_SIZE)) & MASK] << MASK_SIZE |
    			precomputedReverse[(int)(x >>> (3 * MASK_SIZE)) & MASK]);

    }

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

		Long n = new Long(25);
		System.out.println(reverseNumber(n));
		System.out.println(reverseBits(n, 15));
	}
}
