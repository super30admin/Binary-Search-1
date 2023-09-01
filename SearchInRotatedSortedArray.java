// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*When a sorted array is rotated over a pivot element, we observed that at least one half of the array
is sorted. To male TC as O(log n), we have to find out the sorted side, check if the target lies 
in sorted half of the array. If yes, look in that half, if not, look in other half. */

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) return mid;
            if(nums[low] <= nums[mid]) {
                if(target < nums[mid] && target >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(target <= nums[high] && target > nums[mid]) {
                    low = mid+1;
                } else {
                    high = mid - 1;
                }
            }
        } return -1;
    }
}
