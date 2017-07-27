/**  
* DutchNationalFlagTwoPass --- Given an array A and an index i, rearrange the elements 
* in such a way that elements less than A[i] appear first 
* followed by elements greater than A[i].
* @author Megha Rastogi
*/

public class DutchNationalFlagTwoPass{

    /**
    * Rrrange the elements in such a way that elements less than A[i] appear first 
    * followed by elements greater than A[i].
    * @param array 
    * @param pivot
    * @return No return value.
    */ 
	public static void rearrangeArray(int[] array, int pivot){
		for(int i = 0; i < array.length; i++){
			for(int j = i+1; j < array.length; j++){
				if(array[j]<array[pivot]){
					swap(array, i, j);
					break;
				}
			}
		}

		for(int i = array.length-1; i >= 0 && array[i] >= array[pivot]; i--){
			for(int j = i - 1; j >= 0 && array[j] >= array[pivot]; j--){
				if(array[j]>array[pivot]){
					swap(array, i, j);
					break;
				}
			}
		}
	}

    /**
    * Swap element at ith position with the element at jth position in an array
    * @param array 
    * @param index i
    * @param index j
    * @return No return value.
    */ 
	public static void swap(int[] array, int i, int j){
		int temp = array[i];
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
		int[] arr = {0, 1, 2, 0, 2, 1, 1};

		rearrangeArray(arr, 3);
		for(int i = 0; i< arr.length; i++)
			System.out.print(arr[i]+" ");
		}
}
