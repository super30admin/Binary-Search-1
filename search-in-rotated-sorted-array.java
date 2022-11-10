// Time Complexity : O(n*logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//https://leetcode.com/problems/search-a-2d-matrix/

// Your code here along with comments explaining your approach in three sentences only
//I performed kinda Binary Search by eliminating the rest of the sequences by searching
//the element in the sorted part of the array and there by landing on the required element;

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid])
                return mid;
            // left sorted
            if (nums[l] < nums[mid]) {
                if (target < nums[mid] && target >= nums[l])
                    r = mid;
                else
                    l = mid + 1;
            }
            // right sorted
            else {
                if (target > nums[mid] && target < nums[l])
                    l = mid + 1;
                else
                    r = mid;
            }
        }
        return -1;
    }
}