/*
   
Search in Infinite sorted array:


*/

//Time comlpexity - O(log n) 
//space complexity  - O(n)  
// Did this code successfully run on Leetcode : Yes
/*
Any problem you faced while coding this : None

*/  

// Your code here along with comments explaining your approaches

class Solution 
{ 
	// Simple binary search algorithm 
	static int binarySearch(int arr[], int l, int r, int x) 
	{ 
		if (r>=l) 
		{ 
			int mid = l + (r - l)/2; 
			if (arr[mid] == x) 
				return mid; 
			if (arr[mid] > x) 
				return binarySearch(arr, l, mid-1, x); 
			return binarySearch(arr, mid+1, r, x); 
		} 
		return -1; 
	} 
	
	// searched and returns its position if found else -1. 
	static int findPos(int arr[],int key) 
	{ 
		int l = 0, h = 1; 
		int val = arr[0]; 

		// Find h to do binary search 
		while (val < key) 
		{ 
			l = h;	 // store previous high 
			//length to prevent ArrayOutOfBoundException 
			if(2*h < arr.length-1) 
			h = 2*h;			 
			else
			h = arr.length-1; 
			
			val = arr[h]; 
		} 

		return binarySearch(arr, l, h, key); 
	} 

	public static void main(String[] args) 
	{ 
		int arr[] = new int[]{3, 5, 7, 9, 10, 90, 
							100, 130, 140, 160, 170}; 
		int result = findPos(arr,10); 
		
		if (result==-1) 
			System.out.println("Element  found"); 
		else
			System.out.println("Element found at index " + result); 
	} 
} 
