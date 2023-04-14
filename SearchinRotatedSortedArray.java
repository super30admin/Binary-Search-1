// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only
/*
 * Running through few example we know that one of the arrays will be sorted 
 * we could keep on checking if target lies in the given range
 * else update mid
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length < 1) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
             int mid = low + (high - low) / 2;
             if(nums[mid] == target) { 
                return mid;
             }
             if(nums[low] <= nums[mid]) {
                if(target >= nums[low] && target < nums[mid]) {
                    high = mid - 1; 
                } else {
                    low = mid + 1;
                }
             } else {
                if(target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1; 
                }
             }
        }
        return -1;
    }
}
