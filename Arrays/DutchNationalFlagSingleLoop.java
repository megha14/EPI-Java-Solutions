/**  
* DutchNationalFlagSingleLoop --- Given an array A and an index i, rearrange the elements 
* in such a way that elements less than A[i] appear first 
* followed by elements greater than A[i].
* @author Megha Rastogi
*/

public class DutchNationalFlagSingleLoop{

	// enum color to store three colors
	static enum color {Red, White, Blue};

	/**
    * Rrrange the elements in such a way that elements less than A[i] appear first 
	* followed by elements greater than A[i].
    * @param array 
    * @param pivot
    * @return changed array
    */ 
	public static void rearrangeArray(color[] array, int pivot){
		color p = array[pivot];
		int left = 0;
		for(int i = 0; i < array.length; ++i){
			if(array[i].ordinal() < p.ordinal())
				swap(array, left++, i);
		}
		int right = array.length-1;
		for(int i = array.length-1; i >= 0 && array[i].ordinal() >= p.ordinal(); --i){
			if(array[i].ordinal() > p.ordinal())
				swap(array, right--, i);
		}
	}

	/**
    * Swap element at ith position with the element at jth position in an array
    * @param array 
    * @param index i
    * @param index j
    * @return No return value.
    */ 
	public static void swap(color[] array, int i, int j){
		color temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	/**
    * Main Method
    * @param arg A string array containing 
    * the command line arguments.
    * @return No return value.
    */ 
	public static void main(String args[]){

		color[] arr = {color.Red, color.White, color.Blue, color.Red, color.Blue, color.White, color.White};
		System.out.println("Original Array : ");
		for(int i = 0; i< arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println();

		rearrangeArray(arr, 1);

		System.out.println("Result Array : ");
		for(int i = 0; i< arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
		}
}
