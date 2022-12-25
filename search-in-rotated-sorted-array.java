// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
//Approach: Since atleast one part in a rotated sorted array is sorted we check which is that one. If it is left then we check if the target is present in the left side
//if not we change the range to right side. If the right side is sorted we check if the element is on the right side if not we change the range to left.

class Solution {
    public int search(int[] nums, int target) {

        int low =0;
        int high = nums.length -1;
        while (low<=high) {
            int mid = low + (high-low)/2;
            if (nums == null || nums.length == 0) {
             return -1;   
            }
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[low] <= nums[mid]) { //left sorted
                if (nums[mid] >= target && nums[low] <=  target) { //the target is 
                    high = mid -1;
                } else {
                    low = mid +1;
                }
            } else { //right sorted
                if (nums[mid] <= target && nums[high] >=  target) {
                    low = mid +1;
                } else {
                    high = mid -1;
                }
            }
        }
        return -1;
    }
}