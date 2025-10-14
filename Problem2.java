// 33. Search in a Rotated Array

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) return mid;

            // Step 1: Identify which half is sorted
            if (nums[low] <= nums[mid]) {  
                // Step 2: Check if target lies in left half
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {  // Right half is sorted
                // Step 3: Check if target lies in right half
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}


// Time Complexity : O(Log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I missed checking the value is pressent on the left side of mid and again checkin fthe righ side. 


// Your code here along with comments explaining your approach in three sentences only
// Set Low and High to start and ending of the array. Figure the Mid
// Check which side is sorted from both, Low is less than mid then left side is shorter
// After Getting Shorter side choose if the target value lies on which side and do binary search on same. 