// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* Since its a rotated sorted array after calculating mid we check whether the array is left or right sorted. If it is left sorted
   we check whether target lies in left sorted array. If yes we move high = mid - 1 else start = mid + 1 if it lies in unsorted part.
   Similarly we check if array is right sorted and perform similar checks to perform binary search in sorted part of array.
*/

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;

        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) /2 ;
            if(target == nums[mid])
                return mid;
            else if(nums[start] <= nums[mid]) {
                if(target >= nums[start] && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            else {
                if(target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}