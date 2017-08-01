/**  
* BuySellOnce --- Given sorted array denoting the daily stock price, return the maximum profit
* that could be made by buying and selling one share of that stock 
* @author Megha Rastogi
*/

import java.util.*;
public class BuySellOnce{

	/**
    * return the maximum profit that could be made by buying and selling one share of that stock 
    * @param array input
    * @return integer maximum profit
    */ 
	public static int maximumProfit(int[] input){
		int minimum = Integer.MAX_VALUE, profit = 0;
		for(int i = 1; i < input.length; i++){
			profit = Math.max(profit, input[i] - minimum);
			minimum = Math.min(minimum, input[i]);
		}
		return profit;
	}

	/**
    * Main Method
    * @param arg A string array containing 
    * the command line arguments.
    * @return No return value.
    */ 
	public static void main(String args[]){

		int[] input = {310, 315, 275, 295, 260, 270, 290, 230, 255, 250};
		System.out.println("Maximum profi : "+maximumProfit(input));
		
	}
}
