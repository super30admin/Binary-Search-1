// Time Complexity : Olog(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 * Implemented Binary Search Algorithm with certain checks
 * checks mid value if greater than low then check if target is between low and mid then make right ptr as mid + 1 else left ptr as mid -1
 * Else check if target is present between mid and right ptr then left ptr is mid + 1 if not then right ptr is mid - 1
 */

public class RotatedSortedArray {
    public int search(int[] nums, int target) {
        
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            if (nums[l] <= nums[mid] ) {
                if (nums[l] <= target && target < nums[mid] ) {
                    r = mid -1;
                } else {
                    l = mid + 1;
                }
              
            } else {
                if(nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}