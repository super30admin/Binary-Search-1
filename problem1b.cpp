// Time Complexity : T(n) = O(logn)
// Space Complexity :S(n)=O(1)
// Did this code successfully run on Leetcode :yes


class Solution {
public:
    int search(vector<int>& nums, int target) 
    {
        int low=0;
        int high=nums.size()-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            if(nums[low]<=nums[mid])
            {
                if(nums[mid]>target && nums[low]<=target)
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            else
            {
                if(nums[mid]<target && nums[high]>=target )
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
        }
        return -1;
    }
};
