//Time Complexity: O(Logn)

import java.io.*;

class GFG {
	public static void main (String[] args) {
	    
	    int array[] = {2,6,7,16,18,18,19,20};
	    
	    int element = 18;   
	    
	    int ans =  modifiedBinarySearch(array,element); //Getting the correct index
	    
	    System.out.println(ans);
	
	}
	
	// Traditional Binary Search Function
	
	private static int binarySearch(int arr[], int number, int low, int high){
	    
	 
	    
	    while (low<=high){
	        
	        int mid = low + (high-low)/2;
	        
	        if(number>arr[mid]) low = mid + 1;
	        
	        else if(number<arr[mid]) high = mid - 1;
	        
	        else return mid;
	        
	        
	        
	    }
	    return -1;
	}
	
	
	//Modified Function using low and high pointers
	
	private static int modifiedBinarySearch(int arr[], int num){
	    
	    int low =0;
	    int high =1;
	    int temp = arr[0];
	    
	    while(temp<num){
	        
	        low = high;
	        high = 2 * high; //Incrementing high pointer by 2
	        temp = arr[high];
	    }
	    
	    //Calling binary search after finding the correct low and high window
	    
	    return binarySearch(arr, num, low, high);
	    
	    
	}
	
	
	
}