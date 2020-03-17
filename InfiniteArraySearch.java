// Time Complexity : O(logI) where I is the index of the element
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Problem not in leetcode
// Any problem you faced while coding this : No



public class InfiniteArraySearch {
	
	public static int findIndex(int[] arr,int target) {
		
		// Array is empty
		if(arr.length == 0) {
			return -1;
		}
		
		if(arr.length == 1) {
			return (arr[0] == target)? 0 : -1;
		}
		
		int low = 0;
		int high = 1;
		int curr = arr[0];
		
		while(curr <= target) {
			if(high >= arr.length-1) {
				break;
			}
			low = high;
			if(2*high < arr.length-1) {
				high = 2*high;				
			}
			else {
				high = arr.length-1;
			}
			curr = arr[high];
		}
				
		return binSearch(arr, low, high, target);
	}
	
	public static int binSearch(int[] arr,int start, int end, int target) {
		
		while(start <= end) {
			int mid = ((end-start)/2) + start;
			
			if(arr[mid] == target) {
				return mid;
			}
			
			if(arr[mid] > target) {
				return binSearch(arr, start, mid-1, target);
			}
			return binSearch(arr, mid+1, end, target);			
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int arr[] = new int[]{3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170}; 
		int ans = findIndex(arr,0); 
		  
		if (ans == -1) 
		    System.out.println("Element not found"); 
		else
		    System.out.println("Element found at index " + ans);		
	}
}
