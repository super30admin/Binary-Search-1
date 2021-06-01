// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
public:
    int search(vector<int>& nums, int target) 
    {
        int l = 0;
        int h = 1;
        while (nums[h] < target) {
            l = h;
            h = 2 * h;
        }
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                return nums[mid];
            } 
            else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return -1;
    }
};