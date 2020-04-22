// Time Complexity :O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left=0, right=nums.size()-1;
        while(left<=right)
        {
        int mid=(right+left)/2;
            if(target==nums[mid])
                return mid;
            else if(nums[mid]<=nums[right])
                {
                    if(target>nums[mid]&&target<=nums[right])
                        left=mid+1;
                    else
                        right=mid-1;
                }
            else
            {
                if(target>=nums[left]&&target<nums[mid])
                    right=mid-1;
                else
                    left=mid+1;
            }
        }
       return -1; 
    }
};