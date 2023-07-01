// Time Complexity : O(log(n)) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class RotatedSortedArray {
	
	public static int search(int[] nums, int target) {
		
		int length = nums.length;
		int low = 0, high = length-1;
	
		if(nums == null || length == 0)return -1;
		while(low <= high)
		{
			int mid = low + (high-low)/2;
			if(nums[mid] == target)
				return mid;
			else if(nums[low] <= nums[mid])		//check whether the left half is sorted
			{
				if(nums[low] <= target && nums[mid] > target)	//check whether target lies in the left sorted array
				{
					high = mid - 1;
				}
				else
				{
					low = mid + 1;	// if target not found jump to right half
				}
			}
			else 		//right half is sorted
			{
				if(nums[mid] < target && nums[high] >= target)	//check whether target lies in the right sorted array
				{
					low = mid + 1;	
				}
				else
				{
					high = mid - 1;	// if target not found jump to left half
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {4,5,6,7,0,1,2};
		System.out.println(search(arr,2));
	}

}
