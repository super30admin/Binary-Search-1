// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int BS(vector<int>& nums, int l, int r, int target) {
        while(l <= r)   {
            int mid = l+(r-l)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < nums[r])    {   //sorted on the right side  
                if(target > nums[mid] && target <= nums[r])  l = mid+1;
                else    r = mid-1;
            }
            else    {   //sorted on the left side
                if(target < nums[mid] && target >= nums[l])  r = mid-1;
                else    l = mid+1;
            }
        }
        return -1;
    }
public:
    int search(vector<int>& nums, int target) {
        return BS(nums, 0, nums.size()-1, target);
    }
};