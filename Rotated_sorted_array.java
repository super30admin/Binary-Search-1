// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Check which half of the array is sorted by partitioning the array into two halves
check for the target in the sorted half
*/
class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid;

        while (low <= high) {
            //calculate the mid element
            mid = (low + high) / 2;

            if (target == nums[mid]) return mid;

            // check the target in left or right array
            if (nums[low]<=nums[mid]) {
                // left array is sorted
                if (target < nums[mid] && target >= nums[low]) {
                    high = mid - 1; // target lies in left half
                } else {
                    low = mid + 1; //target lies in right half
                }
            } else {
                // right array is sorted
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1; //target is in right half
                } else {
                    high = mid - 1; //target is in left half
                }
            }
        }
        return -1; //target not found
    }
}
