/**
 * Time Complexity : O(logn) where n is the size of array nums
 * Space Complexity : O(n^2)
 * Approach : Binary Search
 */

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        
        return search(nums, target, 0, nums.length - 1);
    }
    
    public int search(int[] nums, int target, int low, int high) {
        int mid = (low + high) / 2;
        
         if (low > high) {
            return -1;
        }
        
        if (nums[mid] == target) {
            return mid;
        }
        
        
        if (nums[low] <= nums[mid]) {
            if (nums[low] <= target && nums[mid] >= target)
                return search(nums, target, low, mid - 1);    
            else return search(nums, target, mid + 1, high);
        }
        
	
        if (nums[mid] <= target && nums[high] >= target)
            return search(nums, target, mid + 1, high);
        else return search(nums, target, low, mid - 1);
    }
}