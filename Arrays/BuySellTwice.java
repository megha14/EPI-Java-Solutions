/**  
* BuySellTwice --- Given array denoting the daily stock price, return the maximum profit
* that could be made by buying and selling a share atmost twice
* @author Megha Rastogi
*/

import java.util.*;
public class BuySellTwice{

	/**
    * return the maximum profit that could be made by buying and selling a share atmost twice
    * @param array input
    * @return integer maximum profit
    */ 
	public static int maximumProfit(int[] input){
		int maxTotalProfit = 0;
		List<Integer> firstBuySellProfits = new ArrayList<Integer>();
		int minPriceSoFar = Integer.MAX_VALUE;
		for(int i = 0; i < input.length; i++){
			minPriceSoFar = Math.min(minPriceSoFar, input[i]);
			maxTotalProfit = Math.max(maxTotalProfit, input[i] - minPriceSoFar);
			firstBuySellProfits.add(maxTotalProfit);
		}

		int maxPriceSoFar = Integer.MIN_VALUE;
		for(int i = input.length-1; i > 0; i--){
			maxPriceSoFar = Math.max(maxPriceSoFar, input[i]);
			maxTotalProfit = Math.max(maxTotalProfit, maxPriceSoFar - input[i] + firstBuySellProfits.get(i - 1));
		}
		return maxTotalProfit;
	}

	/**
    * Main Method
    * @param arg A string array containing 
    * the command line arguments.
    * @return No return value.
    */ 
	public static void main(String args[]){

		int[] input = {310, 315, 275, 295, 260, 270, 290, 230, 255, 250};
		int[] input1= {12, 11, 13, 9, 12, 8, 14, 13, 15};
		System.out.println("Maximum profit : "+maximumProfit(input1));
		
	}
}
