// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
public:
    int search(vector<int>& nums, int target) 
    {
       int low = 0;
        int high = nums.size() - 1;

        while (low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[low]) {
                if (target <= nums[mid] && target >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;

                } else {
                    high = mid - 1;
                }
            }

        }
        return -1;
    }
};