// Time Complexity : log(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I had trouble at first, but the lecture helped


// Your code here along with comments explaining your approach
public class Rotated_Array{

	public int search(int[] nums, int target) {
		if(nums == null || nums.length == 0){
			return -1;
		}
		int low = 0;
		int high = nums.length - 1;

		while(low <= high){
			int mid = low + (high - low)/2;
			if(nums[mid] == target){
				return mid;
			}
			else if(nums[low] <= nums[mid]){ //left is sorted
				if(nums[low] <= target && nums[mid] > target){ //if target is on the left side
					high = mid - 1;
				}
				else{ //not on left side
					low = mid + 1;
				}
			}
			else{ //right side sorted
				if(nums[mid] < target && nums[high] >= target){ //if target is on right side
					low = mid + 1;
				}
				else{
					high = mid - 1;
				}
			}
		}
		return -1;
	}
	
}



