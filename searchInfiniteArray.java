// Time Complexity :  O(logn)
// Space Complexity : O(n) - size of the input array. We can not define N as it can be infinite.
// Did this code successfully run on Leetcode : it is not present on leet code
// Any problem you faced while coding this :

class InfiniteArraySearch{ 
	public int search(int[] nums, int target){	
		int low = 0; 	//set low as 0
		int high = 1;   //set high as 1
		if(nums == null || nums.length == 0) return -1; //check if array is empty or null, then return -1
		while(target >= nums[high])
		{ // If the target is not present between low and high,
		low = high; //we will set low to high. 
		high = high * 2; // we will double the value of high
		}	
		while(low <= high) // When the value of low and high is found, in which the element is present than we will perform normal binary search.
		{ 
			int mid = low + (high - low) / 2;
			if(nums[mid] == target){ return mid; }
			else if(nums[mid] > target) { high = mid -1; }
			else{ low = mid + 1; }

		}
		return -1; // If the element is not present in the infinte array than we will return -1;
	}

}