// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


/* Binary Search Approach, check if middle is equal to target, if not then check for sorted array and then adjust low and high */

class SearchInaRotatedArray {
	
	public static int search(int[] nums, int target) {
		if(nums == null || nums.length == 0)
			return -1;
		
		int low = 0;
		int high = nums.length - 1;
		
		while(low <= high) {
			int mid = low + (high - low) / 2;
			
			//case 1 : if target is mid, then return mid
			if(nums[mid] == target)
				return mid;
			
			//case 2: if right half is sorted array
			else if(nums[mid] <= nums[high]) {
				if(target > nums[mid] && target <= nums[high]) 		// search in right sorted half array
					low = mid + 1;
				else
					high = mid -1;									// search in left half
			}
			
			//case 3: if left half is sorted array
			else if(nums[low] <= nums[mid]) {
				if(target >= nums[low] && target < nums[mid])		// search in left sorted half array
					high = mid - 1;
				else
					low = mid + 1;									// search in right half 
			}
		}
		return -1;				// returning -1, if not found
	}
	
	public static void main (String[] args) {
		int nums[] = {4,5,6,7,0,1,2};
		int target = 0;
		int index = search(nums, target);
		if(index == -1)
			System.out.println("Not found");
		else
			System.out.println("Found at index " +index);
	}
}
