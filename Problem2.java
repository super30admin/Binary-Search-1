// Time Complexity - O(LogN)
// Space Complexity - O(1)

import java.util.*;
public class Infinite_Array {
	public static void main(String args[]) {
		int[] nums = {3,5,7,10,11,15,16,17,18,19};
		int target = 15;
		System.out.println(find_target(nums,target));
	}
	
	private static int find_target(int[] nums,int target) {
		int low = 0;
		int high = 1;
		while(low <= high) {
			if(target >= nums[low] && target <= nums[high]) {
				while(low <= high) {
					int mid = low + (high-low)/2;
					if(nums[mid] == target)	return mid;
					if(nums[mid] > target) {
						high = mid - 1;
					}
					else {
						low = mid + 1;
					}
				}	
			}
			else {
        if(nums[low] > target)	return -1;
				low = high;
				high = high * 2;
			}
		}
		return -1;
	}
	
}
