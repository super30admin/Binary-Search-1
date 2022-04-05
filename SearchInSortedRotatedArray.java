/**
Problem: search in a sorted rotated array
https://leetcode.com/problems/search-in-rotated-sorted-array/


Time Complexity : log (n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : No
*/

class SearchInSortedRotatedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        
        if (n == 0) {
            return -1;
        }
        
        int low = 0, high = n - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            if (nums[low] <= nums[mid]) {
                // this is the sorted part
                // check if target lies in the sorted part.
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // this is the sorted part.
                // check if target lies in the sorted part.
                if (target >= nums[mid + 1] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return - 1;
    }
}