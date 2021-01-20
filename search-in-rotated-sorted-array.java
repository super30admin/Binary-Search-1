// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int mid = low + (high - low ) / 2;
            if(nums[mid] == target)
                return mid;
            //find if sorted array is on left of mid do binary search there
            else if(nums[low] <= nums[mid]) {
                if(target >= nums[low] && target < nums[mid]) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } 
            //if sorted array is on right of mid
            else {
                if(target <= nums[high] && target > nums[mid]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
