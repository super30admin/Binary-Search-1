//Time Complexity - O(logn)
//Space Complexity - O(1)
//Worked on Leetcode
// Atleast one half of a Rotated sorted array is sorted array.
//https://leetcode.com/problems/search-in-rotated-sorted-array/
class Solution {
    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length-1;
        int mid;
        while(low <= high){
            mid = low + (high-low)/2;
            if(nums[mid] == target) return mid;
            //check f0r left sorted array
            if(nums[low] <= nums[mid]){
            	if(nums[low] <= target && target < nums[mid] ) {
	                high = mid-1;
            	}else {
            		low = mid + 1;
            	}
            }else { // right sorted array
            	if(nums[mid] < target && target <= nums[high] ) {
	                low = mid + 1;
            	}else {
            		high = mid - 1;
            	}
            }
        }
        return -1;
    }
}
