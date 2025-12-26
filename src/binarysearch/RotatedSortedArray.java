/*
In rotated sorted array at least one size will be sorted, we will check which is side is
sorted first and also check if the target lies in that sorted side, if yes we do binary search on that side
else we repeat the same thing on the opp side
Time Complexity (average): O(log n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO
Space Complexity:
  O(1)
 */

package binarysearch;

public class RotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid  = low + (high - low)/2;
            if (nums[mid] == target) return mid;
            // if left side is sorted
            if (nums[low] <= nums[mid]){
                if( nums[low]<=target && nums[mid]>target){
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            // right side is sorted
            else if(nums[mid] < target){
                if(nums[high]>target && nums[mid]<target){
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return  -1;
    }
}
