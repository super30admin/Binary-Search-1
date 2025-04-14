// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int search(int[] nums, int target) {
        // base case
        if(nums == null || nums.length == 0) return -1;

        // perform binary search as below
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            if(nums[low] <= nums[mid]) { // this means left side is sorted
                if(nums[low] <= target && target < nums[mid]) { // this means target lies on left side so move high pointer as below
                    high = mid - 1;
                }
                else { // this means target lies on right side so move low pointer as below
                    low = mid + 1;
                }
            }
            else { // this means right side is sorted
                if(nums[mid] < target && target <= nums[high]) { // this means target lies on right side so move low pointer as below
                    low = mid + 1;
                }
                else { // this means target lies on left side so move high pointer as below
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}