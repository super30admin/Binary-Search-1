// Time Complexity : O(log n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No 


// Your code here along with comments explaining your approach in three sentences only
// explained in the code. 
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int res = -1;
        int n = nums.size();
        if(n == 0) {
            return res;
        }
        int low = 0;
        int high = n - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[low] <= nums[mid]) { // check if the left to mid part of the array is sorted.
                if(nums[low] <= target && target < nums[mid]) { // check if the target lies in between low and mid.
                    high = mid - 1;
                } else { // else move to the other side of the search space. 
                    low = mid + 1;
                }
            } else { // else the other part is sorted. ie mid to right is sorted.
                if(nums[mid] < target && target <= nums[high]) { //  check if target exists in this portion 
                    low = mid + 1;
                } else { // else look for target in the other portion. 
                    high = mid - 1;
                }
            }
        }
        return res;
    }
};
