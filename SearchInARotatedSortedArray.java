package binarySearch1;

public class SearchInARotatedSortedArray {
	// Time Complexity : O(log n)
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : Finding the smallest in the array and deciding
	// the upper and figuring out the else if and else part of binary search
	public int search(int[] nums, int target) {
        if(nums.length == 1)
            return nums[0] == target ? 0 : -1;
        
        int idx = findMin(nums, 0, nums.length - 1);
        
        int left = 0, right = nums.length - 1;
        if(target >= nums[idx] && target <= nums[right])
            left = idx;
        else
            right = idx - 1;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(target == nums[mid])
                return mid;
            else if(target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        
        return -1;
    }
    
    private int findMin(int[] nums, int left, int right) {
        if(nums[left] < nums[right])
            return 0;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid + 1] < nums[mid])
                return mid + 1;
            else if(nums[mid] >= nums[left])
                left = mid + 1;
            else
                right = mid - 1;
        }
        
        return 0;
    }
}
