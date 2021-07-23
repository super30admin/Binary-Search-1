// Time Complexity : O(logN)
// Space Complexity : O(1) as I didn't use any extra space, just the temporary variables
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
// Submission Link: https://leetcode.com/submissions/detail/526793424/

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int start = 0, end = nums.size() - 1;
        int mid;
        
        while(start <= end){
            mid = (start + end)/2;
            
            if(target == nums[mid])
                return mid;
            
            // Check if first half of the array is sorted
            if(nums[start] <= nums[mid]){
                // If the target lies in first half shift end to mid - 1 else start to mid + 1
                if(nums[start] <= target && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            else{
                if(nums[mid] < target && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        
        return -1;
    }
};