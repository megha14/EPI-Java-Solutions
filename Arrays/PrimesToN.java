/**  
* PrimesToN --- Given a number N, return all primes till N.
*/

import java.util.*;
public class PrimesToN{

	/**
    * Given a number N, return all primes till N. Complecity O(n log log n)
    * @param numnper input
    * @return array of primes
    */ 
	public static ArrayList<Integer> primesToN(int input){
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		ArrayList<Boolean> isPrime = new ArrayList<Boolean>(Collections.nCopies(input+1, true));

		isPrime.set(0, false);
		isPrime.set(1, false);

		for(int i = 2; i <= input; i++){
			if(isPrime.get(i)){
				primes.add(i);
				for(int j = i; j <= input; j = j + i)
					isPrime.set(j, false);
			}
		}

		return primes;
	}

	/**
    * Given a number N, return all primes till N. Complecity O(n * root of n)
    * @param numnper input
    * @return array of primes
    */ 
	public static ArrayList<Integer> primesToN_first(int input){
		ArrayList<Integer> primes = new ArrayList<Integer>();
		boolean flag;
		for(int number = 2; number <= input; number++){
			flag = true;
			for(int i = 2; i <= (int)Math.sqrt(number); i++){
				if(number % i == 0){
					flag = false;
					break;	
				}
			}
			if(flag)
				primes.add(number);
		}
		return primes;
	}

	/**
    * Given a number N, return all primes till N. Complecity O(n * root of n)
    * @param numnper input
    * @return array of primes
    */ 
	public static ArrayList<Integer> primesToN_second(int input){
		int size = (int)Math.floor(0.5 * (input - 1)) + 1;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		ArrayList<Boolean> isPrime = new ArrayList<Boolean>(Collections.nCopies(size, true));
		for(long i = 0; i < size; i++){
			if(isPrime.get((int)i)){
				int p = ((int)i * 2) + 3;
				primes.add(p);

				for(long j = ((i * i) * 2)+ 6 * i + 3; j < size; j+=p){
					isPrime.set((int)j, false);
}
			}
		}
		return primes;
	}


	/**
    * Main Method
    * @param arg A string array containing 
    * the command line arguments.
    * @return No return value.
    */ 
	public static void main(String args[]){

		int input = 25;
		System.out.println("Primes till "+input+" : "+primesToN_second(input).toString());
		
	}
}
